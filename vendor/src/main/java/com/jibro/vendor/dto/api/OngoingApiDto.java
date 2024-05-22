package com.jibro.vendor.dto.api;

import lombok.*;

import java.time.LocalDateTime;
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OngoingApiDto {
    /* 제품번호 */
    private String productId;
    /* 요청수량 */
    private int vendorQuantity;
    /* 주문 거래처명 */
    private String companyName;

}
