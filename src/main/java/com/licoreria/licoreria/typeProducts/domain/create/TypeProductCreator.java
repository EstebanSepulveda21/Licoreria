package com.licoreria.licoreria.typeProducts.domain.create;



import com.licoreria.licoreria.typeProducts.aplication.create.TypeProductRequest;
import com.licoreria.licoreria.typeProducts.domain.TypeProduct;
import com.licoreria.licoreria.typeProducts.infrastructure.entities.TypeProductsEntity;

import java.util.List;
import java.util.Optional;

public interface TypeProductCreator {
    void create(TypeProductRequest typeProductRequest);
    Optional<TypeProductsEntity> findTypeProductById(Long typeProductCodigo);
    void update(Long codigo, TypeProductRequest typeProductRequest) throws Exception;
    void deleteTypeProductById(Long typeProductCodigo) throws Exception;
    List<TypeProductsEntity> getAll();
}
