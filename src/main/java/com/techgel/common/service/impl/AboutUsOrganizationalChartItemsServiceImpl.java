package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChartItems;
import com.techgel.common.repository.AboutUsOrganizationalChartItemsRepository;
import com.techgel.common.service.AboutUsOrganizationalChartItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class AboutUsOrganizationalChartItemsServiceImpl implements AboutUsOrganizationalChartItemsService {
    private final AboutUsOrganizationalChartItemsRepository aboutUsOrganizationalChartItemsRepository;

    public List<AboutUsOrganizationalChartItems> getAll(){
        return aboutUsOrganizationalChartItemsRepository.findAll();
    }

    public AboutUsOrganizationalChartItems getById(Long id){
        return aboutUsOrganizationalChartItemsRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        aboutUsOrganizationalChartItemsRepository.deleteById(id);
    }

    public AboutUsOrganizationalChartItems update(AboutUsOrganizationalChartItems aboutUsTestimonialItems){
        return aboutUsOrganizationalChartItemsRepository.save(aboutUsTestimonialItems);
    }
}
