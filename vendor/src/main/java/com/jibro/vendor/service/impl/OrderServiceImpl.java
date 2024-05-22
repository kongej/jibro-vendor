package com.jibro.vendor.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jibro.vendor.dto.order.OrderResponseDto;
import com.jibro.vendor.dto.product.ProductOrderDto;
import com.jibro.vendor.entity.Order;
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
		LOGGER.info("[getOrderList] call getOrderList()");
		
		// order 리스트 db에서 받아오기
		List<Order> orderList = this.orderRepository.findAll();
		LOGGER.info("[getOrderList] return orderList : {}", orderList.size());
		
		// dto 형태로 변환시켜 세팅
		List<OrderResponseDto> returnOrderList = new ArrayList<OrderResponseDto>();
		
		// orderList 각 객체 dto 형태로 바꿔 매핑
		orderList.forEach(order -> {
			OrderResponseDto orderResponseDto = new OrderResponseDto();
			
			// 주문 id
			orderResponseDto.setOrderId(order.getOrderId());
			// 입고 요청 수량
			orderResponseDto.setVendorQuantity(order.getVendorQuantity());
			// 거래처 명
			orderResponseDto.setCompanyName(order.getCompanyName());
			// 주문 들어온 일자
			orderResponseDto.setCreatedAt(order.getCreatedAt());
			// 주문 업데이트된 일자
			orderResponseDto.setUpdatedAt(order.getUpdatedAt());
			// 출고 진행 여부
			orderResponseDto.setOrderStatus(order.getOrderStatus());
			// 주문한 상품 id
			orderResponseDto.setProductId(order.getProduct().getProductId());
			// 주문 상품명
			orderResponseDto.setProduct(order.getProduct().getProduct());
		
			// returnOrderList에 저장
			returnOrderList.add(orderResponseDto);
		});
		LOGGER.info("[getOrderList] set returnOrderList : {}", returnOrderList.size());
		
		return returnOrderList;
	}
	
	/* 출고해야 하는 제품 상세 받아오기 */
	@Override
	public ProductOrderDto makeOrder(String orderId) throws NoSuchElementException {
		LOGGER.info("[getProduct] input orderId : {}", orderId);
		
		ProductOrderDto returnProductInfo = new ProductOrderDto();
		
		Order order = this.orderRepository.findById(orderId).orElseThrow();
		
		// 주문코드
		returnProductInfo.setOrderId(orderId);
		// 거래처명
		returnProductInfo.setCompanyName(order.getCompanyName());
		// 주문 수량
		returnProductInfo.setVendorQuantity(order.getVendorQuantity());
		// 주문 날짜
		returnProductInfo.setCreatedAt(order.getCreatedAt());
		// 주문한 상품 Id
		returnProductInfo.setProductId(order.getProduct().getProductId());
		// 주문한 상품명
		returnProductInfo.setProduct(order.getProduct().getProduct());
		// 주문한 상품 원가
		returnProductInfo.setPrimeCost(order.getProduct().getPrimeCost());
		// 이미지
		returnProductInfo.setImg(order.getProduct().getImg());
		
		LOGGER.info("[getProduct] set ProductOrderDto : {}", returnProductInfo);
		return returnProductInfo;
	}
	
}
