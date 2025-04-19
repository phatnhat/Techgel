package com.techgel.common.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
public enum NewsType {
    PROJECT("Tin dự án", "News"),
    INTERNAL("Hoạt động nội bộ", "Internal activities"),
    TRAINING("Hoạt động đào tạo", "Training activities");

    private final String vietnameseName;
    private final String englishName;
}
