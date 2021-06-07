package com.scrape.WebScrape;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Crypto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String Name;
    public int Price;

    public Crypto(){}

    public Crypto(String name, int price) {
        Name = name;
        Price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
