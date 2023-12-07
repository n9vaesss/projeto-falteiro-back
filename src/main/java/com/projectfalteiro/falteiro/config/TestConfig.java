package com.projectfalteiro.falteiro.config;

import com.projectfalteiro.falteiro.entities.Catalog;
import com.projectfalteiro.falteiro.entities.Product;
import com.projectfalteiro.falteiro.entities.User;
import com.projectfalteiro.falteiro.repositories.CatalogRepository;
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
    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("Caio Novaes", "caio@gmail.com", "12345678910");
        User u2 = new User("Iago Novaes", "iago@gmail.com", "10987654321");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Catalog c1 = new Catalog("PRODUTO 1", "12345678910");
        Catalog c2 = new Catalog("PRODUTO 2", "10987654321");

        catalogRepository.saveAll(Arrays.asList(c1, c2));

        Product p1 = new Product("Produto", "32165231554" , 3, "Loja 1", u1, c1);
        Product p2 = new Product("Produto2", "3216523120244" , 3, "Loja 2", u1, c2);
        productRepository.saveAll(Arrays.asList(p1, p2));

    }
}
