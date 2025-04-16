package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.AboutUsTestimonialItems;
import com.techgel.common.repository.AboutUsTestimonialItemsRepository;
import com.techgel.common.service.AboutUsTestimonialItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class AboutUsTestimonialItemsServiceImpl implements AboutUsTestimonialItemsService {
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
