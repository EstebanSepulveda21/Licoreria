package com.licoreria.licoreria.locationCities.infrastructure;

import com.licoreria.licoreria.locationCities.infrastructure.entities.LocationCitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationCitiesRepositoryJPA extends JpaRepository<LocationCitiesEntity, Long> {
}
