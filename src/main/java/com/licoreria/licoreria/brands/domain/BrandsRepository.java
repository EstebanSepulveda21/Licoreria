package com.licoreria.licoreria.brands.domain;
import com.licoreria.licoreria.brands.infrastructure.entities.BrandEntity;
import com.licoreria.licoreria.shared.domain.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandsRepository  {
    void save(Brand brand);
    Optional<BrandEntity> findBrandById(Long codigo);
    void delete(BrandEntity brand);
    List<BrandEntity> getAll();

}