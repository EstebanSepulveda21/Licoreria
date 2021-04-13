package com.licoreria.licoreria.products.aplication.create;


import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.typeProducts.domain.TypeProduct;
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
    private Long codigo;
    private String nombre;

    private TypeProduct tiposProductosCodigo;
    private Brand marcasCodigo;

}
