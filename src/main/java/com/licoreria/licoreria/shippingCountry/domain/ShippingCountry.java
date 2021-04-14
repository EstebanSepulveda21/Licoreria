package com.licoreria.licoreria.shippingCountry.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ShippingCountry")
@Table(name = "pais_envios")
public class ShippingCountry
{
    @Id
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "nombre",
            nullable = false,
            columnDefinition = "varchar(150)"
    )
    private String nombre;
}
