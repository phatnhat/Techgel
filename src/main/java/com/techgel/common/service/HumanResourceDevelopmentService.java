package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.HumanResourceDevelopment;

import java.util.List;

public interface HumanResourceDevelopmentService {
    HumanResourceDevelopment getById(Long id);
    List<HumanResourceDevelopment> getAll();
    HumanResourceDevelopment update(HumanResourceDevelopment humanResourceDevelopment);
}
