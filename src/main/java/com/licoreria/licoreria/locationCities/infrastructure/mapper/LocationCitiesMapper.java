package com.licoreria.licoreria.locationCities.infrastructure.mapper;

import com.licoreria.licoreria.locationCities.aplication.create.LocationCitiesRequest;
import com.licoreria.licoreria.locationCities.domain.LocationCities;
import com.licoreria.licoreria.locationCities.domain.valueObjects.LocationCitiesCodigo;
import com.licoreria.licoreria.locationCities.domain.valueObjects.LocationCitiesNombre;
import com.licoreria.licoreria.locationCities.infrastructure.entities.LocationCitiesEntity;
import org.mapstruct.Mapper;

@Mapper
public abstract class LocationCitiesMapper {

    public LocationCities requestToLocationCities(LocationCitiesRequest request){
        return LocationCities.builder()
                .codigo(new LocationCitiesCodigo(request.getCodigo()))
                .nombre(new LocationCitiesNombre(request.getNombre())).build();
    }

    public LocationCitiesEntity locationCitiesToLocationCities(LocationCities locationCities){
        return LocationCitiesEntity.builder()
                .codigo(locationCities.getCodigo().value())
                .nombre(locationCities.getNombre().value())
                .build();
    }

}
