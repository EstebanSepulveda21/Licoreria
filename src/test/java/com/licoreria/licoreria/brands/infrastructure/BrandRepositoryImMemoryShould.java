package com.licoreria.licoreria.brands.infrastructure;

import com.licoreria.licoreria.brands.domain.Brand;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BrandRepositoryImMemoryShould {

    private BrandsRepositoryInMemory repository;

    @BeforeEach
    void setUp() {
        repository = new BrandsRepositoryInMemory();
    }

    @Test
    void save() throws Exception{
        repository.save(new Brand(new BigDecimal("10"),"brand-nombre"));
    }

    @Test
    void findAnExistingCourse() throws Exception {

    }


}
