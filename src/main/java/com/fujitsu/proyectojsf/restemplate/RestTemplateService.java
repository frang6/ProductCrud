package com.fujitsu.proyectojsf.restemplate;

import com.fujitsu.proyectojsf.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Esta clase se encarga de manejar las peticiones a modo de cliente al servidor rest configurado por la URL
 */

@Service
@Slf4j
public class RestTemplateService {

    private final RestTemplate restTemplate;

    public RestTemplateService(){
        this.restTemplate = new RestTemplate();
    }

    public List<ProductDTO> executeGET(final String url, final Class<ProductDTO[]> clazz) {
        try {
            final ProductDTO[] response = this.restTemplate.getForEntity(url, clazz).getBody();
            return response != null ? Arrays.asList(response) : Collections.emptyList();
        } catch (final Exception e) {
            log.error(e.getMessage());
        }
        return Collections.emptyList();
    }

    public ProductDTO executePOST(final String url, final ProductDTO dto, final Class<ProductDTO> clazz) {
        try {
            return this.restTemplate.postForEntity(url, dto, clazz).getBody();
        } catch (final Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public void executePUT(final String url, final ProductDTO dto) {
        try {
            this.restTemplate.put(url, dto);
        } catch (final Exception e) {
            log.error(e.getMessage());
        }
    }

    public void executeDelete(final String url) {
        try {
            this.restTemplate.delete(url);
        } catch (final Exception e) {
            log.error(e.getMessage());
        }
    }

}
