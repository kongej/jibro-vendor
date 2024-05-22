package com.jibro.vendor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jibro.vendor.dto.ongoing.OngoingCreateDto;
import com.jibro.vendor.dto.ongoing.OngoingResponseDto;
import com.jibro.vendor.entity.Ongoing;
import com.jibro.vendor.entity.Order;
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
			ongoingResponseDto.setSendOngoing(ongoing.getSendOngoing());
			
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
			
			/* 요청수량 */
			ongoingResponseDto.setVendorQuantity(ongoing.getOrder().getVendorQuantity());
			
			/* 풀필먼트 측에 실제로 보낸 제품 수량 */
			ongoingResponseDto.setRealQuantity(ongoing.getRealQuantity());
			
			/* 출고 날짜 */
			ongoingResponseDto.setCreatedAt(ongoing.getCreatedAt());
			
			/* 출고 상태 갱신 날짜 */
			ongoingResponseDto.setUpdatedAt(ongoing.getUpdatedAt());
			
			returnOngoingList.add(ongoingResponseDto);
			LOGGER.info("[getOngoingList] change ongoingResponseDto : {}", ongoingResponseDto);
			
		});
		
		LOGGER.info("[getOngoingList] change ongoingList to List<OngoingResponseDto> : {}", returnOngoingList.size());
		
		return returnOngoingList;
	}

	/* 출고 신규 생성 */
	// @Transactional // 중간에 에러 발생 시 모든 변경사항 롤백
	@Override
	public String createOngoing(OngoingCreateDto ongoingCreateDto) {
		LOGGER.info("[createOngoing] input ongoingCreateDto : {}", ongoingCreateDto);
		Ongoing ongoing = new Ongoing();
		
		// 주문 정보 찾고, 없으면 예외처리
		Order order = this.orderRepository.findById(ongoingCreateDto.getOrderId()).orElseThrow();
		LOGGER.info("[createOngoing] find order : {}", order);
		
		// ongoing 객체 생성
		ongoing.setOrder(order);
		ongoing.setRealQuantity(ongoingCreateDto.getSelectedCount());
		ongoing.setTotalCost(ongoingCreateDto.getSelectedCount() * order.getProduct().getPrimeCost());
		LOGGER.info("[createOngoing] set TotalCost : {}", ongoing.getTotalCost());
		
		// ongoing 객체 저장
		Ongoing savedOngoing = this.ongoingRepository.save(ongoing);
		LOGGER.info("[createOngoing] save ongoing : {}", ongoing);
		
		// 해당 주문 상태 1로 업데이트
		order.setOrderStatus(1);
		this.orderRepository.save(order);
		LOGGER.info("[createOngoing] update order status to 1 : {}", order);
		
		return savedOngoing.getOngoingId().toString();
	}
		
}
