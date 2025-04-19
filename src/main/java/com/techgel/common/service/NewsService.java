package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.EProfile;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.enums.NewsType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {
    News getById(Long id);
    List<News> getAll();
    Page<News> getAllByType(NewsType type, Pageable pageable);
    List<News> getRecentNews();
    News update(News news);
}
