package com.UrlShortener.Controller;

import com.UrlShortener.Model.UrlEntity;
import com.UrlShortener.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class UrlController {
    @Autowired
    UrlService urlservice;


        @PostMapping("/shorten")
        public ResponseEntity<String> shortenurl(@RequestParam(name ="longurl") String longurl)
        {
            return new ResponseEntity<>(urlservice.shortenurl(longurl), HttpStatus.OK);
        }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> getLongUrl(@PathVariable String shortUrl)
    {
        return new ResponseEntity<>(urlservice.getLongUrl(shortUrl), HttpStatus.OK);
    }
}
