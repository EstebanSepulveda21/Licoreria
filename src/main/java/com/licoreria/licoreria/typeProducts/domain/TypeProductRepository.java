package com.licoreria.licoreria.typeProducts.domain;


import com.licoreria.licoreria.shippingCountry.domain.ShippingCountry;
import com.licoreria.licoreria.shippingCountry.infrastructure.entities.ShippingCountryEntity;
import com.licoreria.licoreria.typeProducts.infrastructure.entities.TypeProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TypeProductRepository  {

    void save(TypeProduct typeProduct);

    Optional<TypeProductsEntity> findTypeProductsById(Long codigo);

    void delete(TypeProductsEntity typeProducts);

    List<TypeProductsEntity> getAll();
}
