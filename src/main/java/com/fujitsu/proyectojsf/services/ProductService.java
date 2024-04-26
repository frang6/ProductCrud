package com.fujitsu.proyectojsf.services;

import com.fujitsu.proyectojsf.dto.ProductDTO;
import com.fujitsu.proyectojsf.models.Product;
import com.fujitsu.proyectojsf.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Esta clase es el servicio que se encarga de manejar las peticiones al repositorio de productos
 */

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ProductDTO> list(){
        final List<ProductDTO> result = new CopyOnWriteArrayList<>();
        final List<Product> ddbb = this.productRepository.findAll();
        for(final Product p : ddbb){
            final ModelMapper m = new ModelMapper();
            result.add(m.map(p, ProductDTO.class));
        }
        return result;
    }

    public ProductDTO create(final ProductDTO productDTO){
        final ModelMapper m = new ModelMapper();
        final Product productSaved = this.productRepository.save(m.map(productDTO, Product.class));
        return m.map(productSaved, ProductDTO.class);
    }

    public void update(final ProductDTO productDTO){
        final ModelMapper m = new ModelMapper();
        final Product product = m.map(productDTO, Product.class);
        final Optional<Product> found = this.productRepository.findById(product.getId());
        if(found.isPresent()){
            this.productRepository.save(product);
        }else{
            final String msg = "No se ha encontrado el producto con id: " + product.getId();
            log.warn(msg);
        }
    }

    public void delete(final long id){
        this.productRepository.deleteById(id);
    }

}
