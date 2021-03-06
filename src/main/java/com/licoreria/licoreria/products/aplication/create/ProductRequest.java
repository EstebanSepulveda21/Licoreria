package com.licoreria.licoreria.products.aplication.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
@Builder
public class ProductRequest
{
    private Long tiposProductosCodigo;
    private Long marcasCodigo;
    private Long paisEnviosCodigo;
    private Long bodegasCodigo;

    private Long codigo;
    private String nombre;

}
