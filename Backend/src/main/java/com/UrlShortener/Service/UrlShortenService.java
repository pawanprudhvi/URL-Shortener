package com.UrlShortener.Service;

import org.springframework.stereotype.Service;

@Service
public class UrlShortenService {
    final String Base62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String encodeString(long id)
    {
        String encodedstring = "";
        while(id>0)
        {
            encodedstring += Base62.charAt((int)(id%62));
            id/=62;
        }
        return encodedstring;
    }

    public long decodeString(String shortUrl)
    {

        Long id = 0L;
        for(char ch:shortUrl.toCharArray())
        {
            id=id*62+Base62.indexOf(ch);
        }
        return id;
    }
}
