package com.jibro.vendor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


/**
 * @author ljy
 * @since 2024.05.21
 * Order entity 코드
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

	/* 출고 진행했는지 여부 (미완 0, 완료 1) */
	@Column(name = "order_status", nullable = false, columnDefinition = "int default 0") //
	@Builder.Default
	private Integer orderStatus = 0;//
	
	/* product 외래키 지정(ManyToOne) : toString 제외 */
	@ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	/* OneToOne 양방향 관계 매핑(ongoing) : toString 제외 */
	@OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
	private Ongoing ongoing;
}
