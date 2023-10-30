package com.project.web.mapper;

import com.project.web.dto.CarDto;
import com.project.web.models.Car;

public class CarMapper {
    public static Car mapToCar(CarDto carDto){
        return Car.builder()
                .id(carDto.getId())
                .modelName(carDto.getModelName())
                .type(carDto.getType())
                .modelYear(carDto.getModelYear())
                .brand(carDto.getBrand())
                .build();
    }
    public static CarDto mapToCarDto(Car car){
        return CarDto.builder()
                .id(car.getId())
                .modelName(car.getModelName())
                .type(car.getType())
                .modelYear(car.getModelYear())
                .brand(car.getBrand())
                .build();
    }
}
