package com.shorturl.short_url.controllers;

import com.shorturl.short_url.entities.dtos.ShortenUrlRequest;
import com.shorturl.short_url.entities.dtos.ShortenUrlResponse;
import com.shorturl.short_url.services.URLServices;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/url")
public class URLController {

    private final URLServices urlServices;

    public URLController(URLServices urlServices) {
        this.urlServices = urlServices;
    }

    @PostMapping
    public ResponseEntity<ShortenUrlResponse> createShortenUrl(@RequestBody ShortenUrlRequest shortenUrlRequest) {
        if(shortenUrlRequest.url() == null || shortenUrlRequest.url().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        String shortUrl = urlServices.create_short_url(shortenUrlRequest.url());

        String fullShortUrl = "http://localhost:8080/url/" + shortUrl;

        ShortenUrlResponse response = new ShortenUrlResponse(shortenUrlRequest.url(), fullShortUrl, shortUrl);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<ShortenUrlResponse> getShortenUrl(@PathVariable String shortUrl) {

        String originalUrl = urlServices.get_long_url(shortUrl);

        if(originalUrl == null || originalUrl.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();

        headers.setLocation(URI.create(originalUrl));

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }

}
