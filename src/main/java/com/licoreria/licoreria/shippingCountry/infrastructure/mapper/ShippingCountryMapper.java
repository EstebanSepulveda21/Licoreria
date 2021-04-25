package com.licoreria.licoreria.shippingCountry.infrastructure.mapper;

import com.licoreria.licoreria.shippingCountry.aplication.create.ShippingCountryRequest;
import com.licoreria.licoreria.shippingCountry.domain.ShippingCountry;
import com.licoreria.licoreria.shippingCountry.domain.valueObject.ShippingCountryCodigo;
import com.licoreria.licoreria.shippingCountry.domain.valueObject.ShippingCountryNombre;
import org.mapstruct.Mapper;

@Mapper
public abstract class ShippingCountryMapper {

    public ShippingCountry requestToShippingCountry(ShippingCountryRequest request){

        return ShippingCountry.builder()
                .codigo(new ShippingCountryCodigo(request.getCodigo()))
                .nombre(new ShippingCountryNombre(request.getNombre())).build();

    }
}
