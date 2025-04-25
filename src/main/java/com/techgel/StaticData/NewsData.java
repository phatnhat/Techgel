package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.enums.NewsType;

import java.time.LocalDateTime;
import java.util.List;

public abstract class NewsData {
    public static List<News> get() {
        return List.of();
    }
}
