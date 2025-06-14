package com.techgel.common.service.offline;

import com.techgel.StaticData.AttractTalentItemsData;
import com.techgel.StaticData.NewsData;
import com.techgel.common.entity.adminSettings.AttractTalentItems;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.service.AttractTalentItemsService;
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
public class AttractTalentItemsOfflineService implements AttractTalentItemsService {

    public AttractTalentItems getById(Long id){
        return this.getAll().stream().filter(attractTalentItems -> attractTalentItems.getId()
                .equals(id)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Attract Talent not found"));
    }

    public List<AttractTalentItems> getAll(){
        return AttractTalentItemsData.get();
    }

    public AttractTalentItems update(AttractTalentItems attractTalentItems){
        return null;
    }
}
