package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.HomeStatistic;

import java.util.List;

public interface HomeStatisticService {
    List<HomeStatistic> getAll();
    HomeStatistic getById(Long id);
    HomeStatistic update(HomeStatistic homeStatistic);
}
