package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.HRPolicies;
import com.techgel.common.entity.adminSettings.News;

import java.util.List;

public interface HRPoliciesService {
    HRPolicies getById(Long id);
    List<HRPolicies> getAll();
    HRPolicies update(HRPolicies hrPolicies);
}
