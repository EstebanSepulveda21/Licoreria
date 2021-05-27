package com.licoreria.licoreria.shippingCountry.domain;

import com.licoreria.licoreria.locationCities.domain.LocationCities;
import com.licoreria.licoreria.locationCities.infrastructure.entities.LocationCitiesEntity;
import com.licoreria.licoreria.shippingCountry.infrastructure.entities.ShippingCountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShippingCountryRepository
{
    void save(ShippingCountry shippingCountry);

    Optional<ShippingCountryEntity> findShippingCountryById(Long codigo);

    void delete(ShippingCountryEntity shippingCountry);

    List<ShippingCountryEntity> getAll();

}
