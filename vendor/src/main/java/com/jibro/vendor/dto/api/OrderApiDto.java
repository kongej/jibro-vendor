package com.jibro.vendor.dto.api;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author kej
 * @since 2024.05.22
 * Order data Api 받는 용도
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderApiDto {

    /* 거래처명(풀필먼트) */
    private String companyName;

    /* 요청수량 */
    private Integer vendorQuantity;

    /* 제품번호(fk) */
    private String productId;

    /* 주문 날짜 */
    private LocalDateTime createdAt;

}
