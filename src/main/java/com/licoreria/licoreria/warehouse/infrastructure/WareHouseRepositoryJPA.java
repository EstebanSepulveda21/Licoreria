package com.licoreria.licoreria.warehouse.infrastructure;

import com.licoreria.licoreria.brands.infrastructure.entities.BrandEntity;
import com.licoreria.licoreria.warehouse.infrastructure.entities.WareHouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WareHouseRepositoryJPA extends JpaRepository<WareHouseEntity, Long> {
}
