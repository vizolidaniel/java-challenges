package com.hackerrank.sample.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("SMARTPHONE")
public class Smartphone extends Product {
    private String batteryCapacity;
    private String cameraSpecs;
    private String memory;
    private String storageCapacity;
    private String brand;
    private String modelVersion;
    private String os;
}
