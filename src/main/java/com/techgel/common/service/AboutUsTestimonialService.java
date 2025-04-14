package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsTestimonial;
import com.techgel.common.repository.AboutUsTestimonialItemsRepository;
import com.techgel.common.repository.AboutUsTestimonialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutUsTestimonialService {
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
