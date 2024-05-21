package com.jibro.vendor.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ljy
 * @since 2024.05.21
 * Product 기본 dto 코드
 * **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {

	/* 제품번호(pk) */
	private String productId;
	
	/* 제품명 */
	private String product;
	
	/*  원가 */
	private Integer primeCost;
	
}
