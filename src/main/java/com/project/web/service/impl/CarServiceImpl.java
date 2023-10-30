package com.project.web.service.impl;

import com.project.web.dto.CarDto;
import com.project.web.models.Brand;
import com.project.web.models.Car;
import com.project.web.repository.BrandRepository;
import com.project.web.repository.CarRepository;
import com.project.web.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.web.mapper.CarMapper.mapToCar;
import static com.project.web.mapper.CarMapper.mapToCarDto;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private BrandRepository brandRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, BrandRepository brandRepository){
        this.carRepository=carRepository;
        this.brandRepository=brandRepository;
    }
    @Override
    public void createCar(Integer brandId, CarDto carDto) {
        Brand brand = brandRepository.findById(brandId).get();
        Car car = mapToCar(carDto);
        car.setBrand(brand);
        carRepository.save(car);
    }

    @Override
    public List<CarDto> findAllCars() {
        List<Car> cars = carRepository.findAll();
        return  cars.stream().map(car -> mapToCarDto(car)).collect(Collectors.toList());
    }

    @Override
    public CarDto findByCarId(Integer carId) {
        Car car = carRepository.findById(carId).get();
        return mapToCarDto(car);
    }

    @Override
    public void updateCar(CarDto carDto) {
        Car car = mapToCar(carDto);
        carRepository.save(car);
    }

    @Override
    public void deleteCar(Integer carId) {
        carRepository.deleteById(carId);
    }
}
