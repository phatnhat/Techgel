package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.HomeAboutUs;
import com.techgel.common.repository.HomeAboutUsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeAboutUsService {
    private final HomeAboutUsRepository homeAboutUsRepository;

    public List<HomeAboutUs> getAll(){
        return homeAboutUsRepository.findAll();
    }

    public HomeAboutUs getById(Long id){
        return homeAboutUsRepository.findById(id).orElse(null);
    }

    public HomeAboutUs update(HomeAboutUs homeAboutUs){
        return homeAboutUsRepository.save(homeAboutUs);
    }
}
