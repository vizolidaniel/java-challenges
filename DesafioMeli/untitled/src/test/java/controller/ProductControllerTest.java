package com.hackerrank.sample.controller;

import com.hackerrank.sample.dto.ProductResponse;
import com.hackerrank.sample.exception.ProductNotFoundException;
import com.hackerrank.sample.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class) // Testa apenas a camada web
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void shouldReturnComparedProducts() throws Exception {
        ProductResponse p1 = new ProductResponse(1L, "iPhone", null, null, 999.0, null, null, null, null, null, null, null, null, "Apple", null, "iOS");

        when(productService.getProductsByIds(anyList())).thenReturn(Arrays.asList(p1));

        mockMvc.perform(get("/products/compare")
                        .param("ids", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("iPhone"))
                .andExpect(jsonPath("$[0].os").value("iOS"));
    }

    @Test
    public void shouldHandleProductNotFoundException() throws Exception {
        // Este teste cobre o GlobalExceptionHandler
        when(productService.getProductsByIds(anyList()))
                .thenThrow(new ProductNotFoundException("Product not found"));

        mockMvc.perform(get("/products/compare")
                        .param("ids", "99")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()); // Verifica se o Handler retornou 404
    }

    @Test
    public void shouldFilterFieldsCorrectly() throws Exception {
        ProductResponse p1 = new ProductResponse(1L, "iPhone", "url", "desc", 999.0, 5.0, "M", "100g", "Black", "5000", "12MP", "8GB", "128GB", "Apple", "13", "iOS");

        when(productService.getProductsByIds(anyList())).thenReturn(Arrays.asList(p1));

        mockMvc.perform(get("/products/compare")
                        .param("ids", "1")
                        .param("fields", "name,price") // Pedindo apenas 2 campos
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("iPhone"))
                .andExpect(jsonPath("$[0].price").value(999.0))
                .andExpect(jsonPath("$[0].os").doesNotExist()) // O 'os' deve ser filtrado
                .andExpect(jsonPath("$[0].id").doesNotExist()); // O 'id' deve ser filtrado
    }
}