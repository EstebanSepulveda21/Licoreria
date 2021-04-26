package com.licoreria.licoreria.shippingCountry.aplication;

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
        ShippingCountryRequest shippingCountryRequest = new ShippingCountryRequest( 10L , "shipping_nombre");


        when(shippingCountryMapper.requestToShippingCountry(shippingCountryRequest))
                .thenReturn(new ShippingCountry(
                        new ShippingCountryCodigo(10L), new ShippingCountryNombre("shipping-nombre")));
        creator.create(shippingCountryRequest);
    }

}
