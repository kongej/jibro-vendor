package com.jibro.vendor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jibro.vendor.service.OngoingService;

/**
 * @author ljy
 * @since 2024.05.21
 * Ongoing Controller 코드
 * Vendor 내부용 컨트롤러 (외부 api 제공 x)
 * **/
@Controller
public class OngoingController {
	// 로그 설정
	private final Logger LOGGER = LoggerFactory.getLogger(OngoingController.class);
	
	// 의존성 주입(OngoingService)
	@Autowired
	private OngoingService ongoingService;
		
		
}
