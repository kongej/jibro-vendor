package com.jibro.vendor.service;

import com.jibro.vendor.dto.product.ProductResponseDto;

/**
 * @author ljy
 * @since 2024.05.21
 * Product Service 코드
 * **/
public interface ProductService {
	
	/* 출고해야 하는 제품 상세 받아오기 */
	ProductResponseDto getProduct(String orderId);

}
