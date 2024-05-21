package com.jibro.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jibro.vendor.entity.Product;

/**
 * @author ljy
 * @since 2024.05.21
 * 제품 관련 repository 코드
 * **/
public interface ProductRepository extends JpaRepository<Product, String> {
	
}

