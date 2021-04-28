package com.licoreria.licoreria.brands.infrastructure;

import com.licoreria.licoreria.brands.infrastructure.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepositoryJPA extends JpaRepository<BrandEntity, Long> {
}
