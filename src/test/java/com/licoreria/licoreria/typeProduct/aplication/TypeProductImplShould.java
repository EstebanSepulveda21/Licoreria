package com.licoreria.licoreria.typeProduct.aplication;

import com.licoreria.licoreria.typeProducts.aplication.create.TypeProductCreatorImpl;
import com.licoreria.licoreria.typeProducts.aplication.create.TypeProductRequest;
import com.licoreria.licoreria.typeProducts.domain.TypeProduct;
import com.licoreria.licoreria.typeProducts.domain.TypeProductRepository;
import com.licoreria.licoreria.typeProducts.domain.create.TypeProductCreator;
import com.licoreria.licoreria.typeProducts.domain.valueObject.TypeProductCodigo;
import com.licoreria.licoreria.typeProducts.domain.valueObject.TypeProductNombre;
import com.licoreria.licoreria.typeProducts.infrastructure.mapper.TypeProductsMapper;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TypeProductImplShould {

    @Test
    void created() throws Exception{

        TypeProductRepository typeProductRepository = mock(TypeProductRepository.class);

        TypeProductsMapper typeProductsMapper = mock(TypeProductsMapper.class);

        TypeProductCreator creator = new TypeProductCreatorImpl(typeProductRepository, typeProductsMapper);

        TypeProductRequest typeProductRequest = new TypeProductRequest(10L, "type-nombre");

        when(typeProductsMapper.requestToTypeProduct(typeProductRequest))
                .thenReturn(new TypeProduct( new TypeProductCodigo( 10L),
                        new TypeProductNombre("type_nombre")));
        creator.create(typeProductRequest);
    }


}
