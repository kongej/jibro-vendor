package com.jibro.vendor.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jibro.vendor.dto.ongoing.OngoingCreateDto;
import com.jibro.vendor.dto.ongoing.OngoingResponseDto;
import com.jibro.vendor.dto.product.ProductOrderDto;
import com.jibro.vendor.entity.Ongoing;
import com.jibro.vendor.entity.Order;
import com.jibro.vendor.entity.Product;
import com.jibro.vendor.repository.OngoingRepository;
import com.jibro.vendor.repository.OrderRepository;
import com.jibro.vendor.repository.ProductRepository;
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
	private final OrderRepository orderRepository;
	
	// 의존성 주입(di)
	@Autowired
	public OngoingServiceImpl(OngoingRepository ongoingRepository, OrderRepository orderRepository) {
		this.ongoingRepository = ongoingRepository;
		this.orderRepository = orderRepository;
	}

	/* 출고 리스트 조회 */ 
	@Override
	public List<OngoingResponseDto> getOngoingList() {
		LOGGER.info("[getOngoingList] call getOngoingList()");
		
		// ongoing 리스트 db에서 받아오기
		List<Ongoing> ongoingList = this.ongoingRepository.findAll();
		LOGGER.info("[getOngoingList] return ongoingList : {}", ongoingList.size());
		
		// dto 형태로 변환시켜 세팅
		List<OngoingResponseDto> returnOngoingList = new ArrayList<OngoingResponseDto>();
		
		ongoingList.forEach(ongoing -> {
			OngoingResponseDto ongoingResponseDto = new OngoingResponseDto();
			
			/* 출고번호(pk)(auto_increment) */
			ongoingResponseDto.setOngoingId(ongoing.getOngoingId());
			
			/* 풀필먼트 측에 출고 정보 넘겼는지 여부 */
			ongoingResponseDto.setSendOngoing(ongoingResponseDto.getSendOngoing());
			
			/* 주문번호(fk)*/
			ongoingResponseDto.setOrderId(ongoing.getOrder().getOrderId());
			
			/* 주문 거래처명 */
			ongoingResponseDto.setCompanyName(ongoing.getOrder().getCompanyName());
			
			/* 주문 들어온 날짜 */
			ongoingResponseDto.setOrderCreatedAt(ongoing.getOrder().getCreatedAt());
			
			/* 제품번호 */
			ongoingResponseDto.setProductId(ongoing.getOrder().getProduct().getProductId());
			
			/* 제품 이름 */
			ongoingResponseDto.setProduct(ongoing.getOrder().getProduct().getProduct());
			
			/* 출고 날짜 */
			ongoingResponseDto.setCreatedAt(ongoing.getCreatedAt());
			
			/* 출고 상태 갱신 날짜 */
			ongoingResponseDto.setUpdatedAt(ongoing.getUpdatedAt());
			
			returnOngoingList.add(ongoingResponseDto);
			
		});
		
		LOGGER.info("[getOngoingList] changet ongoingList to List<OngoingResponseDto> : {}", returnOngoingList.size());
		
		return returnOngoingList;
	}

	/* 출고 신규 생성 */
	@Override
	public String createOngoing(OngoingCreateDto ongoingCreateDto) {
		LOGGER.info("[createOngoing] input ongoingCreateDto : {}", ongoingCreateDto);
		Ongoing ongoing = new Ongoing();
		
		Order order = this.orderRepository.findById(ongoingCreateDto.getOrderId()).orElseThrow();
		LOGGER.info("[createOngoing] find order : {}", order);
		
		ongoing.setOrder(order);
		ongoing.setRealQuantity(ongoingCreateDto.getProductCount());
		
		Ongoing savedOngoing = this.ongoingRepository.save(ongoing);
		LOGGER.info("[createOngoing] save ongoing : {}", ongoing);
		
		return savedOngoing.getOngoingId().toString();
	}
		
}
