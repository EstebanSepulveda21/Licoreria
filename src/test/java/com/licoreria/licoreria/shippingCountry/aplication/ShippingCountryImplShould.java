package com.licoreria.licoreria.shippingCountry.aplication;

import com.licoreria.licoreria.brands.aplication.create.BrandCreatorImpl;
import com.licoreria.licoreria.brands.aplication.create.BrandRequest;
import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.brands.domain.BrandsRepository;
import com.licoreria.licoreria.brands.domain.create.BrandCreator;
import com.licoreria.licoreria.brands.domain.valueObjects.BrandCodigo;
import com.licoreria.licoreria.brands.domain.valueObjects.BrandNombre;
import com.licoreria.licoreria.brands.infrastructure.mapper.BrandMapper;
import com.licoreria.licoreria.shippingCountry.aplication.create.ShippingCountryCreatorImpl;
import com.licoreria.licoreria.shippingCountry.aplication.create.ShippingCountryRequest;
import com.licoreria.licoreria.shippingCountry.domain.ShippingCountry;
import com.licoreria.licoreria.shippingCountry.domain.ShippingCountryRepository;
import com.licoreria.licoreria.shippingCountry.domain.create.ShippingCountryCreator;
import com.licoreria.licoreria.shippingCountry.domain.valueObject.ShippingCountryCodigo;
import com.licoreria.licoreria.shippingCountry.domain.valueObject.ShippingCountryNombre;
import com.licoreria.licoreria.shippingCountry.infrastructure.mapper.ShippingCountryMapper;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShippingCountryImplShould {

    @Test
    void created() throws Exception{

        ShippingCountryRepository shippingCountryRepository = mock(ShippingCountryRepository.class);

        ShippingCountryMapper shippingCountryMapper = mock(ShippingCountryMapper.class);

        ShippingCountryCreator creator = new ShippingCountryCreatorImpl(shippingCountryRepository, shippingCountryMapper);
        ShippingCountryRequest shippingCountryRequest = new ShippingCountryRequest( 10l , "shipping_nombre");


        when(shippingCountryMapper.requestToShippingCountry(shippingCountryRequest))
                .thenReturn(new ShippingCountry(
                        new ShippingCountryCodigo(10l), new ShippingCountryNombre("shipping-nombre")));
        creator.create(shippingCountryRequest);
    }

}
