package com.projectfalteiro.falteiro.services;

import com.projectfalteiro.falteiro.entities.Product;
import com.projectfalteiro.falteiro.repositories.ProductRepository;
import com.projectfalteiro.falteiro.services.exception.BarCodeAlreadyRegisteredException;
import com.projectfalteiro.falteiro.services.exception.IdNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() { return repository.findAll(); }

    public Product findById(String id){
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new IdNotFoundException(id));
    }

    public Product insert(Product obj){
        obj.setEntryDate(new Date());
        return repository.save(obj);
    }

    public void delete(String id){
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw new IdNotFoundException(id);
            }
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Product update(String id, Product obj){
        try{
            Product entity = repository.getReferenceById(id);
            updateDate(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new IdNotFoundException(id);
        }
    }

    private void updateDate(Product entity, Product obj){
        entity.setAmount(obj.getAmount());
        entity.setLocality(obj.getLocality());
    }

}
