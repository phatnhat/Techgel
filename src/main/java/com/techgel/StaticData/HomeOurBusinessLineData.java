package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.HomeOurBusinessLine;

import java.util.List;

public abstract class HomeOurBusinessLineData {
    public static List<HomeOurBusinessLine> get(){
        HomeOurBusinessLine homeOurBusinessLine = new HomeOurBusinessLine(1L, "Lĩnh vực hoạt động", "Field of activity", "Lĩnh vực chuyên ngành", "Field of specialization");

        return List.of(homeOurBusinessLine);
    }
}
