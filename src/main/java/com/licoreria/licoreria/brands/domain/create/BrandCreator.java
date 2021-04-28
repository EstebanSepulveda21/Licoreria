package com.licoreria.licoreria.brands.domain.create;

import com.licoreria.licoreria.brands.aplication.create.BrandRequest;
import com.licoreria.licoreria.brands.infrastructure.entities.BrandEntity;

import java.util.Optional;

public interface BrandCreator {
    void create(BrandRequest brandRequest);
    Optional<BrandEntity> findBrandById(Long brandCodigo);
    void update(Long codigo, BrandRequest brandRequest) throws Exception;
    void deleteBrandById(Long brandCodigo) throws Exception;
}
