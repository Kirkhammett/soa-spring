package org.estore.finki.order;

import org.estore.finki.product.Product;
import org.estore.finki.product.ProductRepository;
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
        order.addProductToList(productRepository.findOne(p.getProdId()));
        orderRepository.save(order);
    }

    @RequestMapping("/deleteOrders/{id}")
    public @ResponseBody void deleteOrders(@PathVariable(value="id") Long id){
        Orders order = orderRepository.findOne(id);
        orderRepository.delete(order);
    }
}