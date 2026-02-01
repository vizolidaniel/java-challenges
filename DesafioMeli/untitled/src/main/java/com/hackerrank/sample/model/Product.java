package com.hackerrank.sample.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type")
@DiscriminatorValue("GENERIC")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @Id
    private Long id;
    private String name;
    private String imageUrl;
    private String description;
    private Double price;
    private Double rating;
    private String size;
    private String weight;
    private String color;
}
