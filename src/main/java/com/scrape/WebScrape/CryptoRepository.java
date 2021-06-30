package com.scrape.WebScrape;

import com.scrape.WebScrape.models.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CryptoRepository extends JpaRepository<Crypto, Long> {
    Crypto findbyName(String name);
}
