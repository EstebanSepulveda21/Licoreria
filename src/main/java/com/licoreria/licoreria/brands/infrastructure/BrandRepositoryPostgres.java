package com.licoreria.licoreria.brands.infrastructure;

import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.brands.domain.BrandsRepository;
import com.licoreria.licoreria.brands.infrastructure.entities.BrandEntity;
import com.licoreria.licoreria.brands.infrastructure.mapper.BrandMapper;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class BrandRepositoryPostgres implements BrandsRepository {
    private final BrandRepositoryJPA brandRepositoryJPA;
    private final BrandMapper brandMapper;

    @Override
    public void save(Brand brand) {
        brandRepositoryJPA.save(brandMapper.brandToBrandEntity(brand));
    }

    @Override
    public Optional<BrandEntity> findBrandById(Long codigo){return brandRepositoryJPA.findById(codigo);}

    @Override
    public void delete(BrandEntity brand) {
        brandRepositoryJPA.deleteById(brand.getCodigo());
    }
}
