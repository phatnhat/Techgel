package com.techgel.common.service.offline;

import com.techgel.StaticData.JobOpportunityData;
import com.techgel.StaticData.NewsData;
import com.techgel.common.entity.adminSettings.JobOpportunity;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.service.JobOpportunityService;
import com.techgel.common.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class JobOpportunityOfflineService implements JobOpportunityService {
    public JobOpportunity getById(Long id){
        return this.getAll().stream().filter(jobOpportunity -> jobOpportunity.getId()
                .equals(id)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "News not found"));
    }

    public List<JobOpportunity> getAll(){
        return JobOpportunityData.get();
    }

    public JobOpportunity update(JobOpportunity jobOpportunity){
        return null;
    }
}
