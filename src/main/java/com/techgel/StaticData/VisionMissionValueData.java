package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.VisionMission;
import com.techgel.common.entity.adminSettings.VisionMissionValue;

import java.util.List;

public class VisionMissionValueData {
    public static List<VisionMissionValue> get(){
        return List.of(
                new VisionMissionValue(1L, "Tầm nhìn, sứ mệnh & giá trị cốt lõi",
                        "Vision, mission & core values", "/imgs/banners/vision-banner.jpg")
        );
    }
}
