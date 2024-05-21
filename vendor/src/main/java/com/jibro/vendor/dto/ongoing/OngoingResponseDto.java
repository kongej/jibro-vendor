package com.jibro.vendor.dto.ongoing;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ljy
 * @since 2024.05.21 
 * Ongoing Response dto 코드
 * ongoing list 볼 때 사용
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OngoingResponseDto {
	
	/* 출고번호(pk)(auto_increment) */
	private Long ongoingId;

	/* 풀필먼트 측에 출고 정보 넘겼는지 여부 */
	private Integer sendOngoing;

	/* 주문번호(fk)*/
	private String orderId;
	
	/* 주문 거래처명 */
	private String companyName;
	
	/* 주문 들어온 날짜 */
	private LocalDateTime orderCreatedAt;
	
	/* 제품번호 */
	private String productId;
	
	/* 제품 이름 */
	private String product;
	
	/* 출고 날짜 */
	private LocalDateTime createdAt;
	
	/* 출고 상태 갱신 날짜 */
	private LocalDateTime updatedAt;
	
	
}
