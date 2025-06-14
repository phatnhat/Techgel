package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.VisionMission;

import java.util.List;

public interface VisionMissionService {
    List<VisionMission> getAll();
    VisionMission getById(Long id);
    VisionMission update(VisionMission VisionMission);
}
