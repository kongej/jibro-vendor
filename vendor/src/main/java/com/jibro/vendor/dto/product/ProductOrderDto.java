package com.jibro.vendor.dto.product;

/**
 * @author ljy
 * @since 2024.05.21
 * 출고 화면 들어갔을 시 제품 상세, 주문 정보 담아 전달하는 역할
 * **/
public class ProductOrderDto {

	/* 제품번호(pk) */
	private String productId;
	
	/* 제품명 */
	private String product;
	
	/*  원가 */
	private Integer primeCost;
	
}