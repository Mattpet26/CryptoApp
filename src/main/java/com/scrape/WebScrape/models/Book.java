package com.scrape.WebScrape.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    public String UserId;
    public List<CryptoBook> CryptoBooks;
    public List<CryptoBook> WatchList;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public List<CryptoBook> getCryptoBooks() {
        return CryptoBooks;
    }

    public void setCryptoBooks(List<CryptoBook> cryptoBooks) {
        CryptoBooks = cryptoBooks;
    }

    public List<CryptoBook> getWatchList() {
        return WatchList;
    }

    public void setWatchList(List<CryptoBook> watchList) {
        WatchList = watchList;
    }
}
