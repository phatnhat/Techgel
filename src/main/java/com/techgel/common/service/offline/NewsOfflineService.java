package com.techgel.common.service.offline;

import com.techgel.StaticData.EProfileData;
import com.techgel.StaticData.NewsData;
import com.techgel.common.entity.adminSettings.EProfile;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.enums.NewsType;
import com.techgel.common.service.EProfileService;
import com.techgel.common.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class NewsOfflineService implements NewsService {

    public News getById(Long id){
        return this.getAll().stream().filter(news -> news.getId()
                .equals(id)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "News not found"));
    }

    public List<News> getAll(){
        return NewsData.get();
    }

    private <T> Page<T> paginateList(List<T> list, Pageable pageable) {
        if (list == null || pageable == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        int total = list.size();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), total);

        if (start > total) {
            return new PageImpl<>(Collections.emptyList(), pageable, total);
        }

        return new PageImpl<>(list.subList(start, end), pageable, total);
    }

    public Page<News> getAllByType(NewsType type, Pageable pageable){
        List<News> filtered = this.getAll().stream()
                .filter(news -> news.getType().equals(type))
                .sorted(Comparator.comparing(News::getUpdatedAt).reversed())
                .collect(Collectors.toList());

        return paginateList(filtered, pageable);
    }

    @Override
    public List<News> getRecentNews() {
        return this.getAll().stream()
                .sorted(Comparator.comparing(News::getUpdatedAt).reversed())
                .collect(Collectors.toList());
    }

    public News update(News news){
        return null;
    }
}
