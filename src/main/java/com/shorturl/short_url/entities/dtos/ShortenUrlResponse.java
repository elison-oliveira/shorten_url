package com.shorturl.short_url.entities.dtos;

public record ShortenUrlResponse(String longUrl, String fullShortUrl, String shortUrl) {
}
