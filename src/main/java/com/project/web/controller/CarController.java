package com.project.web.controller;

import com.project.web.dto.CarDto;
import com.project.web.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/api")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    List<CarDto> carList(Model model) {
        List<CarDto> cars = carService.findAllCars();
        model.addAttribute("cars", cars);
        return cars;
    }

    @GetMapping("/cars/{carId}")
    CarDto viewCar(@PathVariable("carId")Integer carId, Model model) {
        CarDto carDto = carService.findByCarId(carId);
        model.addAttribute("brand", carDto.getBrand());
        model.addAttribute("car", carDto);
        return carDto;
    }

    @PostMapping("/cars/{brandId}")
    public String createCar(@PathVariable("brandId") Integer brandId, @ModelAttribute("car") CarDto carDto,
                              BindingResult result,
                              Model model) {
        if(result.hasErrors()) {
            model.addAttribute("car", carDto);
            return "could not created";
        }
        carService.createCar(brandId, carDto);
        return "car created" + brandId;
    }

    @PutMapping("/cars/{carId}/edit")
    public String updateCar(@PathVariable("carId") Integer carId,
                            @Valid @ModelAttribute("car") CarDto car,
                            BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("car", car);
            return "could not updated";
        }
        CarDto carDto = carService.findByCarId(carId);
        car.setId(carId);
        car.setBrand(carDto.getBrand());
        carService.updateCar(car);
        return "succesfully updated";
    }

    @DeleteMapping("/cars/{carId}")
    public String deleteCar(@PathVariable("carId")Integer carId) {
        carService.deleteCar(carId);
        return "ID:"+carId.toString() +"was deleted.";
    }
}
