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
    @SequenceGenerator(
            name = "brand_seq",
            sequenceName ="brand_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "brand_seq"
    )
    @Column(name = "codigo")
    private BigDecimal codigo;

    @Column(name = "nombre",
            nullable = false,
            columnDefinition = "varchar(80)"
    )
    private String nombre;


}
