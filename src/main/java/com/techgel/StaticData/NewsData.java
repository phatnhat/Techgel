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
                new News(1L, "Đào tạo chuyên đề văn hóa giao tiếp nơi công sở", "Training on cultural communication in the workplace", NewsType.CULTURAL, "", "",
                        "", "", "/imgs/hand-drawn-flat-core-values-background_23-2149065128.jpg")
                {{setUpdatedAt(LocalDateTime.of(2025, Month.APRIL, 5, 0, 0));}},
                new News(2L, "Nhiệm vụ và công việc bộ phận hành chính nhân sự", "Duties and responsibilities of the human resources department", NewsType.CULTURAL, "", "",
                        "", "", "/imgs/hand-drawn-flat-core-values-background_23-2149065128.jpg")
                {{setUpdatedAt(LocalDateTime.of(2025, Month.JANUARY, 21, 0, 0));}}
        );
    }
}
