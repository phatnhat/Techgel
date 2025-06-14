package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChartItems;

import java.util.List;

public interface AboutUsOrganizationalChartItemsService {
    List<AboutUsOrganizationalChartItems> getAll();
    List<AboutUsOrganizationalChartItems> getAllByLang(String lang);
    AboutUsOrganizationalChartItems getById(Long id);
    void deleteById(Long id);
    AboutUsOrganizationalChartItems update(AboutUsOrganizationalChartItems aboutUsTestimonialItems);
}
