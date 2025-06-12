package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.adminSettings.NewsList;
import com.techgel.common.entity.enums.NewsType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsListService {
    NewsList getById(Long id);
    List<NewsList> getAll();
    Page<NewsList> getAllByType(NewsType type, Pageable pageable);
    List<NewsList> getRecentNews();
    NewsList update(NewsList news);
}
