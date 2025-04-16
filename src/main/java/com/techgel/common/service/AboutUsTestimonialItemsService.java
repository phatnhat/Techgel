package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsTestimonialItems;

import java.util.List;

public interface AboutUsTestimonialItemsService {
    List<AboutUsTestimonialItems> getAll();
    AboutUsTestimonialItems getById(Long id);
    void deleteById(Long id);
    AboutUsTestimonialItems update(AboutUsTestimonialItems aboutUsTestimonialItems);
}
