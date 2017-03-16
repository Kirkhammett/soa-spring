package org.estore.finki.order;
import org.estore.finki.product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long orderId;
    private String orderName;
    @ManyToOne(targetEntity = Product.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> productList;

    public Orders(String orderName) {
        this.orderName = orderName;
        this.productList = new ArrayList<Product>();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProdName() {
        return orderName;
    }

    public void setProdName(String prodName) {
        this.orderName = prodName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProductToList(Product prod) { this.productList.add(prod); }

    public float getTotalSum(List<Product> productList){
        /*float price = 0;
        for (Product product : productList) {
            price+=product.getProdPrice();
        }
        return price;*/
        return productList.stream().map(product -> product.getProdPrice()).reduce((float) 0, (p1, p2) -> p1 + p2);
    }
}
