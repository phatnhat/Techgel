package com.techgel.common.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Getter
public enum NewsType {
    PROJECT("Tin dự án", "News"),
    INTERNAL("Hoạt động nội bộ", "Internal activities"),
    TRAINING("Huấn luyện và đào tạo", "Training activities"),
    CULTURAL("Văn hóa Techgel", "Cultural Techgel");

    private final String vietnameseName;
    private final String englishName;

    public boolean isNews() {
        return this != CULTURAL;
    }

    public static List<NewsType> getAllNewsTypes() {
        return Arrays.stream(values())
                .filter(NewsType::isNews)
                .toList();
    }

    public static NewsType getCultural() {
        return CULTURAL;
    }
}
