package com.licoreria.licoreria.brands.domain;
import com.licoreria.licoreria.brands.domain.valueObjects.BrandCodigo;
import com.licoreria.licoreria.brands.domain.valueObjects.BrandNombre;
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
public class Brand {
   /* @Id
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "nombre",
            nullable = false,
            columnDefinition = "varchar(80)"
    )
    private String nombre;*/

    private BrandCodigo codigo;
    private BrandNombre nombre;


}
