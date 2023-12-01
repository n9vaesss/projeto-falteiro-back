package com.projectfalteiro.falteiro.services;

import com.projectfalteiro.falteiro.entities.User;
import com.projectfalteiro.falteiro.repositories.UserRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
    public User findById(String id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(String id){
        try{
            if(repository.existsById(id)){
                repository.deleteById(id);
            }else{
                throw new RuntimeException("ID not found");
            }
        }catch(DataIntegrityViolationException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public User update(String id, User obj){
        try{
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new RuntimeException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
    }
}
