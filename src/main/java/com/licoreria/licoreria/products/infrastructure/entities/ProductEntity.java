package com.licoreria.licoreria.products.infrastructure.entities;

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
@Entity(name = "Product")
@Table(name = "productos")
public class ProductEntity {
        //@ManyToOne
    @Column(name = "tipos_productos_codigo")
    private Long tiposProductosCodigo;
    //@ManyToOne
    @Column(name = "marcas_codigo")
    private Long marcasCodigo;
    //@ManyToOne
    @Column(name = "pais_envios_codigo")
    private Long paisEnviosCodigo;
    //@ManyToOne
    @Column(name = "bodegas_codigo")
    private Long bodegasCodigo;
    @Id
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "nombre",
            nullable = false,
            columnDefinition = "varchar(150)"
    )
    private String nombre;
}