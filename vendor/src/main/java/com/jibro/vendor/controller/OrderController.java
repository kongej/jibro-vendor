package com.jibro.vendor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.jibro.vendor.dto.order.OrderResponseDto;
import com.jibro.vendor.dto.product.ProductOrderDto;
import com.jibro.vendor.service.OrderService;

/**
 * @author ljy
 * @since 2024.05.21
 * Order Controller 코드
 * Vendor 내부용 컨트롤러 (외부 api 제공 x)
 * **/
@Controller
public class OrderController {
	// 로그 설정
	private final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	// 의존성 주입(OrderService)
	@Autowired
	private OrderService orderService;
	
	/* 주문 리스트 조회 */
	@GetMapping("/order/list")
	public ModelAndView getOrderList() {
		LOGGER.info("[getOrderList] call getOrderList()");
		ModelAndView mav = new ModelAndView();
		
		List<OrderResponseDto> orderList = this.orderService.getOrderList();
		LOGGER.info("[getOrderList] return orderList : {}", orderList.size());
		
		mav.addObject("orderList", orderList);
		mav.setViewName("order/list");
		return mav;
	}
	
	/* 출고해야 하는 제품 & 주문 상세 받아오기 */
	@GetMapping("/ongoing/create/{orderId}")
	public ModelAndView makeOngoing(
			@PathVariable String orderId) {
		LOGGER.info("[getProduct] @PathVariable orderId : {}", orderId);
		ModelAndView mav = new ModelAndView();
		
		ProductOrderDto productOrderDto = this.orderService.makeOrder(orderId);
		LOGGER.info("[getProduct] return productOrderDto : {}", productOrderDto);
		
		mav.addObject("productOrderDto", productOrderDto);
		mav.setViewName("ongoing/create");
		return mav;
	}
}
