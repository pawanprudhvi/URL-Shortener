package com.UrlShortener.Service;

import com.UrlShortener.Model.UrlEntity;
import com.UrlShortener.Repo.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {
    @Autowired
    UrlRepo urlrepo;

    @Autowired
    UrlShortenService urlshortenservice;

    public String shortenurl(String longurl)
    {
            UrlEntity saveurl =  urlrepo.save(new UrlEntity(longurl));
            return urlshortenservice.encodeString(saveurl.getUrlId());
    }

    public String getLongUrl(String shortUrl)
    {
        long decodedId = urlshortenservice.decodeString(shortUrl);
        Optional<UrlEntity> urloentity = urlrepo.findById(decodedId);
        System.out.print("1");
        UrlEntity urlentity = urloentity.orElseThrow(() -> new RuntimeException("URL not found"));
        return urlentity.getLongUrl();
    }
}
