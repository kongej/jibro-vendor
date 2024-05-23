package com.jibro.vendor.service;

import java.util.List;

import com.jibro.vendor.dto.api.OrderApiDto;
import com.jibro.vendor.dto.order.OrderResponseDto;
import com.jibro.vendor.dto.product.ProductOrderDto;

/**
 * @author ljy
 * @since 2024.05.21
 * Order Service 코드
 * **/
public interface OrderService {
	
	/* 주문 리스트 조회 */
	List<OrderResponseDto> getOrderList();
	
	/* 신규 출고 생성을 위해 필요한 데이터 조회 */ 
	ProductOrderDto makeOrder(String orderId);

	/* Api에서 받아온 데이터 DB에 저장 */
	void insertOrder(OrderApiDto orderApiDto);
}
