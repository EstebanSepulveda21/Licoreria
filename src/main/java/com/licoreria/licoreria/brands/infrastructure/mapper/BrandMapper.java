package com.licoreria.licoreria.brands.infrastructure.mapper;
import com.licoreria.licoreria.brands.aplication.create.BrandRequest;
import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.brands.domain.valueObjects.BrandCodigo;
import com.licoreria.licoreria.brands.domain.valueObjects.BrandNombre;
import org.mapstruct.Mapper;

@Mapper
public abstract class BrandMapper {
    public Brand requestToBrand(BrandRequest request){
        return Brand.builder()
                .codigo( new BrandCodigo(request.getCodigo()))
                .nombre( new BrandNombre(request.getNombre()))
                .build();
    }
}
