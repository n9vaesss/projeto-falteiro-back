package com.projectfalteiro.falteiro.config;

import com.projectfalteiro.falteiro.entities.Product;
import com.projectfalteiro.falteiro.entities.User;
import com.projectfalteiro.falteiro.repositories.ProductRepository;
import com.projectfalteiro.falteiro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
//        User u1 = new User("Caio Novaes", "caio@gmail.com", "12345678910");
//        User u2 = new User("Iago Novaes", "iago@gmail.com", "10987654321");
//
//        userRepository.saveAll(Arrays.asList(u1, u2));
//
//        Product u1 = new Product("Produto", "321654520244" , 2, "Loja 1");
//        productRepository.save(u1);

    }
}
