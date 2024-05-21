package com.jibro.vendor.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jibro.vendor.repository.ProductRepository;
import com.jibro.vendor.service.ProductService;

/**
 * @author ljy
 * @since 2024.05.21
 * Product Service 코드
 * **/
@Service
public class ProductServiceImpl implements ProductService {
	// 로그 설정
	private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	// 필요 레포지토리 연결
	private final ProductRepository productRepository;
	
	// 의존성 주입(di)
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
}
