package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.entity.enums.NewsType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    Page<News> findAllByType(NewsType type, Pageable pageable);
}
