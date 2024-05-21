package com.jibro.vendor.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jibro.vendor.dto.ongoing.OngoingCreateDto;
import com.jibro.vendor.dto.ongoing.OngoingResponseDto;
import com.jibro.vendor.repository.OngoingRepository;
import com.jibro.vendor.repository.OrderRepository;
import com.jibro.vendor.service.OngoingService;

/**
 * @author ljy
 * @since 2024.05.21
 * Ongoing Service 코드
 * **/
@Service
public class OngoingServiceImpl implements OngoingService {
	// 로그 설정
	private final Logger LOGGER = LoggerFactory.getLogger(OngoingServiceImpl.class);
	// 필요 레포지토리 연결
	private final OngoingRepository ongoingRepository;
	
	// 의존성 주입(di)
	@Autowired
	public OngoingServiceImpl(OngoingRepository ongoingRepository) {
		this.ongoingRepository = ongoingRepository;
	}

	/* 출고 리스트 조회 */ 
	@Override
	public List<OngoingResponseDto> getOngoingList() {
		// TODO Auto-generated method stub
		return null;
	}

	/* 출고 신규 생성 */
	@Override
	public String createOngoing(OngoingCreateDto ongoingCreateDto) {
		// TODO Auto-generated method stub
		return null;
	}
		
		
}
