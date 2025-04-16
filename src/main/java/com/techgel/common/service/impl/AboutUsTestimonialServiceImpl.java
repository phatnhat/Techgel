package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.AboutUsTestimonial;
import com.techgel.common.repository.AboutUsTestimonialRepository;
import com.techgel.common.service.AboutUsTestimonialService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class AboutUsTestimonialServiceImpl implements AboutUsTestimonialService {
    private final AboutUsTestimonialRepository aboutUsTestimonialRepository;

    public List<AboutUsTestimonial> getAll(){
        return aboutUsTestimonialRepository.findAll();
    }

    public AboutUsTestimonial getById(Long id){
        return aboutUsTestimonialRepository.findById(id).orElse(null);
    }

    public AboutUsTestimonial update(AboutUsTestimonial aboutUsTestimonial){
        return aboutUsTestimonialRepository.save(aboutUsTestimonial);
    }
}
