package com.springtechie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product_Details")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "productName")
    private String pName;
    private double pRating;
    private int noOfOrders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getpRating() {
        return pRating;
    }

    public void setpRating(double pRating) {
        this.pRating = pRating;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }

    public void setNoOfOrders(int noOfOrders) {
        this.noOfOrders = noOfOrders;
    }

    public Product(int id, String pName, double pRating, int noOfOrders) {
        this.id = id;
        this.pName = pName;
        this.pRating = pRating;
        this.noOfOrders = noOfOrders;
    }

    public Product() {
    }
}
