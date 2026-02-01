package com.hackerrank.sample.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonFilter("ProductFilter")
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductResponse(
        Long id,
        String name,
        String imageUrl,
        String description,
        Double price,
        Double rating,
        String size,
        String weight,
        String color,

        //Campos específicos de Smartphone (nulo para produtos genéricos)
        String batteryCapacity,
        String cameraSpecs,
        String memory,
        String storageCapacity,
        String brand,
        String modelVersion,
        String os
) {}