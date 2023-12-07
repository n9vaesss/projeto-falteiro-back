package com.projectfalteiro.falteiro.repositories;

import com.projectfalteiro.falteiro.entities.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, String> {
}
