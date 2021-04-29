package com.licoreria.licoreria.products.infrastructure;

import com.licoreria.licoreria.products.domain.Product;
import com.licoreria.licoreria.products.domain.ProductsRepository;
import com.licoreria.licoreria.products.infrastructure.entities.ProductEntity;
import com.licoreria.licoreria.products.infrastructure.mapper.ProductMapper;
import com.licoreria.licoreria.shared.domain.Repository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProductRepositoryPostgres implements ProductsRepository {

    private final ProductRepositoryJPA productRepositoryJPA;
    private final ProductMapper productMapper;

    @Override
    public void save(Product product) {
        productRepositoryJPA.save(productMapper.productToProductEntity(product));
    }

    @Override
    public Optional<ProductEntity> findProductById(Long codigo) {
        return productRepositoryJPA.findById(codigo);
    }

    @Override
    public void delete(ProductEntity productEntity) {
        productRepositoryJPA.deleteById(productEntity.getCodigo());
    }
}
