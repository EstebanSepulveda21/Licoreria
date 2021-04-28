package com.licoreria.licoreria.locationCities.domain;

import com.licoreria.licoreria.locationCities.domain.valueObjects.LocationCitiesCodigo;
import com.licoreria.licoreria.locationCities.domain.valueObjects.LocationCitiesNombre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class LocationCities
{

    private LocationCitiesCodigo codigo;
    private LocationCitiesNombre nombre;
}
