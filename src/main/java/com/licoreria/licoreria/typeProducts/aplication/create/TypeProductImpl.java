package com.licoreria.licoreria.typeProducts.aplication.create;


import com.licoreria.licoreria.shared.domain.Service;

import com.licoreria.licoreria.typeProducts.domain.TypeProduct;
import com.licoreria.licoreria.typeProducts.domain.TypeProductRepository;
import com.licoreria.licoreria.typeProducts.domain.create.TypeProductCreator;

import lombok.AllArgsConstructor;
import java.util.Optional;

@Service
@AllArgsConstructor

public class TypeProductImpl implements TypeProductCreator {

    private final TypeProductRepository typeProductRepository;

    @Override
    public void create(TypeProductRequest typeProductRequest) {
        TypeProduct typeProduct = new TypeProduct(typeProductRequest.getCodigo(), typeProductRequest.getTipo());
        typeProductRepository.save(typeProduct);
    }

    @Override
    public Optional<TypeProduct> findTypeProductById(Long TypeProductID) {
        return typeProductRepository.findById(TypeProductID);
    }

    @Override
    public void update(Long codigo, TypeProductRequest typeProductRequest)throws Exception {
        Optional<TypeProduct> TypeProductUpdate = findTypeProductById(codigo);
        if(TypeProductUpdate.isEmpty()){
            throw new Exception("No existe el codigo: " + codigo);
        }else{
            TypeProduct typeProduct = new TypeProduct(typeProductRequest.getCodigo(), typeProductRequest.getTipo());
            typeProductRepository.save(typeProduct);
        }
    }

    @Override
    public void deleteTypeProductById(Long TypeProductCodigo) throws Exception {
        Optional<TypeProduct> typeProductDeleteById = findTypeProductById(TypeProductCodigo);
        if(typeProductDeleteById.isEmpty()){
            throw new Exception("No existe el codigo: " + TypeProductCodigo);
        }else{
            typeProductRepository.delete(typeProductDeleteById.get());
        }
    }
}
