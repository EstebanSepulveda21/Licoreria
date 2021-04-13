package com.licoreria.licoreria.products.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Product")
@Table(name = "productos")
public class Product
{
    //@ManyToOne
    @Column(name = "tipos_productos_codigo")
    private Long tiposProductosCodigo;
    //------------------
    //@ManyToOne
    @Column(name = "marcas_codigo")
    private Long marcasCodigo;
    //------------------
    @Id
    @Column(name = "codigo")
    private Long codigo;
    //------------------
    @Column(name = "nombre",
            nullable = false,
            columnDefinition = "varchar(150)"
    )
    private String nombre;
    //------------------

}
