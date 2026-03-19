package com.sadbhav.urlshortener.service;

public interface UrlService {
    String createShortCode(String originalUrl);
    String getOriginalCode(String shortCode);

    void delete(String shortCode);
}
