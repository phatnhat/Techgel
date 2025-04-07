package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.entity.adminSettings.SEO;
import com.techgel.common.repository.SEORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SEOService {
    @Autowired
    SEORepository seoRepository;

    public SEO getById(Long id){
        return seoRepository.findById(id).orElse(null);
    }

    public void update(SEO seo){
        seoRepository.save(seo);
    }

    public SEO getBySeoSlugVi(String slug){
        return seoRepository.findBySeo_slug_vi(slug);
    }

    public SEO getBySeoSlugEn(String slug){
        return seoRepository.findBySeo_slug_en(slug);
    }

    public boolean checkSeoSlugViUnique(String slug, Long id){
        return seoRepository.existsBySeoSlugVi(slug, id);
    }

    public boolean checkSeoSlugEnUnique(String slug, Long id){
        return seoRepository.existsBySeoSlugEn(slug, id);
    }
}
