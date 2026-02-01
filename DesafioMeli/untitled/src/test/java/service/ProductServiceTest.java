package service;

import com.hackerrank.sample.dto.ProductResponse;
import com.hackerrank.sample.exception.ProductNotFoundException;
import com.hackerrank.sample.model.Product;
import com.hackerrank.sample.model.Smartphone;
import com.hackerrank.sample.repository.ProductRepository;
import com.hackerrank.sample.service.ProductService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService productService;

    private AutoCloseable closeable;

    @Before
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        closeable.close();
    }

    // --- TESTES DE COMPARAÇÃO / FILTRAGEM ---

    @Test
    public void shouldReturnProductListWhenIdsExist() {
        // Arrange
        Long id1 = 1L;
        Smartphone phone = new Smartphone();
        phone.setId(id1);
        phone.setName("iPhone");
        phone.setOs("iOS");

        when(repository.findAllById(anyList())).thenReturn(Arrays.asList(phone));

        // Act - Certifique-se que o método no Service se chama getProductsByIds
        List<ProductResponse> responses = productService.getProductsByIds(Arrays.asList(id1));

        // Assert
        assertFalse(responses.isEmpty());
        assertEquals("iPhone", responses.get(0).name());
        assertEquals("iOS", responses.get(0).os());
    }

    @Test(expected = ProductNotFoundException.class)
    public void shouldThrowExceptionWhenProductIsMissing() {
        // Simula que o banco retornou menos itens do que o solicitado
        when(repository.findAllById(anyList())).thenReturn(Arrays.asList());
        productService.getProductsByIds(Arrays.asList(1L));
    }

    @Test
    public void shouldReturnGenericProductResponseWhenNotSmartphone() {
        // Arrange
        Long id = 10L;
        Product genericProduct = new Product();
        genericProduct.setId(id);
        genericProduct.setName("Generic Item");

        when(repository.findAllById(anyList())).thenReturn(Arrays.asList(genericProduct));

        // Act
        List<ProductResponse> responses = productService.getProductsByIds(Arrays.asList(id));

        // Assert
        assertFalse(responses.isEmpty());
        ProductResponse resp = responses.get(0);
        assertEquals("Generic Item", resp.name());
        assertNull(resp.os()); // Garante que não tentou ler OS de um produto comum
    }

    // --- TESTES DE CRUD (Satisfazer http00 e http01) ---

    @Test
    public void shouldSaveProduct() {
        Product p = new Product();
        p.setId(1L);
        productService.save(p);
        verify(repository, times(1)).save(p);
    }

    @Test
    public void shouldFindAllProducts() {
        productService.findAll();
        verify(repository, times(1)).findAll();
    }

    @Test
    public void shouldCheckIfProductExists() {
        when(repository.existsById(1L)).thenReturn(true);
        assertTrue(productService.exists(1L));
    }

    @Test
    public void shouldDeleteAll() {
        productService.deleteAll();
        verify(repository, times(1)).deleteAll();
    }

    @Test
    public void shouldDeleteByIdIfProductExists() {
        when(repository.existsById(1L)).thenReturn(true);
        productService.deleteById(1L);
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    public void shouldFindProductById() {
        Product p = new Product();
        p.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(p));

        Product result = productService.findById(1L);
        assertNotNull(result);
        assertEquals(Long.valueOf(1L), result.getId());
    }
}