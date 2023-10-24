package com.example.march2023.dto;

import com.example.march2023.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    @JsonView(value = {View.Level1.class})
    private int id;

    @JsonView(value = {View.Level1.class, View.Level2.class, View.Level3.class})
    @NotBlank(message = "model required")
    @Size(min = 2, max = 20, message = "min: {min} max: {max} characters")
    private String model;

    @JsonView(value = {View.Level1.class, View.Level2.class})
    @Min(value = 56, message = "min power: {value}")
    private int power;

    @JsonView(value = {View.Level1.class, View.Level2.class, View.Level3.class})
    @NotBlank(message = "model required")
    @Size(min = 2, max = 20, message = "min: {min} max: {max} characters")
    private String producer;

    @JsonView(value = {View.Level1.class})
    private String photo;

}