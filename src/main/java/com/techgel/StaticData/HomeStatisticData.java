package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.HomeStatistic;

import java.util.List;

public abstract class HomeStatisticData {
    public static List<HomeStatistic> get(){
        HomeStatistic homeStatistic = new HomeStatistic(1L, "Doanh nghiệp xuất sắc", "Excellent enterprise", "Top 500 tại Việt Nam", "Top 500 in Vietnam");

        return List.of(homeStatistic);
    }
}
