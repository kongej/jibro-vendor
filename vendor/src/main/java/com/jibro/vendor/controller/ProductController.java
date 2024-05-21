package com.jibro.vendor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jibro.vendor.service.ProductService;

/**
 * @author ljy
 * @since 2024.05.21
 * Product Controller 코드
 * Vendor 내부용 컨트롤러 (외부 api 제공 x)
 * **/
@Controller
public class ProductController {
	// 로그 설정
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	// 의존성 주입(ProductService)
	@Autowired
	private ProductService productService;
	
	/* 출고해야 하는 제품 상세 받아오기 */
	@GetMapping("/ongoing/create")
	public ModelAndView getProduct() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/ongoing/create");
		return mav;
	}
}