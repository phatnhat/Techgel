package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.Carousel;
import com.techgel.common.entity.adminSettings.EProfile;
import com.techgel.common.repository.CarouselRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarouselService {
    private final CarouselRepository carouselRepository;

    public List<Carousel> getAll(){
        return carouselRepository.findAll();
    }

    public Carousel getById(Long id){
        return carouselRepository.findById(id).orElse(null);
    }

    public void update(Carousel carousel){
        carouselRepository.save(carousel);
    }

    public void deleteById(Long id){
        carouselRepository.deleteById(id);
    }
}
