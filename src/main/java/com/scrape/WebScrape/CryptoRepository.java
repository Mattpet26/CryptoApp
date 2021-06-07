package com.scrape.WebScrape;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CryptoRepository extends JpaRepository<Crypto, Long> {
}
