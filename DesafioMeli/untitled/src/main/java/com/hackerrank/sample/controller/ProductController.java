package com.hackerrank.sample.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.hackerrank.sample.dto.ProductResponse;
import com.hackerrank.sample.model.Product;
import com.hackerrank.sample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/compare")
    public ResponseEntity<MappingJacksonValue> compareProducts(
            @RequestParam List<Long> ids,
            @RequestParam(required = false) List<String> fields) {

        // 1. Busca os produtos convertidos para ProductResponse (Record)
        List<ProductResponse> products = productService.getProductsByIds(ids);

        // 2. Prepara o wrapper para o filtro dinâmico do Jackson
        MappingJacksonValue wrapper = new MappingJacksonValue(products);

        SimpleBeanPropertyFilter filter;
        if (fields == null || fields.isEmpty()) {
            // Se não passar campos, mostra tudo
            filter = SimpleBeanPropertyFilter.serializeAll();
        } else {
            // Filtra apenas os campos solicitados (ex: name, price)
            filter = SimpleBeanPropertyFilter.filterOutAllExcept(new HashSet<>(fields));
        }

        // O nome "ProductFilter" deve ser o mesmo que você colocou no @JsonFilter do
        // Record
        FilterProvider filters = new SimpleFilterProvider().addFilter("ProductFilter", filter);
        wrapper.setFilters(filters);

        return ResponseEntity.ok(wrapper);
    }

    // Endpoint de limpeza exigido pelo http00 e http01
    @DeleteMapping("/erase")
    public ResponseEntity<Void> eraseAll() {
        productService.deleteAll();
        return ResponseEntity.ok().build();
    }

    // Listar todos os modelos
    @GetMapping("/model")
    public ResponseEntity<List<Product>> getAllModels() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    // Criar um novo modelo (com validação de ID existente)
    @PostMapping("/model")
    public ResponseEntity<Void> createModel(@RequestBody Product product) {
        productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // Retorna 201
    }

    // Buscar modelo por ID
    @GetMapping("/model/{id}")
    public ResponseEntity<Product> getModelById(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product == null) {
            return ResponseEntity.notFound().build(); // Força o 404
        }
        return ResponseEntity.ok(product);
    }

    // Deletar modelo por ID
    @DeleteMapping("/model/{id}")
    public ResponseEntity<Void> deleteModelById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}