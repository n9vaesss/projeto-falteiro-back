package com.projectfalteiro.falteiro.services;

import com.projectfalteiro.falteiro.entities.User;
import com.projectfalteiro.falteiro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
