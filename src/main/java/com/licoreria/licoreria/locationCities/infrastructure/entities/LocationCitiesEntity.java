package com.licoreria.licoreria.locationCities.infrastructure.entities;

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
public class LocationCitiesEntity {

    @Id
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "nombre",
            nullable = false,
            columnDefinition = "varchar(85)"
    )
    private String nombre;

}
