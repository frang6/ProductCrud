package com.fujitsu.proyectojsf.client;

import com.fujitsu.proyectojsf.dto.ProductDTO;
import com.fujitsu.proyectojsf.restemplate.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Esta clase se encarga de manejar las peticiones a modo de cliente al servidor rest configurado por la URL
 */

@Service
public class ProductClient {

    private final RestTemplateService service;
    private static final String URL = "http://localhost:8080/products";

    @Autowired
    public ProductClient(final RestTemplateService restTemplateService) {
        this.service = restTemplateService;
    }

    public List<ProductDTO> list() {
        return this.service.executeGET(URL, ProductDTO[].class);
    }

    public ProductDTO create(final ProductDTO productDTO) {
        return this.service.executePOST(URL, productDTO, ProductDTO.class);
    }

    public void update(final ProductDTO productDTO) {
        this.service.executePUT(URL, productDTO);
    }

    public void delete(final Long id) {
        this.service.executeDelete(URL + "/" + id);
    }
}
