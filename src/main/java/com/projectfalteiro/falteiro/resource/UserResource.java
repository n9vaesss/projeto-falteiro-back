package com.projectfalteiro.falteiro.resource;

import com.projectfalteiro.falteiro.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User("Caio", "caio@gmail.com", "123456");
        return ResponseEntity.ok().body(u);
    }

}
