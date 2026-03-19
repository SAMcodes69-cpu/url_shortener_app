package com.sadbhav.urlshortener.dto;

import jakarta.validation.constraints.NotBlank;

public class UrlRequest {
    // what the user sends us

    @NotBlank(message = "URL cannot be blank")
    @org.hibernate.validator.constraints.URL(message = "Invalid URL format")
    private String longUrl;

    public void setLongUrl(String longUrl){this.longUrl = longUrl;}
    public String getLongUrl(){ return longUrl;}
}
