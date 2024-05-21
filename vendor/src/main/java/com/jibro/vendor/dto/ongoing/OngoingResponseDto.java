package com.jibro.vendor.dto.ongoing;

/**
 * @author ljy
 * @since 2024.05.21 
 * Ongoing Response dto 코드
 **/
public class OngoingResponseDto {
	
	/* 출고번호(pk)(auto_increment) */
	private Long ongoingId;

	/* 풀필먼트 측에 출고 정보 넘겼는지 여부 */
	private Integer sendOngoing = 0;

	/* 주문번호(fk)*/
	private String orderId;
}
