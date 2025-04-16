package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChart;
import com.techgel.common.repository.AboutUsOrganizationalChartRepository;
import com.techgel.common.service.AboutUsOrganizationalService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class AboutUsOrganizationalServiceImpl implements AboutUsOrganizationalService {
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
