package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.HomeAboutUs;
import com.techgel.common.repository.HomeAboutUsRepository;
import com.techgel.common.service.HomeAboutUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class HomeAboutUsServiceImpl implements HomeAboutUsService {
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
