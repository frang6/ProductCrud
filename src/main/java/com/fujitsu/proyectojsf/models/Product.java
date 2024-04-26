package com.fujitsu.proyectojsf.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * Esta clase está relacionada de manera directa con la tabla de la base de datos.
 * Concretamente se encarga del mapeo ORM de la tabla Product
 */

@Entity(name = "Product")
@Table
@Setter
@Getter
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String type;
    @Column
    private String description;
    @Column
    private double price;

    public Product() {
    }

    public Product(final String type, final String description, final double price) {
        this.type = type;
        this.description = description;
        this.price = price;
    }

}
