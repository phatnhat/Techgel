package com.techgel.common.service.offline;

import com.techgel.StaticData.VisionMissionData;
import com.techgel.StaticData.VisionMissionValueData;
import com.techgel.common.entity.adminSettings.VisionMission;
import com.techgel.common.entity.adminSettings.VisionMissionValue;
import com.techgel.common.service.VisionMissionService;
import com.techgel.common.service.VisionMissionValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class VisionMissionValueOfflineService implements VisionMissionValueService {
    public List<VisionMissionValue> getAll(){
        return VisionMissionValueData.get();
    }

    public VisionMissionValue getById(Long id){
        return this.getAll().stream().filter(visionMissionValue -> visionMissionValue.getId().equals(id)).findFirst().orElse(null);
    }

    public VisionMissionValue update(VisionMissionValue visionMissionValue){
        return null;
    }

    public void deleteById(Long id){}
}
