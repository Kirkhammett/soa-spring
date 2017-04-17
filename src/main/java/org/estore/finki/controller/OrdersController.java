package org.estore.finki.controller;

import org.estore.finki.model.Product;
import org.estore.finki.model.Orders;
import org.estore.finki.repository.OrdersRepository;
import org.estore.finki.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by filip on 16.3.17.
 */
@RestController
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    OrdersRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    @RequestMapping()
    @ResponseBody
    public String defaultMethod(){
        return "</br><p>Methods</p><ul>" +
                "<li>/getOrders</li>" +
                "<li>/getOrdersById/{id}</li>" +
                "<li>/createOrders</li>" +
                "<li>/deleteOrders/{id}</li>" +
                "</ul>";
    }

    @RequestMapping("/getOrders")
    public List<Orders> getAllOrderss() {
        List<Orders> orders = (List<Orders>) orderRepository.findAll();
        return orders;
    }

    @RequestMapping("/getOrdersById/{id}")
    public @ResponseBody
    Orders getOrdersById (@PathVariable(value="id") Long id) {
        Orders order = orderRepository.findOne(id);
        return order;
    }

    @RequestMapping("/createOrders")
    public void createNew(@RequestParam(value = "orderName") String orderName) {
        Orders order = new Orders(orderName);
        Product p = new Product("gitara","gibson les paul", 30000);
        productRepository.save(p);
        order.setProductList(productRepository.findOne(p.getProdId()));
        orderRepository.save(order);
    }

    @RequestMapping("/deleteOrders/{id}")
    public @ResponseBody void deleteOrders(@PathVariable(value="id") Long id){
        Orders order = orderRepository.findOne(id);
        orderRepository.delete(order);
    }
}
