package com.licoreria.licoreria.brands.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface BrandsRepository extends JpaRepository<Brand, BigDecimal> {
}
