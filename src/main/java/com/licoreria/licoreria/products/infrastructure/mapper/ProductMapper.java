package com.licoreria.licoreria.products.infrastructure.mapper;

import com.licoreria.licoreria.products.aplication.create.ProductRequest;
import com.licoreria.licoreria.products.domain.Product;
import com.licoreria.licoreria.products.domain.valueObjects.*;
import com.licoreria.licoreria.products.infrastructure.entities.ProductEntity;
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

    public ProductEntity productToProductEntity(Product product){
        return ProductEntity.builder()
                .tiposProductosCodigo(product.getTiposProductosCodigo().value())
                .marcasCodigo(product.getMarcasCodigo().value())
                .paisEnviosCodigo(product.getPaisEnviosCodigo().value())
                .bodegasCodigo(product.getBodegasCodigo().value())
                .codigo(product.getCodigo().value())
                .nombre(product.getNombre().value())
                .build();
    }
}
