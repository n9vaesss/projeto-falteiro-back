package com.projectfalteiro.falteiro.services;

import com.projectfalteiro.falteiro.entities.User;
import com.projectfalteiro.falteiro.repositories.UserRepository;
import com.projectfalteiro.falteiro.services.exception.EmailAlreadyRegisteredException;
import com.projectfalteiro.falteiro.services.exception.IdNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new IdNotFoundException(id));
    }

    public User insert(User obj) {
        validateEmail(obj.getEmail());
        obj.setPassword(obj.getPassword());
        try {
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new EmailAlreadyRegisteredException(obj.getEmail());
        }
    }

    public void delete(String id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw new IdNotFoundException(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public User update(String id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new IdNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPassword(obj.getPassword());
    }

    private void validateEmail(String email) {
        if (repository.existsByEmail(email)) {
            throw new EmailAlreadyRegisteredException(email);
        }
    }
}
