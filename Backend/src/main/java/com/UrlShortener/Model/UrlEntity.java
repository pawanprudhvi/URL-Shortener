package com.UrlShortener.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Entity
@Data
@AllArgsConstructor
public class UrlEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long urlId;


    private String shortUrl;


    private String longUrl;

    public String getLongUrl() {
        return longUrl;
    }

    public UrlEntity(long urlId) {
        this.urlId = urlId;
    }
    public UrlEntity()
    {

    }

    @Override
    public String toString() {
        return "UrlEntity{" +
                "urlId=" + urlId +
                ", longUrl='" + longUrl + '\'' +
                '}';
    }

    public void setUrlId(long urlId) {
        this.urlId = urlId;
    }

    public long getUrlId() {
        return urlId;
    }
    public UrlEntity(String longUrl){
        LocalDateTime cur = LocalDateTime.now();
        this.longUrl = longUrl;
    }





}
