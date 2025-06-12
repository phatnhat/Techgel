package com.techgel.common.service.offline;

import com.techgel.StaticData.CeoMessageData;
import com.techgel.StaticData.EProfileData;
import com.techgel.StaticData.VisionMissionData;
import com.techgel.common.entity.adminSettings.CeoMessage;
import com.techgel.common.entity.adminSettings.EProfile;
import com.techgel.common.entity.adminSettings.VisionMission;
import com.techgel.common.service.VisionMissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class VisionMissionOfflineService implements VisionMissionService {
    public List<VisionMission> getAll(){
        return VisionMissionData.get();
    }

    public VisionMission getById(Long id){
        return this.getAll().stream().filter(visionMission -> visionMission.getId().equals(id)).findFirst().orElse(null);
    }

    public VisionMission update(VisionMission visionMission){
        return null;
    }

    public void deleteById(Long id){}
}
