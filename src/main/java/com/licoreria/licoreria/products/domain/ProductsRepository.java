package com.licoreria.licoreria.products.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long>
{

}
