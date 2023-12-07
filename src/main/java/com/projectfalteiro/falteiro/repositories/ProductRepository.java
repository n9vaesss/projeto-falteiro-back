package com.projectfalteiro.falteiro.repositories;

import com.projectfalteiro.falteiro.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
