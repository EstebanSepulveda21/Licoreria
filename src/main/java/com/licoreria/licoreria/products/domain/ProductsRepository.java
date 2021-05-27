package com.licoreria.licoreria.products.domain;

import com.licoreria.licoreria.products.infrastructure.entities.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository {
    void save(Product product);
    Optional<ProductEntity> findProductById(Long codigo);
    void delete(ProductEntity productEntity);
    List<ProductEntity> getAll();
}
