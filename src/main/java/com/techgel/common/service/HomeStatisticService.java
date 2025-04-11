package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.HomeStatistic;
import com.techgel.common.repository.HomeStatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeStatisticService {
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
