package com.licoreria.licoreria.typeProducts.infrastructure;
import com.licoreria.licoreria.shared.domain.Repository;
import com.licoreria.licoreria.shippingCountry.domain.ShippingCountry;
import com.licoreria.licoreria.shippingCountry.infrastructure.entities.ShippingCountryEntity;
import com.licoreria.licoreria.typeProducts.domain.TypeProduct;
import com.licoreria.licoreria.typeProducts.domain.TypeProductRepository;
import com.licoreria.licoreria.typeProducts.infrastructure.entities.TypeProductsEntity;
import com.licoreria.licoreria.typeProducts.infrastructure.mapper.TypeProductsMapper;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class TypeProductsPostgres implements TypeProductRepository {

    private final TypeProductsRepositoryJPA typeProductsRepositoryJPA;
    private final TypeProductsMapper typeProductsMapper;

    @Override
    public void save(TypeProduct typeProduct) {
        typeProductsRepositoryJPA.save(typeProductsMapper.typeProudctsToTypeProducts(typeProduct));
    }

    @Override
    public Optional<TypeProductsEntity> findTypeProductsById (Long codigo){return typeProductsRepositoryJPA.findById(codigo);}

    @Override
    public void delete(TypeProductsEntity typeProductsEntity) {
        typeProductsRepositoryJPA.deleteById(typeProductsEntity.getCodigo());
    }

    @Override
    public List<TypeProductsEntity> getAll() {
        return typeProductsRepositoryJPA.findAll();
    }
}
