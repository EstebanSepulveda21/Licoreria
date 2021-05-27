package com.licoreria.licoreria.locationCities.domain.create;

import com.licoreria.licoreria.locationCities.aplication.create.LocationCitiesRequest;
import com.licoreria.licoreria.locationCities.domain.LocationCities;
import com.licoreria.licoreria.locationCities.infrastructure.entities.LocationCitiesEntity;

import java.util.List;
import java.util.Optional;

public interface LocationCitiesCreator
{
    void create(LocationCitiesRequest locationCitiesRequest);
    Optional<LocationCitiesEntity> findLocationCitiesById(Long locationCitiesCodigo);
    void update(Long codigo, LocationCitiesRequest locationCitiesRequest) throws Exception;
    void deleteLocationCitiesById(Long locationCitiesCodigo) throws Exception;
    List<LocationCitiesEntity> getAll();
}
