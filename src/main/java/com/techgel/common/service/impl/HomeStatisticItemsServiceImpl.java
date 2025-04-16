package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.HomeStatisticItems;
import com.techgel.common.repository.HomeStatisticItemsRepository;
import com.techgel.common.service.HomeStatisticItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class HomeStatisticItemsServiceImpl implements HomeStatisticItemsService {
    private final HomeStatisticItemsRepository homeStatisticItemsRepository;

    public List<HomeStatisticItems> getAll(){
        return homeStatisticItemsRepository.findAll();
    }

    public HomeStatisticItems getById(Long id){
        return homeStatisticItemsRepository.findById(id).orElse(null);
    }

    public HomeStatisticItems update(HomeStatisticItems homeStatisticItems){
        return homeStatisticItemsRepository.save(homeStatisticItems);
    }

    public void deleteById(Long id){
        homeStatisticItemsRepository.deleteById(id);
    }
}
