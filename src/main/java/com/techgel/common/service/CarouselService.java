package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.Carousel;

import java.util.List;

public interface CarouselService {
    List<Carousel> getAll();
    Carousel getById(Long id);
    void update(Carousel carousel);
    void deleteById(Long id);
}
