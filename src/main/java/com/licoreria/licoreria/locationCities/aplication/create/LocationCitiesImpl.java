package com.licoreria.licoreria.locationCities.aplication.create;

import com.licoreria.licoreria.locationCities.domain.LocationCities;
import com.licoreria.licoreria.locationCities.domain.LocationCitiesRepository;
import com.licoreria.licoreria.locationCities.domain.create.LocationCitiesCreator;
import com.licoreria.licoreria.locationCities.infrastructure.entities.LocationCitiesEntity;
import com.licoreria.licoreria.locationCities.infrastructure.mapper.LocationCitiesMapper;
import com.licoreria.licoreria.shared.domain.Service;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationCitiesImpl implements LocationCitiesCreator
{
    private final LocationCitiesRepository locationCitiesRepository;
    private final LocationCitiesMapper locationCitiesMapper;

    @Override
    public void create(LocationCitiesRequest locationCitiesRequest)
    {
        LocationCities locationCities = locationCitiesMapper.requestToLocationCities(locationCitiesRequest);
        locationCitiesRepository.save(locationCities);
    }

    @Override
    public Optional<LocationCitiesEntity> findLocationCitiesById(Long locationCitiesCodigo)
    {
        return locationCitiesRepository.findLocationCitiesById(locationCitiesCodigo);
    }

    @Override
    public void update(Long codigo, LocationCitiesRequest locationCitiesRequest) throws Exception
    {
        Optional<LocationCitiesEntity> locationCitiesUpdate = findLocationCitiesById(codigo);
        if(locationCitiesUpdate.isEmpty())
        {
            throw new Exception("No existe el codigo: " + codigo);
        }
        else
        {
            LocationCities locationCities = locationCitiesMapper.requestToLocationCities(locationCitiesRequest);
            locationCitiesRepository.save(locationCities);
        }
    }

    @Override
    public void deleteLocationCitiesById(Long locationCitiesCodigo) throws Exception
    {
        Optional<LocationCitiesEntity> locationCitiesDeleteById = findLocationCitiesById(locationCitiesCodigo);
        if(locationCitiesDeleteById.isEmpty())
        {

            throw new Exception("No existe el codigo: " + locationCitiesCodigo);
        }
        else
        {
            locationCitiesRepository.delete(locationCitiesDeleteById.get());
        }
    }
}
