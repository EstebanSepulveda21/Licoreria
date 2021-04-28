package com.licoreria.licoreria.brands.aplication.create;

import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.brands.domain.BrandsRepository;
import com.licoreria.licoreria.brands.domain.create.BrandCreator;
import com.licoreria.licoreria.brands.infrastructure.entities.BrandEntity;
import com.licoreria.licoreria.brands.infrastructure.mapper.BrandMapper;
import com.licoreria.licoreria.shared.domain.Service;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandCreatorImpl implements BrandCreator {

    private final BrandsRepository brandsRepository;
    private final BrandMapper brandMapper;

    @Override
    public void create(BrandRequest brandRequest) {
        Brand brand = brandMapper.requestToBrand(brandRequest);
        brandsRepository.save(brand);
    }

    @Override
    public Optional<BrandEntity> findBrandById(Long brandId) {
        return brandsRepository.findBrandById(brandId);
    }

    @Override
    public void update(Long codigo, BrandRequest brandRequest)throws Exception {
        Optional<BrandEntity> brandUpdate = findBrandById(codigo);
        if(brandUpdate.isEmpty()){
            throw new Exception("No existe el codigo: " + codigo);
        }else{
            Brand brand = brandMapper.requestToBrand(brandRequest);
            brandsRepository.save(brand);
        }
    }

    @Override
    public void deleteBrandById(Long brandCodigo) throws Exception {
        Optional<BrandEntity> brandDeleteById = findBrandById(brandCodigo);
        if(brandDeleteById.isEmpty()){
            throw new Exception("No existe el codigo: " + brandCodigo);
        }else{
            brandsRepository.delete(brandDeleteById.get());
        }
    }
}
