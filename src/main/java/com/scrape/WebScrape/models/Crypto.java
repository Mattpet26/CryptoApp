package com.scrape.WebScrape.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CryptoCurrency")
public class Crypto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;
    private String Price;
    private String HourPrice;
    private String DayPrice;
    private String WeekPrice;
    private List<CryptoBook> CryptoBooks;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getHourPrice() {
        return HourPrice;
    }

    public void setHourPrice(String hourPrice) {
        HourPrice = hourPrice;
    }

    public String getDayPrice() {
        return DayPrice;
    }

    public void setDayPrice(String dayPrice) {
        DayPrice = dayPrice;
    }

    public String getWeekPrice() {
        return WeekPrice;
    }

    public void setWeekPrice(String weekPrice) {
        WeekPrice = weekPrice;
    }

    public List<CryptoBook> getCryptoBooks() {
        return CryptoBooks;
    }

    public void setCryptoBooks(List<CryptoBook> cryptoBooks) {
        CryptoBooks = cryptoBooks;
    }
}
