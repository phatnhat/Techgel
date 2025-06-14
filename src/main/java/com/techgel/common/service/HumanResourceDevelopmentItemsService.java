package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.HumanResourceDevelopment;
import com.techgel.common.entity.adminSettings.HumanResourceDevelopmentItems;

import java.util.List;

public interface HumanResourceDevelopmentItemsService {
    HumanResourceDevelopmentItems getById(Long id);
    List<HumanResourceDevelopmentItems> getAll();
    HumanResourceDevelopmentItems update(HumanResourceDevelopmentItems humanResourceDevelopmentItems);
}
