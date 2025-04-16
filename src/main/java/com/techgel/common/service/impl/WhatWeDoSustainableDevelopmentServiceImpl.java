package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.WhatWeDoSustainableDevelopment;
import com.techgel.common.repository.WhatWeDoSustainableDevelopmentRepository;
import com.techgel.common.service.WhatWeDoSustainableDevelopmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class WhatWeDoSustainableDevelopmentServiceImpl implements WhatWeDoSustainableDevelopmentService {
    private final WhatWeDoSustainableDevelopmentRepository whatWeDoSustainableDevelopmentRepository;

    public List<WhatWeDoSustainableDevelopment> getAll(){
        return whatWeDoSustainableDevelopmentRepository.findAll();
    }

    public WhatWeDoSustainableDevelopment getById(Long id){
        return whatWeDoSustainableDevelopmentRepository.findById(id).orElse(null);
    }

    public WhatWeDoSustainableDevelopment update(WhatWeDoSustainableDevelopment whatWeDoSustainableDevelopment){
        return whatWeDoSustainableDevelopmentRepository.save(whatWeDoSustainableDevelopment);
    }
}
