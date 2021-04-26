package com.licoreria.licoreria.products.infrastructure.mapper;

import com.licoreria.licoreria.products.aplication.create.ProductRequest;
import com.licoreria.licoreria.products.domain.Product;
import com.licoreria.licoreria.products.domain.valueObjects.*;
import org.mapstruct.Mapper;

@Mapper
public abstract class ProductMapper {
    public Product requestToProduct(ProductRequest productRequest){
        return Product.builder()
                .tiposProductosCodigo(new ProductTiposProductosCodigo(productRequest.getTiposProductosCodigo()))
                .marcasCodigo(new ProductMarcasCodigo(productRequest.getMarcasCodigo()))
                .paisEnviosCodigo(new ProductPaisEnviosCodigo(productRequest.getPaisEnviosCodigo()))
                .bodegasCodigo(new ProductBodegasCodigo(productRequest.getBodegasCodigo()))
                .codigo(new ProductCodigo(productRequest.getCodigo()))
                .nombre(new ProductNombre(productRequest.getNombre()))
                .build();
    }
}
