package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.HomeNavigation;

import java.util.List;

public interface HomeNavigationService {
    List<HomeNavigation> getAll();
    List<HomeNavigation> getParents();
    List<HomeNavigation> getAllParents();
    HomeNavigation getById(Long id);
    void update(HomeNavigation homeNavigation);
}
