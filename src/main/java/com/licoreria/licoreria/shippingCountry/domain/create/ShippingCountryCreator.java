package com.licoreria.licoreria.shippingCountry.domain.create;

import com.licoreria.licoreria.shippingCountry.aplication.create.ShippingCountryRequest;
import com.licoreria.licoreria.shippingCountry.domain.ShippingCountry;
import com.licoreria.licoreria.shippingCountry.infrastructure.entities.ShippingCountryEntity;

import java.util.Optional;

public interface ShippingCountryCreator
{
    void create(ShippingCountryRequest shippingCountryRequest);
    Optional<ShippingCountryEntity> findShippingCountryById(Long shippingCountryCodigo);
    void update(Long codigo, ShippingCountryRequest shippingCountryRequest) throws Exception;
    void deleteShippingCountryById(Long shippingCountryCodigo) throws Exception;
}
