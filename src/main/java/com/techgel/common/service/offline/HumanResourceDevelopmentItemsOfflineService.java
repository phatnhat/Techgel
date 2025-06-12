package com.techgel.common.service.offline;

import com.techgel.StaticData.HumanResourceDevelopmentData;
import com.techgel.StaticData.HumanResourceDevelopmentItemsData;
import com.techgel.common.entity.adminSettings.HumanResourceDevelopment;
import com.techgel.common.entity.adminSettings.HumanResourceDevelopmentItems;
import com.techgel.common.service.HumanResourceDevelopmentItemsService;
import com.techgel.common.service.HumanResourceDevelopmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class HumanResourceDevelopmentItemsOfflineService implements HumanResourceDevelopmentItemsService {

    public HumanResourceDevelopmentItems getById(Long id){
        return this.getAll().stream().filter(humanResourceDevelopmentItems -> humanResourceDevelopmentItems.getId()
                .equals(id)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Human resource development items not found"));
    }

    public List<HumanResourceDevelopmentItems> getAll(){
        return HumanResourceDevelopmentItemsData.get();
    }

    public HumanResourceDevelopmentItems update(HumanResourceDevelopmentItems humanResourceDevelopmentItems){
        return null;
    }
}
