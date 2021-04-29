package com.licoreria.licoreria.shippingCountry.infrastructure.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "ShippingCountry")
@Table(name = "pais_envios")

public class ShippingCountryEntity {

    @Id
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "nombre",
            nullable = false,
            columnDefinition = "varchar(150)"
    )
    private String nombre;
}
