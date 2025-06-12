package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.adminSettings.NewsList;
import com.techgel.common.entity.enums.NewsType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsListRepository extends JpaRepository<NewsList, Long> {
    Page<News> findAllByType(NewsType type, Pageable pageable);
}
