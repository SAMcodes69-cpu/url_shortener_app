package com.sadbhav.urlshortener.dto;
public class UrlResponse {
    // what the user receives
    private String shortCode;

    public UrlResponse(String code) {
        this.shortCode = code;
    }
    public String getShortCode(){ return shortCode;}
}
