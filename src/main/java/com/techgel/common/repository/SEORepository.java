package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.SEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SEORepository extends JpaRepository<SEO, Long> {
    @Query("SELECT COUNT(e) > 0 FROM SEO e WHERE e.seo_slug_vi = :slug AND e.id != :id")
    boolean existsBySeoSlugVi(String slug, Long id);

    @Query("SELECT COUNT(e) > 0 FROM SEO e WHERE e.seo_slug_en = :slug AND e.id != :id")
    boolean existsBySeoSlugEn(String slug, Long id);

    @Query("SELECT e FROM SEO e WHERE e.seo_slug_vi = :slug")
    SEO findBySeo_slug_vi(String slug);

    @Query("SELECT e FROM SEO e WHERE e.seo_slug_en = :slug")
    SEO findBySeo_slug_en(String slug);
}
