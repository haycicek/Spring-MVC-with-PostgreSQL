package com.project.web.mapper;

import com.project.web.dto.BrandDto;
import com.project.web.models.Brand;

import java.util.stream.Collectors;

import static com.project.web.mapper.CarMapper.mapToCarDto;

public class BrandMapper {
    public static Brand mapToBrand(BrandDto brand) {
        Brand brandDto = Brand.builder()
                .id(brand.getId())
                .name(brand.getName())
                .build();
        return brandDto;
    }

    public static BrandDto mapToBrandDto(Brand brand){
        BrandDto brandDto = BrandDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .cars(brand.getCars().stream().map((car) -> mapToCarDto(car)).collect(Collectors.toList()))
                .build();
        return brandDto;
    }
}
