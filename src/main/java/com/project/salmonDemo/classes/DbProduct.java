package com.project.salmonDemo.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class DbProduct {
    @Id
    @GeneratedValue
    Long id;
    String name;
    int price;
    String url;

    public DbProduct() {}

    public DbProduct(String name, int price, String url) {
        this.name = name;
        this.price = price;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DbProduct setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public DbProduct setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public DbProduct setUrl(String url) {
        this.url = url;
        return this;
    }
}
