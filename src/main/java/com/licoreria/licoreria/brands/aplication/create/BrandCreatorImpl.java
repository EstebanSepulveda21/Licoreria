package com.licoreria.licoreria.brands.aplication.create;

import com.licoreria.licoreria.brands.domain.Brand;
import com.licoreria.licoreria.brands.domain.BrandsRepository;
import com.licoreria.licoreria.brands.domain.create.BrandsCreator;
import com.licoreria.licoreria.shared.domain.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandCreatorImpl implements BrandsCreator {

    private final BrandsRepository brandsRepository;

    @Override
    public void create(BrandRequest brandRequest){
        Brand brand = new Brand(brandRequest.getCodigo(), brandRequest.getNombre());
        brandsRepository.save(brand);
    }
}
