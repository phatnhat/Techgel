package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.EProfile;

public abstract class EProfileData {
    public static EProfile get(){
        return new EProfile("Hồ sơ năng lực", "E-Profile", "/imgs/HSNL.png", true, "/files/TECHGEL-COMPANY-PROFILE-2025-02.pdf");
    }
}
