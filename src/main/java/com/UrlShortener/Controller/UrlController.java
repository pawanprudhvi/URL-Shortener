package com.UrlShortener.Controller;

import com.UrlShortener.Model.UrlEntity;
import com.UrlShortener.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = "${front-end-url}")
public class UrlController {
    @Autowired
    UrlService urlservice;


        @PostMapping("/shorten")
        public ResponseEntity<String> shortenurl(@RequestParam(name ="longurl") String longurl)
        {
            return new ResponseEntity<>(urlservice.shortenurl(longurl), HttpStatus.OK);
        }

    @GetMapping("/{shortUrl}")
    public RedirectView getLongUrl(@PathVariable String shortUrl)
    {
        String longUrl = urlservice.getLongUrl(shortUrl);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(longUrl);
        return redirectView;
    }
}
