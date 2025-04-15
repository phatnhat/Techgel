package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.WhatWeDoService;
import com.techgel.common.repository.WhatWeDoServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WhatWeDoServiceService {
    private final WhatWeDoServiceRepository whatWeDoServiceRepository;

    public List<WhatWeDoService> getAll(){
        return whatWeDoServiceRepository.findAll();
    }

    public WhatWeDoService getById(Long id){
        return whatWeDoServiceRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        whatWeDoServiceRepository.deleteById(id);
    }

    public WhatWeDoService update(WhatWeDoService whatWeDoService){
        return whatWeDoServiceRepository.save(whatWeDoService);
    }
}
