package com.project.web.dto;

import com.project.web.models.Brand;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private int id;

    @NotEmpty(message = "Model name should not be empty")
    private String modelName;

    @NotNull(message = "Model year should not be empty")
    private int modelYear;

    @NotEmpty(message = "Type should not be empty")
    private String type;

    private Brand brand;
}
