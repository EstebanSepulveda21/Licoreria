package com.licoreria.licoreria.typeProducts.infrastructure.mapper;
import com.licoreria.licoreria.typeProducts.aplication.create.TypeProductRequest;
import com.licoreria.licoreria.typeProducts.domain.TypeProduct;
import com.licoreria.licoreria.typeProducts.domain.valueObject.TypeProductCodigo;
import com.licoreria.licoreria.typeProducts.domain.valueObject.TypeProductNombre;
import org.mapstruct.Mapper;

@Mapper
public abstract class TypeProductsMapper {

    public TypeProduct requestToTypeProduct(TypeProductRequest request){
        return TypeProduct.builder()
                .codigo(new TypeProductCodigo(request.getCodigo()))
                .nombre(new TypeProductNombre(request.getTipo())).build();
    }
}
