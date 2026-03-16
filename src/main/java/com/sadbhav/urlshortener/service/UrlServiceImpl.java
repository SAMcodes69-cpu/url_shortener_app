package com.sadbhav.urlshortener.service;

import org.springframework.stereotype.Service;
import com.sadbhav.urlshortener.model.Url;
import com.sadbhav.urlshortener.repository.UrlRepository;
import com.sadbhav.urlshortener.util.Base62;

@Service
public class UrlServiceImpl implements UrlService{
    public final UrlRepository urlRepository;
    public UrlServiceImpl(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }
    @Override
    public String createShortCode(String originalUrl) {
        Base62 machine = new Base62();
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        urlRepository.save(url);
        Long id = url.getId();
        String shortCode = machine.encoder(id);
        url.setShortCode(shortCode);
        urlRepository.save(url);
        return shortCode;
    }

    @Override
    public String getOriginalCode(String shortCode) {
        Url url = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));
        return url.getOriginalUrl();
    }
}
