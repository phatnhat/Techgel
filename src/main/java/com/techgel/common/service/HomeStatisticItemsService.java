package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.HomeStatisticItems;

import java.util.List;

public interface HomeStatisticItemsService {
    List<HomeStatisticItems> getAll();
    HomeStatisticItems getById(Long id);
    HomeStatisticItems update(HomeStatisticItems homeStatisticItems);
    void deleteById(Long id);
}
