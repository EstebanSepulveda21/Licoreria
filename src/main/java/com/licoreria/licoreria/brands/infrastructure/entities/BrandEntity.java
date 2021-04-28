package com.licoreria.licoreria.brands.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Brand")
@Table(name = "marcas",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_marcas_nombre",columnNames = "nombre")
        })

public class BrandEntity {

    @Id
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "nombre",
            nullable = false,
            columnDefinition = "varchar(80)"
    )
    private String nombre;


}
