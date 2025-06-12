package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.JobOpportunity;
import com.techgel.common.entity.adminSettings.News;

import java.util.List;

public interface JobOpportunityService {
    JobOpportunity getById(Long id);
    List<JobOpportunity> getAll();
    JobOpportunity update(JobOpportunity jobOpportunity);
}
