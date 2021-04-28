package com.licoreria.licoreria.brands.domain;

import com.licoreria.licoreria.brands.domain.valueObjects.BrandCodigo;
import com.licoreria.licoreria.brands.domain.valueObjects.BrandNombre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Brand {

    public BrandCodigo codigo;
    public BrandNombre nombre;

}
