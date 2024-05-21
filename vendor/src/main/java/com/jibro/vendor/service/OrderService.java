package com.jibro.vendor.service;

import java.util.List;

import com.jibro.vendor.dto.order.OrderResponseDto;

/**
 * @author ljy
 * @since 2024.05.21
 * Order Service 코드
 * **/
public interface OrderService {
	
	/* 주문 리스트 조회 */
	List<OrderResponseDto> getOrderList();
	
}
