package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsTestimonial;

import java.util.List;

public interface AboutUsTestimonialService {
    List<AboutUsTestimonial> getAll();
    AboutUsTestimonial getById(Long id);
    AboutUsTestimonial update(AboutUsTestimonial aboutUsTestimonial);
}
