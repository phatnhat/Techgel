package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.adminSettings.NewsList;
import com.techgel.common.entity.enums.NewsType;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public abstract class NewsListData {
    public static List<NewsList> get() {
        return List.of(
                new NewsList(1L, "Triết lý về phương châm quản trị", "Training on cultural communication in the workplace", NewsType.CULTURAL, "", "",
                        "", "", "/imgs/hand-drawn-flat-core-values-background_23-2149065128.jpg")
                {{setUpdatedAt(LocalDateTime.of(2025, Month.APRIL, 5, 0, 0));}},
                new NewsList(2L, "Quy định về Văn hóa giao tiếp nơi làm việc", "Duties and responsibilities of the human resources department", NewsType.CULTURAL, "", "",
                        "", "", "/imgs/hand-drawn-flat-core-values-background_23-2149065128.jpg")
                {{setUpdatedAt(LocalDateTime.of(2025, Month.JANUARY, 21, 0, 0));}}
        );
    }
}
