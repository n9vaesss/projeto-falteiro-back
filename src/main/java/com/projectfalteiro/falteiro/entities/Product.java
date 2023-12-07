package com.projectfalteiro.falteiro.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "tb_products")
public class Product {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Getter
    private String id;
    @Getter
    @Setter
    private Integer amount;
    @Getter
    @Setter
    private String locality;
    @Getter
    @Setter
    private Date entryDate;
    @Getter
    @Setter

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Getter
    @OneToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    public Product(){

    }

    public Product(String name, String barCode, Integer amount, String locality, User user, Catalog catalog) {
        this.amount = amount;
        this.locality = locality;
        this.entryDate = new Date();
        this.user = user;
        this.catalog = catalog;
    }
}
