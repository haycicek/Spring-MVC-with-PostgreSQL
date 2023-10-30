package com.project.web.service.impl;

import com.project.web.models.Brand;
import com.project.web.repository.BrandRepository;
import com.project.web.dto.BrandDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.web.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.web.mapper.BrandMapper.mapToBrand;
import static com.project.web.mapper.BrandMapper.mapToBrandDto;

@Service
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandDto> findAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream().map((brand) -> mapToBrandDto(brand)).collect(Collectors.toList());
    }

    @Override
    public Brand saveBrand(BrandDto brandDto) {
        Brand brand = mapToBrand(brandDto);
        return brandRepository.save(brand);
    }

    @Override
    public BrandDto findBrandById(int brandId) {
        Brand brand = brandRepository.findById(brandId).get();
        return mapToBrandDto(brand);
    }

    @Override
    public void updateBrand(BrandDto brandDto) {
        Brand brand = mapToBrand(brandDto);
        brandRepository.save(brand);
    }

    @Override
    public void delete(int brandId) {
        brandRepository.deleteById(brandId);
    }
}
