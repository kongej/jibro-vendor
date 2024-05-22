package com.jibro.vendor.dto.order;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ljy
 * @since 2024.05.21
 * Order 기본 dto 코드
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderResponseDto {

	/* 주문번호(pk, yymmdd_001) */
	private String orderId;

	/* 거래처명(풀필먼트) */
	private String companyName;

	/* 요청수량 */
	private Integer vendorQuantity;

	/* 제품번호(fk) */
	private String productId;
	
	/* 제품 이름 */
	private String product;
	
	/* 출고 진행했는지 여부 (미완 0, 완료 1) */
	private int orderStatus;
	
	/* 주문 날짜 */
	private LocalDateTime createdAt;
	
	/* 주문 갱신 날짜 */
	private LocalDateTime updatedAt;
	
}
