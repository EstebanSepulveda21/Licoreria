package com.licoreria.licoreria.locationCities.aplication;


import com.licoreria.licoreria.locationCities.aplication.create.LocationCitiesImpl;
import com.licoreria.licoreria.locationCities.aplication.create.LocationCitiesRequest;
import com.licoreria.licoreria.locationCities.domain.LocationCities;
import com.licoreria.licoreria.locationCities.domain.LocationCitiesRepository;
import com.licoreria.licoreria.locationCities.domain.create.LocationCitiesCreator;
import com.licoreria.licoreria.locationCities.domain.valueObjects.LocationCitiesCodigo;
import com.licoreria.licoreria.locationCities.domain.valueObjects.LocationCitiesNombre;
import com.licoreria.licoreria.locationCities.infrastructure.mapper.LocationCitiesMapper;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocationCitiesImplShould {

    @Test
    void created() throws Exception{

        LocationCitiesRepository locationCitiesRepository = mock(LocationCitiesRepository.class);

        LocationCitiesMapper locationCitiesMapper = mock(LocationCitiesMapper.class);

        LocationCitiesCreator creator = new LocationCitiesImpl(locationCitiesRepository, locationCitiesMapper);

        LocationCitiesRequest locationCitiesRequest = new LocationCitiesRequest(10L, "location-nombre");

        when(locationCitiesMapper.requestToLocationCities(locationCitiesRequest))
                .thenReturn(new LocationCities( new LocationCitiesCodigo(10L),
                        new LocationCitiesNombre("location_nombre")));
        creator.create(locationCitiesRequest);
    }


}
