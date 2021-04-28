package com.licoreria.licoreria.locationCities.domain;

import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.brands.infrastructure.entities.BrandEntity;
import com.licoreria.licoreria.locationCities.infrastructure.entities.LocationCitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationCitiesRepository
{
    void save(LocationCities LocationCities);

    Optional<LocationCitiesEntity> findLocationCitiesById(Long codigo);

    void delete(LocationCitiesEntity brand);


}
