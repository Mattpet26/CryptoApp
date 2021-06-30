package com.scrape.WebScrape.models;

import javax.persistence.Entity;

@Entity
public class CryptoBook {

    public int CryptoId;
    public int BookId;
    public Crypto CryptoCurrency;
    public Book Book;

    public int getCryptoId() {
        return CryptoId;
    }

    public void setCryptoId(int cryptoId) {
        CryptoId = cryptoId;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public Crypto getCryptoCurrency() {
        return CryptoCurrency;
    }

    public void setCryptoCurrency(Crypto cryptoCurrency) {
        CryptoCurrency = cryptoCurrency;
    }

    public com.scrape.WebScrape.models.Book getBook() {
        return Book;
    }

    public void setBook(com.scrape.WebScrape.models.Book book) {
        Book = book;
    }
}
