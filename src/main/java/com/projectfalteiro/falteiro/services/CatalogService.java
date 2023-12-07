package com.projectfalteiro.falteiro.services;

import com.projectfalteiro.falteiro.entities.Catalog;
import com.projectfalteiro.falteiro.entities.Product;
import com.projectfalteiro.falteiro.repositories.CatalogRepository;
import com.projectfalteiro.falteiro.services.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository repository;

    public List<Catalog> findAll() { return repository.findAll(); }

    public Catalog findById(String id){
        Optional<Catalog> obj = repository.findById(id);
        return obj.orElseThrow(() -> new IdNotFoundException(id));
    }

    public Catalog insert(Catalog obj){
        return repository.save(obj);
    }
}
