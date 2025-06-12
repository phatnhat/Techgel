package com.techgel.common.service.offline;

import com.techgel.StaticData.HumanResourceDevelopmentData;
import com.techgel.StaticData.NewsData;
import com.techgel.common.entity.adminSettings.HumanResourceDevelopment;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.service.HumanResourceDevelopmentService;
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
public class HumanResourceDevelopmentOfflineService implements HumanResourceDevelopmentService {

    public HumanResourceDevelopment getById(Long id){
        return this.getAll().stream().filter(humanResourceDevelopment -> humanResourceDevelopment.getId()
                .equals(id)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Human resource development not found"));
    }

    public List<HumanResourceDevelopment> getAll(){
        return HumanResourceDevelopmentData.get();
    }

    public HumanResourceDevelopment update(HumanResourceDevelopment humanResourceDevelopment){
        return null;
    }
}
