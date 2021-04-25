package com.licoreria.licoreria.brands.aplication;

import com.licoreria.licoreria.brands.aplication.create.BrandCreatorImpl;
import com.licoreria.licoreria.brands.aplication.create.BrandRequest;
import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.brands.domain.BrandsRepository;
import com.licoreria.licoreria.brands.domain.create.BrandCreator;
import com.licoreria.licoreria.brands.domain.valueObjects.BrandCodigo;
import com.licoreria.licoreria.brands.domain.valueObjects.BrandNombre;
import com.licoreria.licoreria.brands.infrastructure.mapper.BrandMapper;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BrandCreatorImplShould {


    @Test
    void created() throws Exception{
        BrandsRepository brandsRepository = mock(BrandsRepository.class);

        BrandMapper brandMapper = mock(BrandMapper.class);

        BrandCreator creator = new BrandCreatorImpl(brandsRepository, brandMapper);
        BrandRequest brandRequest = new BrandRequest(10L, "brand-nombre");

       when(brandMapper.requestToBrand(brandRequest))
                .thenReturn(new Brand(
                        new BrandCodigo(10l), new BrandNombre("brand-nombre")));
        creator.create(brandRequest);
    }





}
