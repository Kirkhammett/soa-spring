package org.estore.finki.controller;

import org.estore.finki.model.Product;
import org.estore.finki.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping()
    @ResponseBody
    public String defaultMethod(){
        return "</br><p>Methods</p><ul>" +
                "<li>/getProducts</li>" +
                "<li>/getProductById/{id}</li>" +
                "<li>/createProduct</li>" +
                "<li>/deleteProduct/{id}</li>" +
                "</ul>";
    }
    @RequestMapping("/getProducts")
    public List<Product> getAllProducts(@RequestParam(value="name", defaultValue="World") String name) {
        List<Product> products = (List<Product>) productRepository.findAll();
        return products;
    }

    @RequestMapping("/getProductById/{id}")
    public @ResponseBody Product getProductById (@PathVariable(value="id") Long id) {
        Product product = productRepository.findOne(id);
        return product;
    }

    @RequestMapping("/createProduct")
    public void createNew(@RequestParam(value = "prodName") String prodName, @RequestParam(value = "prodDescription")
            String prodDescription, @RequestParam(value = "prodPrice") float prodPrice) {
        Product product = new Product(prodName,prodDescription,prodPrice);
        productRepository.save(product);
    }

    @RequestMapping("/deleteProduct/{id}")
    public @ResponseBody void deleteProduct(@PathVariable(value="id") Long id){
        Product product = productRepository.findOne(id);
        productRepository.delete(product);
    }
}
