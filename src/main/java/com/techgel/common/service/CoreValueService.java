package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.CoreValue;
import com.techgel.common.entity.adminSettings.VisionMission;

import java.util.List;

public interface CoreValueService {
    List<CoreValue> getAll();
    CoreValue getById(Long id);
}
