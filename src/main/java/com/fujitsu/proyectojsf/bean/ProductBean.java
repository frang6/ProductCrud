package com.fujitsu.proyectojsf.bean;

import com.fujitsu.proyectojsf.client.ProductClient;
import com.fujitsu.proyectojsf.dto.ProductDTO;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Esta clase se encarga de manejar la vista de la aplicación
 */

@Setter
@Getter
@Component("productBean")
@Scope("view")
public class ProductBean implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private long id;
    private String description;
    private String type;
    private double price;
    private transient List<ProductDTO> products;
    private final transient ProductClient productClient;

    @Autowired
    public ProductBean(final ProductClient productClient) {
        this.productClient = productClient;
    }

    @PostConstruct
    public void init() {
        this.products = this.productClient.list();
    }

    public String create() {
        final ProductDTO result = this.productClient.create(new ProductDTO(this.type, this.description, this.price));
        return "index.xhtml?faces.redirect="+((result != null) ? "true" : "false");
    }

    public String update(){
        final ProductDTO result = new ProductDTO(this.id, this.type, this.description, this.price);
        this.productClient.update(result);
        this.products = this.productClient.list();
        return "index.xhtml?faces.redirect=true";
    }


    public void showDialog(final ProductDTO product) {
        this.id = product.getId();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.type = product.getType();
    }

    public void delete(){
        this.productClient.delete(this.id);
        this.products = this.productClient.list();
    }


}
