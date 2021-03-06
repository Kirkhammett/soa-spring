package org.estore.finki.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long orderId;
    private String orderName;

    @ManyToOne(targetEntity = Product.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prodId")
    private Product product;

    public Orders() {
    }

    public Product getProductList() {
        return product;
    }

    public void setProductList(Product product) {
        this.product = product;
    }


    public Orders(String orderName) {
        this.orderName = orderName;
        this.product = new Product();
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

    //public List<Product> getProductList() {
        //return productList;
   // }

    //public void setProductList(List<Product> productList) {
     //   this.productList = productList;
   // }

    //public void addProductToList(Product prod) { this.productList.add(prod); }

    public float getTotalSum(List<Product> productList){
        /*float price = 0;
        for (Product controller : productList) {
            price+=controller.getProdPrice();
        }
        return price;*/
        return productList.stream().map(product -> product.getProdPrice()).reduce((float) 0, (p1, p2) -> p1 + p2);
    }
}
