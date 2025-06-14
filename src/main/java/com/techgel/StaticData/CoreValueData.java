package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.CoreValue;
import com.techgel.common.entity.adminSettings.VisionMission;

import java.util.List;

public class CoreValueData {
    public static List<CoreValue> get(){
        return List.of(
                new CoreValue(1L, "Giá trị cốt lõi", "Core values")
        );
    }
}
