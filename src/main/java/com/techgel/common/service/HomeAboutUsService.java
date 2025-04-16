package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.HomeAboutUs;

import java.util.List;

public interface HomeAboutUsService {
    List<HomeAboutUs> getAll();
    HomeAboutUs getById(Long id);
    HomeAboutUs update(HomeAboutUs homeAboutUs);
}
