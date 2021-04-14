package com.licoreria.licoreria.locationCities.aplication.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
@Builder
public class LocationCitiesRequest
{
    private Long codigo;
    private String nombre;
}
