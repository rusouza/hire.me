package com.shorturl.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shorturl.app.model.URLShortener;

public interface URLRepository extends JpaRepository<URLShortener, Long> {

	@Query(value = "from URLShortener u where u.id = :id")
    Optional<URLShortener> findById(@Param(value = "id") Long id);
     
    @Query(value = "from URLShortener u where u.url_original = :urlOriginal")
    Optional<URLShortener> findByOriginalURL(@Param(value = "urlOriginal") String urlOriginal);
     
    @Query(nativeQuery = true, value = "SELECT nextval('seq_unique_id')")
    Long getIdWithNextUniqueId() ;
}