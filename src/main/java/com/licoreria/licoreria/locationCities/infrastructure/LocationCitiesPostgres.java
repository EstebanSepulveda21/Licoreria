package com.licoreria.licoreria.locationCities.infrastructure;

import com.licoreria.licoreria.locationCities.domain.LocationCities;
import com.licoreria.licoreria.locationCities.domain.LocationCitiesRepository;
import com.licoreria.licoreria.locationCities.infrastructure.entities.LocationCitiesEntity;
import com.licoreria.licoreria.locationCities.infrastructure.mapper.LocationCitiesMapper;
import com.licoreria.licoreria.shared.domain.Repository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class LocationCitiesPostgres implements LocationCitiesRepository{

    private final LocationCitiesRepositoryJPA locationCitiesRepositoryJPA;
    private final LocationCitiesMapper locationCitiesMapper;

    @Override
    public void save(LocationCities locationCities) {
        locationCitiesRepositoryJPA.save(locationCitiesMapper.locationCitiesToLocationCities(locationCities));
    }

    @Override
    public Optional<LocationCitiesEntity> findLocationCitiesById(Long codigo){return locationCitiesRepositoryJPA.findById(codigo);}

    @Override
    public void delete(LocationCitiesEntity locationCitiesEntity) {
        locationCitiesRepositoryJPA.deleteById(locationCitiesEntity.getCodigo());
    }

}
