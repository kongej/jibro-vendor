package com.jibro.vendor.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ljy
 * @since 2024.05.21
 * Product entity 코드
 * **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "orderList")
@EqualsAndHashCode
@Builder
@Table(name = "vendor_product")
public class Product extends BaseEntity {
	
	/* 제품번호(pk) */
	@Id
	@Column(name="product_id", length = 50)
	private String productId;
	
	/* 제품명 */
	@Column(name = "product", nullable = false, length = 255)
	private String product;
	
	/*  원가 */
	@Column(name = "prime_cost", nullable = false)
	private Integer primeCost;
	
	/* 이미지 */
	@Column(name = "img", length = 255)
	private String img;
	
	/* order 엔티티와 OneToMany 매핑 */ 
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private List<Order> orderList = new ArrayList<>();
	
}
