package com.jibro.vendor.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jibro.vendor.dto.order.OrderResponseDto;
import com.jibro.vendor.repository.OrderRepository;
import com.jibro.vendor.service.OrderService;

/**
 * @author ljy
 * @since 2024.05.21
 * Order Service 코드
 * **/
@Service
public class OrderServiceImpl implements OrderService {
	// 로그 설정
	private final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
	// 필요 레포지토리 연결
	private final OrderRepository orderRepository;
	
	// 의존성 주입(di)
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	/* 주문 리스트 조회 */
	@Override
	public List<OrderResponseDto> getOrderList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
