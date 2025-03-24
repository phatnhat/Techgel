package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.SEO;
import com.techgel.common.repository.SEORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SEOService {
    @Autowired
    SEORepository seoRepository;

    public SEO getSEOByEntityType(String entity_type){
        return seoRepository.findByEntity_type(entity_type);
    }
}
