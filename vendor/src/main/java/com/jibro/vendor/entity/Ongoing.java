package com.jibro.vendor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @since 2024.05.21 
 * Ongoing entity 코드
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "order")
@EqualsAndHashCode
@Builder
@Table(name = "vendor_ongoing")
public class Ongoing extends BaseEntity {

	/* 출고번호(pk)(auto_increment) */
	@Id
	@Column(name = "ongoing_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ongoingId;

	/* 풀필먼트 측에 출고 정보 넘겼는지 여부 */
	@Column(name = "send_ongoing", nullable = false, columnDefinition = "int default 0")
	@Builder.Default
	private Integer sendOngoing = 0;

	/* 풀필먼트 측에 실제로 보낸 제품 수량 */
	@Column(name = "real_quantity", nullable = false)
	private Integer realQuantity;
	
	/* 출고 시점 총 가격 */
	@Column(name = "total_cost", nullable = false)
	private Integer totalCost;
	
	/* 주문번호(fk), 일대일 매핑 */
	@OneToOne(fetch = FetchType.LAZY) // 주문 entity는 즉시 로딩 x
	@JoinColumn(name = "order_id")
	private Order order;

}
