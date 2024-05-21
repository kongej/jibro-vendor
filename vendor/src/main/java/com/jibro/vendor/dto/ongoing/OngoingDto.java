package com.jibro.vendor.dto.ongoing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ljy
 * @since 2024.05.21 
 * Ongoing 기본 dto 코드
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OngoingDto {
	
	/* 출고번호(pk)(auto_increment) */
	private Long ongoingId;

	/* 풀필먼트 측에 출고 정보 넘겼는지 여부 */
	private Integer sendOngoing;

	/* 주문번호(fk)*/
	private String orderId;
}
