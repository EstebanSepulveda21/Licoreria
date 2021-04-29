package com.licoreria.licoreria.brands.infrastructure;

import com.licoreria.licoreria.brands.infrastructure.entities.BrandEntity;
import com.licoreria.licoreria.shared.domain.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepositoryJPA extends JpaRepository<BrandEntity, Long> {
}
