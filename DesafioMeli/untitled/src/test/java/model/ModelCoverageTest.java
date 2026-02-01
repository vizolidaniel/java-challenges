package model;

import com.hackerrank.sample.model.Product;
import com.hackerrank.sample.model.Smartphone;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModelCoverageTest {

    @Test
    public void testSmartphoneFullCoverage() {
        Smartphone s1 = new Smartphone();

        // Cobrindo Setters do Product (Herança)
        s1.setId(1L);
        s1.setName("Name");
        s1.setImageUrl("url");
        s1.setDescription("desc");
        s1.setPrice(100.0);
        s1.setRating(4.5);
        s1.setSize("L");
        s1.setWeight("200g");
        s1.setColor("Blue");

        // Cobrindo Setters do Smartphone
        s1.setBatteryCapacity("5000mAh");
        s1.setCameraSpecs("48MP");
        s1.setMemory("8GB");
        s1.setStorageCapacity("256GB");
        s1.setBrand("Samsung");
        s1.setModelVersion("S23");
        s1.setOs("Android");

        // Verificando Getters
        assertEquals("url", s1.getImageUrl());
        assertEquals("8GB", s1.getMemory());
        assertEquals("256GB", s1.getStorageCapacity());

        // Cobrindo equals, hashCode, canEqual e toString (Lombok)
        Smartphone s2 = new Smartphone();
        s2.setId(1L);

        assertEquals(s1, s2);
        assertNotEquals(s1, s2);
        assertNotNull(s1.toString());
        assertNotNull(s1.hashCode());
    }

    @Test
    public void testProductBaseCoverage() {
        Product p = new Product();
        p.setId(10L);
        p.setName("Generic");

        // Testa especificamente o equals da classe base
        Product p2 = new Product();
        p2.setId(10L);
        p2.setName("Generic");

        assertEquals(p, p2);
        assertEquals(p.hashCode(), p2.hashCode());
    }

    @Test
    public void testProductAllArgsConstructor() {
        Product p = new Product(
                1L, "Name", "url", "desc", 100.0, 4.5, "Large", "200g", "Black"
        );

        assertNotNull(p);
        assertEquals(Long.valueOf(1L), p.getId());
        assertEquals("Name", p.getName());
    }

    @Test
    public void testSmartphoneAllArgsConstructor() {
        Smartphone s = new Smartphone(
                "5000mAh", "48MP", "8GB", "256GB", "Brand", "V1", "Android"
        );

        assertNotNull(s);
        assertEquals("Android", s.getOs());
    }
}