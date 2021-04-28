package com.licoreria.licoreria.brands.domain;
import com.licoreria.licoreria.brands.infrastructure.entities.BrandEntity;

import java.util.Optional;

public interface BrandsRepository  {

    void save(Brand brand);

    Optional<BrandEntity> findBrandById(Long codigo);

    void delete(BrandEntity brand);


}
