package com.projectfalteiro.falteiro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_catalog")
public class Catalog {

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
    @JsonIgnore
    @OneToOne(mappedBy = "catalog")
    private Product product;

    public Catalog() {

    }
    public Catalog(String name, String barCode) {
        this.name = name;
        this.barCode = barCode;
    }

}
