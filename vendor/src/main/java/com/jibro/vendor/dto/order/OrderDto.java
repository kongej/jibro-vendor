package com.jibro.vendor.dto.order;

/**
 * @author ljy
 * @since 2024.05.21
 * Order 기본 dto 코드
 **/
public class OrderDto {

	/* 주문번호(pk, yymmdd_001) */
	private String orderId;

	/* 거래처명(풀필먼트) */
	private String companyName;

	/* 요청수량 */
	private Integer vendorQuantity;

	/* 제품번호(fk) */
	private String productId;
	
}
