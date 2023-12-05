package com.projectfalteiro.falteiro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
    private String name;
    @Getter
    @Setter
    private String barCode;
    @Getter
    @Setter
    private Integer amount;
    @Getter
    @Setter
    private String locality;
    @Getter
    @Setter
    private Date entryDate;

    public Product(){

    }

    public Product(String name, String barCode, Integer amount, String locality) {
        this.name = name;
        this.barCode = barCode;
        this.amount = amount;
        this.locality = locality;
        this.entryDate = new Date();
    }
}
