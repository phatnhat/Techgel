package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsTestimonialItems;
import com.techgel.common.repository.AboutUsTestimonialItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutUsTestimonialItemsService {
    private final AboutUsTestimonialItemsRepository aboutUsTestimonialItemsRepository;

    public List<AboutUsTestimonialItems> getAll(){
        return aboutUsTestimonialItemsRepository.findAll();
    }

    public AboutUsTestimonialItems getById(Long id){
        return aboutUsTestimonialItemsRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        aboutUsTestimonialItemsRepository.deleteById(id);
    }

    public AboutUsTestimonialItems update(AboutUsTestimonialItems aboutUsTestimonialItems){
        return aboutUsTestimonialItemsRepository.save(aboutUsTestimonialItems);
    }
}
