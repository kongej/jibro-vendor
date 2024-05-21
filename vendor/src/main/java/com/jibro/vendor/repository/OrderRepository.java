package com.jibro.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jibro.vendor.entity.Order;

public interface OrderRepository  extends JpaRepository<Order, String>{

}
