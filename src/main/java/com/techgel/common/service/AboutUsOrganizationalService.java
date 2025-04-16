package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChart;

import java.util.List;

public interface AboutUsOrganizationalService {
    List<AboutUsOrganizationalChart> getAll();
    AboutUsOrganizationalChart getById(Long id);
    AboutUsOrganizationalChart update(AboutUsOrganizationalChart aboutUsOrganizationalChart);

}
