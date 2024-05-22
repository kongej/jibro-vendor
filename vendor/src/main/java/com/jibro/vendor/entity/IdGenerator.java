package com.jibro.vendor.entity;

import org.aspectj.weaver.ast.Or;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.time.LocalDate;

public class IdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String formattedDate = LocalDate.now().toString().replace("-", "");

        // "orderId" 필드를 사용하는 쿼리 작성
        String queryStr = String.format("select count(o.orderId) from %s o where o.orderId like :prefix", object.getClass().getSimpleName());
        Query<Long> query = session.createQuery(queryStr, Long.class);
        query.setParameter("prefix", formattedDate + "%");
        Long count = query.uniqueResult();

        int num = 1;
        if (count != null) {
            String queryStr1 = String.format("select max(o.orderId) from %s o where o.orderId like :prefix", object.getClass().getSimpleName());
            Query<String> query1 = session.createQuery(queryStr1, String.class);
            query1.setParameter("prefix", formattedDate + "%");
            String maxId = query1.uniqueResult();
            if (maxId != null) {
                String maxIdStr = maxId.toString();
                num = Integer.parseInt(maxIdStr.substring(maxIdStr.lastIndexOf("_") + 1)) + 1;
            }
        }

        String suffix = String.format("%03d", num);

        return formattedDate + "_" + suffix;
    }
}
