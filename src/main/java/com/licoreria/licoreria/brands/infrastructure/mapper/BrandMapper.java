package com.licoreria.licoreria.brands.infrastructure.mapper;

import com.licoreria.licoreria.brands.aplication.create.BrandRequest;
import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.brands.domain.valueObjects.BrandCodigo;
import com.licoreria.licoreria.brands.domain.valueObjects.BrandNombre;
import org.mapstruct.Mapper;

@Mapper
public abstract class BrandMapper {
    public Brand requestToBrand(BrandRequest brandRequest){
        return Brand.builder().codigo(brandRequest.getCodigo())
                .nombre(brandRequest.getNombre())
                .build();
    }
}
