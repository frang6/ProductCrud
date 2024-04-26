package com.fujitsu.proyectojsf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase es un intermediario entre el cliente y el servidor, sirve para mapeo de datos.
 */

@Setter
@Getter
@AllArgsConstructor
public class ProductDTO {

    private long id;

    private String type;

    private String description;

    private double price;

    public ProductDTO(){

    }

    public ProductDTO(final String type, final String description, final double price) {
        this.description = description;
        this.price = price;
        this.type = type;
    }
}
