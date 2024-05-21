package com.jibro.vendor.service;

import java.util.List;

import com.jibro.vendor.dto.ongoing.OngoingCreateDto;
import com.jibro.vendor.dto.ongoing.OngoingResponseDto;

/**
 * @author ljy
 * @since 2024.05.21
 * Ongoing Service 코드
 * **/
public interface OngoingService {
	
	/* 출고 리스트 조회 */ 
	List<OngoingResponseDto> getOngoingList();
	
	/* 출고 신규 생성 */
	String createOngoing(OngoingCreateDto ongoingCreateDto);
	
}
