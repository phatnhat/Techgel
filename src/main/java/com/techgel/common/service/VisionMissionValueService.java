package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.VisionMission;
import com.techgel.common.entity.adminSettings.VisionMissionValue;

import java.util.List;

public interface VisionMissionValueService {
    List<VisionMissionValue> getAll();
    VisionMissionValue getById(Long id);
}
