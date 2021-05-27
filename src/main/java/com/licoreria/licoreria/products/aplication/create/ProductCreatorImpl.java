package com.licoreria.licoreria.products.aplication.create;


import com.licoreria.licoreria.products.domain.Product;
import com.licoreria.licoreria.products.domain.ProductsRepository;
import com.licoreria.licoreria.products.domain.create.ProductCreator;
import com.licoreria.licoreria.products.infrastructure.entities.ProductEntity;
import com.licoreria.licoreria.products.infrastructure.mapper.ProductMapper;
import com.licoreria.licoreria.shared.domain.Service;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductCreatorImpl implements ProductCreator
{
    private final ProductsRepository productsRepository;
    private final ProductMapper productMapper;

    @Override
    public void create(ProductRequest productRequest)
    {
        Product product = productMapper.requestToProduct(productRequest);
        productsRepository.save(product);
    }

    @Override
    public Optional<ProductEntity> findProductById(Long productCodigo)
    {
        return productsRepository.findProductById(productCodigo);
    }

    @Override
    public void update(Long codigo, ProductRequest productRequest) throws Exception
    {
        Optional<ProductEntity> productUpdate = findProductById(codigo);
        if(productUpdate.isEmpty())
        {
            throw new Exception("No existe el codigo: " + codigo);
        }
        else
        {
            Product product = productMapper.requestToProduct(productRequest);
            productsRepository.save(product);
        }
    }

    @Override
    public void deleteProductById(Long productCodigo) throws Exception
    {
        Optional<ProductEntity> productDelete = findProductById(productCodigo);
        if(productDelete.isEmpty())
        {
            throw new Exception("No existe el codigo: " + productDelete);
        }
        else
        {
            productsRepository.delete(productDelete.get());
        }
    }

    @Override
    public List<ProductEntity> getAll() {
        return productsRepository.getAll();
    }


}
