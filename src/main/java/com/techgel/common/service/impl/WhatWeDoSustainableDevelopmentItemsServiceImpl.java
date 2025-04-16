package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.WhatWeDoSustainableDevelopmentItems;
import com.techgel.common.repository.WhatWeDoSustainableDevelopmentItemsRepository;
import com.techgel.common.service.WhatWeDoSustainableDevelopmentItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class WhatWeDoSustainableDevelopmentItemsServiceImpl implements WhatWeDoSustainableDevelopmentItemsService {
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
