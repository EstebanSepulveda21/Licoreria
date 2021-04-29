package com.licoreria.licoreria.shippingCountry.aplication.create;


import com.licoreria.licoreria.shared.domain.Service;
import com.licoreria.licoreria.shippingCountry.domain.ShippingCountry;
import com.licoreria.licoreria.shippingCountry.domain.ShippingCountryRepository;
import com.licoreria.licoreria.shippingCountry.domain.create.ShippingCountryCreator;
import com.licoreria.licoreria.shippingCountry.infrastructure.entities.ShippingCountryEntity;
import com.licoreria.licoreria.shippingCountry.infrastructure.mapper.ShippingCountryMapper;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ShippingCountryCreatorImpl implements ShippingCountryCreator
{
    private final ShippingCountryRepository shippingCountryRepository;
    private final ShippingCountryMapper shippingCountryMapper;

    @Override
    public void create(ShippingCountryRequest shippingCountryRequest)
    {
        ShippingCountry shippingCountry = shippingCountryMapper.requestToShippingCountry(shippingCountryRequest);
        shippingCountryRepository.save(shippingCountry);
    }

    @Override
    public Optional<ShippingCountryEntity> findShippingCountryById(Long shippingCountryCodigo)
    {
        return shippingCountryRepository.findShippingCountryById(shippingCountryCodigo);
    }

    @Override
    public void update(Long codigo, ShippingCountryRequest shippingCountryRequest) throws Exception
    {
        Optional<ShippingCountryEntity> shippingCountryUpdate = findShippingCountryById(codigo);
        if(shippingCountryUpdate.isEmpty())
        {
            throw new Exception("No existe el codigo: " + codigo);
        }
        else
            {
                ShippingCountry shippingCountry = shippingCountryMapper.requestToShippingCountry(shippingCountryRequest);
                shippingCountryRepository.save(shippingCountry);
            }
    }

    @Override
    public void deleteShippingCountryById(Long shippingCountryCodigo) throws Exception
    {
        Optional<ShippingCountryEntity> shippingCountryById = findShippingCountryById(shippingCountryCodigo);
        if(shippingCountryById.isEmpty())
        {
            throw new Exception("No existe el codigo: " + shippingCountryCodigo);
        }
        else
            {
                shippingCountryRepository.delete(shippingCountryById.get());
            }
    }
}
