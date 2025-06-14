package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.HRPolicies;
import com.techgel.common.entity.adminSettings.News;

import java.util.List;

public abstract class HRPoliciesData {
    public static List<HRPolicies> get() {
        return List.of(
                new HRPolicies(1L, "Chính sách nhân sự", "HR Policies", "/imgs/banners/hr-policies.jpg")
        );
    }
}
