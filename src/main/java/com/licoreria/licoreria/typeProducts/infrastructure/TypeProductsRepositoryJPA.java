package com.licoreria.licoreria.typeProducts.infrastructure;

import com.licoreria.licoreria.typeProducts.infrastructure.entities.TypeProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeProductsRepositoryJPA extends JpaRepository<TypeProductsEntity, Long> {
}
