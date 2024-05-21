package com.jibro.vendor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jibro.vendor.dto.ongoing.OngoingCreateDto;
import com.jibro.vendor.dto.ongoing.OngoingResponseDto;
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
	
	/* 출고 리스트 조회 */
	@GetMapping("/ongoing/list")
	public ModelAndView getOngoingList() {
		ModelAndView mav = new ModelAndView();
		
		List<OngoingResponseDto> ongoingResponseDto = this.ongoingService.getOngoingList();
		
		mav.addObject("ongoingResponseDto", ongoingResponseDto);
		mav.setViewName("/ongoing/list");
		return mav;
	}
	
	/* 출고 신규 생성 */
	@PostMapping("/ongoing/create")
	public String createOngoing(OngoingCreateDto ongoingCreateDto) {
		String nextPath = "redirect:/ongoing/list";
		
		String result = this.ongoingService.createOngoing(ongoingCreateDto);
		
		return nextPath;
	}
}
