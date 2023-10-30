package com.project.web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BrandDto {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    private String name;
    private List<CarDto> cars;
}
