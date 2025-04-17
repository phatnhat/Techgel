package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.HomeOurBusinessLine;
import com.techgel.common.entity.adminSettings.WhatWeDoOurBusinessLine;
import com.techgel.common.repository.HomeOurBusinessLineRepository;
import com.techgel.common.repository.WhatWeDoOurBusinessLineRepository;
import com.techgel.common.service.HomeOurBusinessLineService;
import com.techgel.common.service.WhatWeDoOurBusinessLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class HomeOurBusinessLineServiceImpl implements HomeOurBusinessLineService {
    private final HomeOurBusinessLineRepository homeOurBusinessLineRepository;

    public List<HomeOurBusinessLine> getAll(){
        return homeOurBusinessLineRepository.findAll();
    }

    public HomeOurBusinessLine getById(Long id){
        return homeOurBusinessLineRepository.findById(id).orElse(null);
    }

    public HomeOurBusinessLine update(HomeOurBusinessLine homeOurBusinessLine){
        return homeOurBusinessLineRepository.save(homeOurBusinessLine);
    }
}
