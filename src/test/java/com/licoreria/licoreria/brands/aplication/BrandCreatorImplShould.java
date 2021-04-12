package com.licoreria.licoreria.brands.aplication;

import com.licoreria.licoreria.brands.aplication.create.BrandCreatorImpl;
import com.licoreria.licoreria.brands.aplication.create.BrandRequest;
import com.licoreria.licoreria.brands.domain.BrandsRepository;
import com.licoreria.licoreria.brands.domain.create.BrandCreator;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.mockito.Mockito.mock;

public class BrandCreatorImplShould {


    @Test
    void created() throws Exception{
        BrandsRepository brandsRepository = mock(BrandsRepository.class);

        BrandCreator creator = new BrandCreatorImpl(brandsRepository);
        BrandRequest brandRequest = new BrandRequest(10L, "brand-nombre");
        creator.create(brandRequest);
    }


}
