package com.licoreria.licoreria.brands.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Brand")
@Table(name = "marcas",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_marcas_nombre",columnNames = "nombre")
        })
public class Brand {
    @Id
    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "nombre",
            nullable = false,
            columnDefinition = "varchar(80)"
    )
    private String nombre;


}
