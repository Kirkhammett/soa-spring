package org.estore.finki.repository;

import org.estore.finki.model.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {
    //List<Product> getAllProducts();
}

