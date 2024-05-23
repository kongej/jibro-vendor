package com.jibro.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jibro.vendor.entity.Ongoing;

import java.util.Optional;

/**
 * @author ljy
 * @since 2024.05.21
 * 출고 관련 repository 코드
 * **/
public interface OngoingRepository extends JpaRepository<Ongoing, Long> {

}
