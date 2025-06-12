package com.techgel.common.service.offline;

import com.techgel.StaticData.HRPoliciesData;
import com.techgel.StaticData.NewsData;
import com.techgel.common.entity.adminSettings.HRPolicies;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.service.HRPoliciesService;
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
public class HRPoliciesOfflineService implements HRPoliciesService {

    public HRPolicies getById(Long id){
        return this.getAll().stream().filter(hrPolicies -> hrPolicies.getId()
                .equals(id)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "News not found"));
    }

    public List<HRPolicies> getAll(){
        return HRPoliciesData.get();
    }

    public HRPolicies update(HRPolicies hrPolicies){
        return null;
    }
}
