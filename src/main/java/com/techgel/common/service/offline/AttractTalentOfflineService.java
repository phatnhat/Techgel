package com.techgel.common.service.offline;

import com.techgel.StaticData.AttractTalentData;
import com.techgel.StaticData.NewsData;
import com.techgel.common.entity.adminSettings.AttractTalent;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.service.AttractTalentService;
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
public class AttractTalentOfflineService implements AttractTalentService {

    public AttractTalent getById(Long id){
        return this.getAll().stream().filter(attractTalent -> attractTalent.getId()
                .equals(id)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Attract Talent not found"));
    }

    public List<AttractTalent> getAll(){
        return AttractTalentData.get();
    }

    public AttractTalent update(AttractTalent attractTalent){
        return null;
    }
}
