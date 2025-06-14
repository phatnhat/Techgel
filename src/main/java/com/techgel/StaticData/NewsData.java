package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.enums.NewsType;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.List;

public abstract class NewsData {
    public static List<News> get() {
        return List.of(
                new News(1L, "Tin tức", "News", "/imgs/banners/news-banner.jpg")
        );
    }
}
