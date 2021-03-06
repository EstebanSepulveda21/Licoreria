package com.licoreria.licoreria.products.domain.create;


import com.licoreria.licoreria.products.aplication.create.ProductRequest;
import com.licoreria.licoreria.products.infrastructure.entities.ProductEntity;


import java.util.List;
import java.util.Optional;

public interface ProductCreator
{
    void create(ProductRequest productRequest);
    Optional<ProductEntity> findProductById(Long productCodigo);
    void update(Long codigo, ProductRequest productRequest) throws Exception;
    void deleteProductById(Long productCodigo) throws Exception;
    List<ProductEntity> getAll();
}
