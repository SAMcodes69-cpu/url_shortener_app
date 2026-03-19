package com.sadbhav.urlshortener.exception;

public class UrlNotFoundException extends RuntimeException{
    public UrlNotFoundException(String message){
        super(message);
        // super passes message to RuntimeException
    }
    public UrlNotFoundException(String message, Throwable cause){
        super(message,cause);
        // sometimes we throw the cause of error too
    }
}

// if we throw runtime exception for every type of error
// like for url not found and database error then global handler would get confused
// so we write custom names

// we extended RuntimeException because normal exception needed to thrown immediately
// but here we can bubble it up to GlobalHandler
