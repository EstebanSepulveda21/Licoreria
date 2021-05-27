package com.licoreria.licoreria.typeProducts.aplication.create;
import com.licoreria.licoreria.shared.domain.Service;

import com.licoreria.licoreria.typeProducts.domain.TypeProduct;
import com.licoreria.licoreria.typeProducts.domain.TypeProductRepository;
import com.licoreria.licoreria.typeProducts.domain.create.TypeProductCreator;

import com.licoreria.licoreria.typeProducts.infrastructure.entities.TypeProductsEntity;
import com.licoreria.licoreria.typeProducts.infrastructure.mapper.TypeProductsMapper;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class TypeProductCreatorImpl implements TypeProductCreator {
    private final TypeProductRepository typeProductRepository;
    private final TypeProductsMapper typeProductsMapper;
    @Override
    public void create(TypeProductRequest typeProductRequest) {

        TypeProduct typeProduct = typeProductsMapper.requestToTypeProduct(typeProductRequest);
        typeProductRepository.save(typeProduct);
    }
    @Override
    public Optional<TypeProductsEntity> findTypeProductById(Long TypeProductID) {
        return typeProductRepository.findTypeProductsById(TypeProductID);
    }
    @Override
    public void update(Long codigo, TypeProductRequest typeProductRequest)throws Exception {
        Optional<TypeProductsEntity> TypeProductUpdate = findTypeProductById(codigo);
        if(TypeProductUpdate.isEmpty()){
            throw new Exception("No existe el codigo: " + codigo);
        }else{
            TypeProduct typeProduct = typeProductsMapper.requestToTypeProduct(typeProductRequest);
            typeProductRepository.save(typeProduct);
        }
    }
    @Override
    public void deleteTypeProductById(Long TypeProductCodigo) throws Exception {
        Optional<TypeProductsEntity> typeProductDeleteById = findTypeProductById(TypeProductCodigo);
        if(typeProductDeleteById.isEmpty()){
            throw new Exception("No existe el codigo: " + TypeProductCodigo);
        }else{
            typeProductRepository.delete(typeProductDeleteById.get());
        }
    }

    @Override
    public List<TypeProductsEntity> getAll() {
        return typeProductRepository.getAll();
    }
}
