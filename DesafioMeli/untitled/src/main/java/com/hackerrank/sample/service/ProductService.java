package com.hackerrank.sample.service;

import com.hackerrank.sample.dto.ProductResponse;
import com.hackerrank.sample.exception.ProductNotFoundException;
import com.hackerrank.sample.model.Product;
import com.hackerrank.sample.model.Smartphone;
import com.hackerrank.sample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // --- MÉTODOS DE CRUD (http00 e http01) ---

    public void deleteAll() {
        repository.deleteAll();
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    public void save(Product product) {
        if (product.getId() != null && repository.existsById(product.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID already exists");
        }
        repository.save(product);
    }

    public Product findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    // --- MÉTODOS DE COMPARAÇÃO E FILTRAGEM ---

    public List<ProductResponse> getProductsByIds(List<Long> ids) {
        List<Product> products = repository.findAllById(ids);

        // Se o número de produtos encontrados for diferente do solicitado, lança 404
        if (products.size() < ids.size()) {
            throw new ProductNotFoundException("Product not found");
        }

        return products.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Converte a entidade Product/Smartphone para o Record ProductResponse.
     * Note que usamos os métodos de acesso direto do Record.
     */
    private ProductResponse mapToResponse(Product p) {
        // Se for Smartphone, mapeamos os campos extras
        if (p instanceof Smartphone s) {
            return new ProductResponse(
                    s.getId(),
                    s.getName(),
                    s.getImageUrl(),
                    s.getDescription(),
                    s.getPrice(),
                    s.getRating(),
                    s.getSize(),
                    s.getWeight(),
                    s.getColor(),
                    s.getBatteryCapacity(),
                    s.getCameraSpecs(),
                    s.getMemory(),
                    s.getStorageCapacity(),
                    s.getBrand(),
                    s.getModelVersion(),
                    s.getOs());
        }

        // Se for um Product genérico, os campos de smartphone ficam null
        return new ProductResponse(
                p.getId(),
                p.getName(),
                p.getImageUrl(),
                p.getDescription(),
                p.getPrice(),
                p.getRating(),
                p.getSize(),
                p.getWeight(),
                p.getColor(),
                null, null, null, null, null, null, null);
    }
}