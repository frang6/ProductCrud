package com.fujitsu.proyectojsf.repository;

import com.fujitsu.proyectojsf.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta clase se encarga de manejar las peticiones a la base de datos
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
