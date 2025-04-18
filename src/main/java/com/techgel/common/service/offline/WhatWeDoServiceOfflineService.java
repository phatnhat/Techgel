package com.techgel.common.service.offline;

import com.techgel.client.StaticData;
import com.techgel.common.entity.adminSettings.WhatWeDoService;
import com.techgel.common.repository.WhatWeDoServiceRepository;
import com.techgel.common.service.WhatWeDoServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class WhatWeDoServiceOfflineService implements WhatWeDoServiceService {
    public List<WhatWeDoService> getAll(){
        return StaticData.whatWeDoServiceData();
    }

    public WhatWeDoService getById(Long id){
        return this.getAll().stream().filter(whatWeDoService -> whatWeDoService.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteById(Long id){}

    public WhatWeDoService update(WhatWeDoService whatWeDoService){
        return null;
    }
}
