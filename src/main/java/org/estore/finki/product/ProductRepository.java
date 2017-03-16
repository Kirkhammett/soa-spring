package org.estore.finki.product;

import org.estore.finki.product.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {
    //List<Product> getAllProducts();
}

