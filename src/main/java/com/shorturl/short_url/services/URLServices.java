package com.shorturl.short_url.services;

import com.shorturl.short_url.utils.Hash;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class URLServices {

    long counter = 14000000L;

    HashMap<String, String> urls = new HashMap<>();

    Hash hash = new Hash();

    public String create_short_url (String long_url){

        String short_url = Hash.coded(counter);

        urls.put(short_url, long_url);
        counter++;

        return short_url;

    }

    public String get_long_url (String short_url){

        return urls.get(short_url);

    }





}
