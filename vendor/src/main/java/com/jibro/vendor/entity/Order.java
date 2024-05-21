package com.jibro.vendor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
 * @since 2024.05.21 Order entity 코드
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "product", "ongoing" })
@EqualsAndHashCode
@Builder
@Table(name = "vendor_order")
public class Order extends BaseEntity {

	/* 주문번호(pk, yymmdd_001) */
	@Id
	@Column(name = "order_id", length = 50)
	private String orderId;

	/* 거래처명(풀필먼트) */
	@Column(name = "company_name", length = 20, nullable = false)
	private String companyName;

	/* 요청수량 */
	@Column(name = "vendor_quantity", nullable = false)
	private Integer vendorQuantity;

	/* product 외래키 지정(ManyToOne) : toString 제외 */
	@ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	/*
	 * 제품번호(fk)
	 * 
	 * @Column(name = "product_id") private String productId;
	 * 
	 * productId만 넣어도 엔티티 객체 생성 가능하도록 조치 public Order(String productId) {
	 * this.productId = productId; }
	 */

	/* OneToOne 양방향 관계 매핑(ongoing) : toString 제외 */
	@OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
	private Ongoing ongoing;
}
