package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.HomeStatisticItems;
import com.techgel.common.repository.HomeStatisticItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeStatisticItemsService {
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
