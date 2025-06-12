package com.techgel.common.service.offline;

import com.techgel.StaticData.NewsData;
import com.techgel.StaticData.NewsListData;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.adminSettings.NewsList;
import com.techgel.common.entity.enums.NewsType;
import com.techgel.common.service.NewsListService;
import com.techgel.common.service.NewsService;
import com.techgel.common.utils.PaginateList;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class NewsListOfflineService implements NewsListService {

    public NewsList getById(Long id){
        return this.getAll().stream().filter(news -> news.getId()
                .equals(id)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "News not found"));
    }

    public List<NewsList> getAll(){
        return NewsListData.get();
    }

    public Page<NewsList> getAllByType(NewsType type, Pageable pageable){
        List<NewsList> filtered = this.getAll().stream()
                .filter(news -> news.getType().equals(type))
                .sorted(Comparator.comparing(NewsList::getUpdatedAt).reversed())
                .collect(Collectors.toList());

        return PaginateList.page(filtered, pageable);
    }

    @Override
    public List<NewsList> getRecentNews() {
        return this.getAll().stream()
                .sorted(Comparator.comparing(NewsList::getUpdatedAt).reversed())
                .collect(Collectors.toList());
    }

    public NewsList update(NewsList news){
        return null;
    }
}
