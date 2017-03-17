package org.estore.finki.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long prodId;
    private String prodName;
    private String prodDescription;
    private float prodPrice;

    public Product() {}

    public Product(String prodName, String prodDescription, float prodPrice) {
        this.prodName = prodName;
        this.prodDescription = prodDescription;
        this.prodPrice = prodPrice;
    }

    public Long getProdId() {
        return prodId;
    }

    public String getProdName() {
        return prodName;
    }
    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", prodDescription='" + prodDescription + '\'' +
                ", prodPrice=" + prodPrice +
                '}';
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public void setProdPrice(float prodPrice) {
        this.prodPrice = prodPrice;
    }

    public float getProdPrice() {

        return prodPrice;
    }
}
