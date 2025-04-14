package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChartItems;
import com.techgel.common.repository.AboutUsOrganizationalChartItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutUsOrganizationalChartItemsService {
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
