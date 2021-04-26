package com.licoreria.licoreria.products.aplication;

import com.licoreria.licoreria.products.aplication.create.ProductCreatorImpl;
import com.licoreria.licoreria.products.aplication.create.ProductRequest;
import com.licoreria.licoreria.products.domain.Product;
import com.licoreria.licoreria.products.domain.ProductsRepository;
import com.licoreria.licoreria.products.domain.create.ProductCreator;
import com.licoreria.licoreria.products.domain.valueObjects.*;
import com.licoreria.licoreria.products.infrastructure.mapper.ProductMapper;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ProductsImplShould {

    @Test
    void created() throws Exception{

        ProductsRepository productsRepository = mock(ProductsRepository.class);

        ProductMapper productMapper = mock(ProductMapper.class);

        ProductCreator creator = new ProductCreatorImpl(productsRepository, productMapper);

        ProductRequest productRequest = new ProductRequest(50L,
                40L,
                30L,
                20L,
                10L,
                "product-name");

        when(productMapper.requestToProduct(productRequest))
                .thenReturn(new Product( new ProductTiposProductosCodigo( 50L),
                        new ProductMarcasCodigo(40L),
                        new ProductPaisEnviosCodigo(30L),
                        new ProductBodegasCodigo(20L),
                        new ProductCodigo(10L),
                        new ProductNombre("Product-nombre")));
        creator.create(productRequest);
    }

}
