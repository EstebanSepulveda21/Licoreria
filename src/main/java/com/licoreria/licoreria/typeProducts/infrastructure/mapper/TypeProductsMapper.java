package com.licoreria.licoreria.typeProducts.infrastructure.mapper;
import com.licoreria.licoreria.shippingCountry.domain.ShippingCountry;
import com.licoreria.licoreria.shippingCountry.infrastructure.entities.ShippingCountryEntity;
import com.licoreria.licoreria.typeProducts.aplication.create.TypeProductRequest;
import com.licoreria.licoreria.typeProducts.domain.TypeProduct;
import com.licoreria.licoreria.typeProducts.domain.valueObject.TypeProductCodigo;
import com.licoreria.licoreria.typeProducts.domain.valueObject.TypeProductNombre;
import com.licoreria.licoreria.typeProducts.infrastructure.entities.TypeProductsEntity;
import org.mapstruct.Mapper;

@Mapper
public abstract class TypeProductsMapper {

    public TypeProduct requestToTypeProduct(TypeProductRequest request){
        return TypeProduct.builder()
                .codigo(new TypeProductCodigo(request.getCodigo()))
                .nombre(new TypeProductNombre(request.getTipo())).build();
    }

    public TypeProductsEntity typeProudctsToTypeProducts(TypeProduct typeProduct){
        return TypeProductsEntity.builder()
                .codigo(typeProduct.getCodigo().value())
                .tipo(typeProduct.getNombre().value())
                .build();
    }
}
