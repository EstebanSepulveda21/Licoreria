package com.licoreria.licoreria.locationCities.domain;


import com.licoreria.licoreria.locationCities.domain.valueObjects.LocationCitiesCodigo;
import com.licoreria.licoreria.locationCities.domain.valueObjects.LocationCitiesNombre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "LocationCities")
@Table(name = "ciudades_ubicacion",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_ciudades_ubicacion_nombre",columnNames = "nombre")
        })
public class LocationCities
{
  /*  @Id
    @Column(name = "codigo")
    private LocationCitiesCodigo codigo;
    @Column(name = "nombre",
            nullable = false,
            columnDefinition = "varchar(85)"
    )
    private LocationCitiesNombre nombre;*/

    private LocationCitiesCodigo codigo;
    private LocationCitiesNombre nombre;
}
