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
	@Column(name = "send_ongoing", nullable = false)
	@Builder.Default
	private Integer sendOngoing = 0;

	/* 주문번호(fk), 일대일 매핑 */
	@OneToOne(fetch = FetchType.LAZY) // 주문 entity는 즉시 로딩 x
	@JoinColumn(name = "order_id")
	private Order order;

	/*
	 * 주문번호(fk)
	 * 
	 * @Column(name = "order_id") private String orderId;
	 * 
	 * orderId만 넣어도 엔티티 객체 생성 가능하도록 조치 public Ongoing(String orderId) { this.orderId
	 * = orderId; }
	 */

}
