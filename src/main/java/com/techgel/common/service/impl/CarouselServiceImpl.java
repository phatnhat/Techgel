package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.Carousel;
import com.techgel.common.repository.CarouselRepository;
import com.techgel.common.service.CarouselService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class CarouselServiceImpl implements CarouselService {
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
