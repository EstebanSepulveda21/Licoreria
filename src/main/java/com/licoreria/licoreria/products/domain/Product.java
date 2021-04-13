package com.licoreria.licoreria.products.domain;

import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.typeProducts.domain.TypeProduct;
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
    @ManyToOne
    @JoinColumn
            (
                    foreignKey = @ForeignKey(name = "fk_productos_tipos_productos"),
                    nullable = false
            )
    private TypeProduct tiposProductosCodigo;
    //private Long tiposProductosCodigo;
    //------------------
    @ManyToOne
    @JoinColumn
            (
                    foreignKey = @ForeignKey(name = "fk_productos_marcas"),
                    nullable = false
            )
    private Brand marcasCodigo;
    //private Long marcasCodigo;
}
