package com.project.web.service;

import com.project.web.dto.CarDto;

import java.util.List;

public interface CarService {
    void createCar(Integer brandId, CarDto carDto);
    List<CarDto> findAllCars();
    CarDto findByCarId(Integer carId);
    void updateCar(CarDto carDto);
    void deleteCar(Integer carId);
}
