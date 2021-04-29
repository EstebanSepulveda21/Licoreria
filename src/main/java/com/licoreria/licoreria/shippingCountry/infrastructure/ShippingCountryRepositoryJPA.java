package com.licoreria.licoreria.shippingCountry.infrastructure;

import com.licoreria.licoreria.shippingCountry.infrastructure.entities.ShippingCountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingCountryRepositoryJPA extends JpaRepository<ShippingCountryEntity, Long> {
}
