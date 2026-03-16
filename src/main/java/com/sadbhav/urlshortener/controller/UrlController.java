package com.sadbhav.urlshortener.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sadbhav.urlshortener.service.UrlService;

import java.io.IOException;

@RestController
public class UrlController {
    @Autowired
    private UrlService urlService; // dependency injection using autowired

    // API endpoint 1
    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody String url){
        return urlService.createShortCode(url);
    }

    // API endpoint 2
    @GetMapping("/{shortCode}")
    public void redirectUrl(@PathVariable String shortCode,
                            HttpServletResponse response) throws IOException {
        String originalUrl = urlService.getOriginalCode(shortCode);

        response.sendRedirect(originalUrl);
    }
}