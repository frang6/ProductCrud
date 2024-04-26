package com.fujitsu.proyectojsf.controllers;

import com.fujitsu.proyectojsf.dto.ProductDTO;
import com.fujitsu.proyectojsf.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Esta clase se encarga de manejar las peticiones REST enviadas por el cliente.
 * Aqui se puede llegar desde POSTMAN también por ejemplo
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(final ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> list(){
        return this.productService.list();
    }

    @PostMapping
    public ProductDTO create(@RequestBody final ProductDTO productDTO){
        return this.productService.create(productDTO);
    }

    @PutMapping
    public void update(@RequestBody final ProductDTO productDTO){
        this.productService.update(productDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final long id){
        this.productService.delete(id);
    }

}
