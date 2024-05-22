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
public class OngoingCreateDto {

	/* 선택 수량 */
	private Integer selectedCount;

	/* 주문번호(fk)*/
	private String orderId;
	
}
