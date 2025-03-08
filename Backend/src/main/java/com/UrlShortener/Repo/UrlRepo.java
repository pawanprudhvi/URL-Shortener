package com.UrlShortener.Repo;

import com.UrlShortener.Model.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepo extends JpaRepository<UrlEntity,Long> {


}
