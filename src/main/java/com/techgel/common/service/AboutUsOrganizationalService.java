package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChart;
import com.techgel.common.entity.adminSettings.AboutUsTestimonial;
import com.techgel.common.entity.adminSettings.AboutUsTestimonialItems;
import com.techgel.common.repository.AboutUsOrganizationalChartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutUsOrganizationalService {
    private final AboutUsOrganizationalChartRepository aboutUsOrganizationalChartRepository;

    public List<AboutUsOrganizationalChart> getAll(){
        return aboutUsOrganizationalChartRepository.findAll();
    }

    public AboutUsOrganizationalChart getById(Long id){
        return aboutUsOrganizationalChartRepository.findById(id).orElse(null);
    }

    public AboutUsOrganizationalChart update(AboutUsOrganizationalChart aboutUsOrganizationalChart){
        return aboutUsOrganizationalChartRepository.save(aboutUsOrganizationalChart);
    }
}
