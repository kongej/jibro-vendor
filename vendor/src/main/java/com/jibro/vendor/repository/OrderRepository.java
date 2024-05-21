package com.jibro.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jibro.vendor.entity.Order;

/**
 * @author ljy
 * @since 2024.05.21
 * 주문 관련 repository 코드
 * **/
public interface OrderRepository  extends JpaRepository<Order, String>{

}
