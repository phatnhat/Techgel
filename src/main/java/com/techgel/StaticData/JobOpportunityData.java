package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.JobOpportunity;
import com.techgel.common.entity.adminSettings.News;

import java.util.List;

public abstract class JobOpportunityData {
    public static List<JobOpportunity> get() {
        return List.of(
                new JobOpportunity(1L, "Cơ hội nghề nghiệp", "Job Opportunities", "/imgs/banners/job-opportunity.webp")
        );
    }
}
