package com.licoreria.licoreria.shippingCountry.infrastructure;
import com.licoreria.licoreria.locationCities.domain.LocationCities;
import com.licoreria.licoreria.locationCities.infrastructure.entities.LocationCitiesEntity;
import com.licoreria.licoreria.shippingCountry.domain.ShippingCountry;
import com.licoreria.licoreria.shippingCountry.domain.ShippingCountryRepository;
import com.licoreria.licoreria.shippingCountry.infrastructure.entities.ShippingCountryEntity;
import com.licoreria.licoreria.shippingCountry.infrastructure.mapper.ShippingCountryMapper;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class ShippingCountryPostgres implements ShippingCountryRepository {

    private final ShippingCountryRepositoryJPA shippingCountryRepositoryJPA;
    private final ShippingCountryMapper shippingCountryMapper;


    @Override
    public void save(ShippingCountry shippingCountry) {
        shippingCountryRepositoryJPA.save(shippingCountryMapper.shippingCountryToShippingCountry(shippingCountry));
    }

    @Override
    public Optional<ShippingCountryEntity> findShippingCountryById(Long codigo){return shippingCountryRepositoryJPA.findById(codigo);}

    @Override
    public void delete(ShippingCountryEntity shippingCountryEntity) {
        shippingCountryRepositoryJPA.deleteById(shippingCountryEntity.getCodigo());
    }


}
