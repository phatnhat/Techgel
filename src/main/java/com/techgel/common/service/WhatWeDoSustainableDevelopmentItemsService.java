package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.WhatWeDoSustainableDevelopmentItems;
import com.techgel.common.repository.WhatWeDoSustainableDevelopmentItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WhatWeDoSustainableDevelopmentItemsService {
    private final WhatWeDoSustainableDevelopmentItemsRepository whatWeDoSustainableDevelopmentItemsRepository;

    public List<WhatWeDoSustainableDevelopmentItems> getAll(){
        return whatWeDoSustainableDevelopmentItemsRepository.findAll();
    }

    public WhatWeDoSustainableDevelopmentItems getById(Long id){
        return whatWeDoSustainableDevelopmentItemsRepository.findById(id).orElse(null);
    }

    public WhatWeDoSustainableDevelopmentItems update(WhatWeDoSustainableDevelopmentItems whatWeDoSustainableDevelopmentItems){
        return whatWeDoSustainableDevelopmentItemsRepository.save(whatWeDoSustainableDevelopmentItems);
    }
}
