package com.licoreria.licoreria.products.aplication.create;


import com.licoreria.licoreria.products.domain.Product;
import com.licoreria.licoreria.products.domain.ProductsRepository;
import com.licoreria.licoreria.products.domain.create.ProductCreator;
import com.licoreria.licoreria.shared.domain.Service;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductCreatorImpl implements ProductCreator
{
    private final ProductsRepository productsRepository;

    @Override
    public void create(ProductRequest productRequest)
    {
        Product product = new Product(productRequest.getCodigo(), productRequest.getNombre(),
                productRequest.getTiposProductosCodigo(), productRequest.getMarcasCodigo());

        productsRepository.save(product);
    }

    @Override
    public Optional<Product> findProductById(Long productCodigo)
    {
        return productsRepository.findById(productCodigo);
    }

    @Override
    public void update(Long codigo, ProductRequest productRequest) throws Exception
    {
        Optional<Product> productUpdate = findProductById(codigo);
        if(productUpdate.isEmpty())
        {
            throw new Exception("No existe el codigo: " + codigo);
        }
        else
        {
            Product brand = new Product(productRequest.getCodigo(), productRequest.getNombre(),
                    productRequest.getTiposProductosCodigo(), productRequest.getMarcasCodigo());

            productsRepository.save(brand);
        }
    }

    @Override
    public void deleteProductById(Long productCodigo) throws Exception
    {
        Optional<Product> productDelete = findProductById(productCodigo);
        if(productDelete.isEmpty())
        {
            throw new Exception("No existe el codigo: " + productDelete);
        }
        else
        {
            productsRepository.delete(productDelete.get());
        }
    }


}
