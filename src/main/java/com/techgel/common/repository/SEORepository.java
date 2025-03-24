package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.SEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SEORepository extends JpaRepository<SEO, Long> {
    @Query("SELECT s FROM SEO s WHERE s.entity_type = ?1")
    SEO findByEntity_type(String entity_type);
}
