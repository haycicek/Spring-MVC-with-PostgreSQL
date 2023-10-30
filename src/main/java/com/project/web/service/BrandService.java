package com.project.web.service;

import com.project.web.dto.BrandDto;
import com.project.web.models.Brand;

import java.util.List;

public interface BrandService {
    List<BrandDto> findAllBrands();

    Brand saveBrand(BrandDto brandDto);

    BrandDto findBrandById(int brandId);

    void updateBrand(BrandDto brandDto);

    void delete(int brandId);
}
