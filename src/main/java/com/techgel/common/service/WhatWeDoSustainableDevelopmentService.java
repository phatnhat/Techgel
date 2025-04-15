package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.WhatWeDoSustainableDevelopment;
import com.techgel.common.repository.WhatWeDoSustainableDevelopmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WhatWeDoSustainableDevelopmentService {
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
