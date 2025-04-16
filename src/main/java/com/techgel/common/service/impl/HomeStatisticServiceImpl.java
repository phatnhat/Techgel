package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.HomeStatistic;
import com.techgel.common.repository.HomeStatisticRepository;
import com.techgel.common.service.HomeStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class HomeStatisticServiceImpl implements HomeStatisticService {
    private final HomeStatisticRepository homeStatisticRepository;

    public List<HomeStatistic> getAll(){
        return homeStatisticRepository.findAll();
    }

    public HomeStatistic getById(Long id){
        return homeStatisticRepository.findById(id).orElse(null);
    }

    public HomeStatistic update(HomeStatistic homeStatistic){
        return homeStatisticRepository.save(homeStatistic);
    }
}
