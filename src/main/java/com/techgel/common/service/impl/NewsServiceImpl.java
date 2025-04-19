package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.entity.enums.NewsType;
import com.techgel.common.repository.NewsRepository;
import com.techgel.common.repository.ProjectRepository;
import com.techgel.common.service.NewsService;
import com.techgel.common.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    public List<News> getAll(){
        return newsRepository.findAll();
    }

    public Page<News> getAllByType(NewsType type, Pageable pageable) {
        return newsRepository.findAllByType(type, pageable);
    }

    @Override
    public List<News> getRecentNews() {
        return null;
    }

    public News getById(Long id){
        return newsRepository.findById(id).orElse(null);
    }


    public News update(News news){
        return newsRepository.save(news);
    }

}
