package com.example.products.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String p_name;
    private int p_qty;
    private int p_price;

    public Product() {
    }

    public Product(String p_name, int p_qty, int p_price) {
        this.p_name = p_name;
        this.p_qty = p_qty;
        this.p_price = p_price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getP_qty() {
        return p_qty;
    }

    public void setP_qty(int p_qty) {
        this.p_qty = p_qty;
    }

    public int getP_price() {
        return p_price;
    }

    public void setP_price(int p_price) {
        this.p_price = p_price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", p_name='" + p_name + '\'' +
                ", p_qty=" + p_qty +
                ", p_price=" + p_price +
                '}';
    }
}
