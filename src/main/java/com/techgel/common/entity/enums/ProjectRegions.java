package com.techgel.common.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public enum ProjectRegions {
    SOUTHERN("Southern", "Miền Bắc"),
    CENTRAL("Central", "Miền Trung"),
    NORTH("North", "Miền Nam"),
    FOREIGN_COUNTRY("Foreign Country", "Nước ngoài");

    private final String englishName;
    private final String vietnameseName;
}
