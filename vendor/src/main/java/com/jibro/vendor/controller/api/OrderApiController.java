package com.jibro.vendor.controller.api;

import com.jibro.vendor.dto.api.OrderApiDto;
import com.jibro.vendor.entity.Order;
import com.jibro.vendor.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderApiController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order-product")
    public ResponseEntity<Order> orderProduct(
            @RequestBody OrderApiDto orderApiDto
            ){
        orderService.insertOrder(orderApiDto);
        return null;
    }
}
