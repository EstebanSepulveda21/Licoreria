package com.licoreria.licoreria.locationCities.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "LocationCities")
@Table(name = "ciudades_ubicacion",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_ciudades_ubicacion_nombre",columnNames = "nombre")
        })
public class LocationCities
{
    @Id
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "nombre",
            nullable = false,
            columnDefinition = "varchar(85)"
    )
    private String nombre;
}
