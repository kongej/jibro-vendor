package com.jibro.vendor.dto.product;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ljy
 * @since 2024.05.21
 * 출고 화면 들어갔을 시 제품 상세, 주문 정보 담아 전달하는 역할
 * **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductOrderDto {
	
	/* 주문번호(pk, yymmdd_001) */
	private String orderId;

	/* 거래처명(풀필먼트) */
	private String companyName;

	/* 요청수량 */
	private Integer vendorQuantity;
	
	/* 주문 날짜 */
	private LocalDateTime createdAt;

	/* 제품번호(pk) */
	// private String productId;
	
	/* 제품명 */
	private String product;
	
	/*  원가 */
	private Integer primeCost;
	
}