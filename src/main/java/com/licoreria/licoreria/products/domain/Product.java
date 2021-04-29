package com.licoreria.licoreria.products.domain;

import com.licoreria.licoreria.products.domain.valueObjects.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Product
{
    private ProductTiposProductosCodigo tiposProductosCodigo;
    private ProductMarcasCodigo marcasCodigo;
    private ProductPaisEnviosCodigo paisEnviosCodigo;
    private ProductBodegasCodigo bodegasCodigo;
    private ProductCodigo codigo;
    private ProductNombre nombre;
}
