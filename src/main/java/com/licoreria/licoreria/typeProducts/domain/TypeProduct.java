package com.licoreria.licoreria.typeProducts.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TypeProduct")
@Table(name = "tipos_productos",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_tipos_productos_tipo",columnNames = "tipo")
})
public class TypeProduct {

    @Id
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "tipo",
            nullable = false,
            columnDefinition = "varchar(50)"
    )
    private String tipo;
}
