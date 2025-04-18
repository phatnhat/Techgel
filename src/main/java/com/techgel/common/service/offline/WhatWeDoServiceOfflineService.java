package com.techgel.common.service.offline;

import com.techgel.StaticData.WhatWeDoServiceData;
import com.techgel.common.entity.adminSettings.WhatWeDoService;
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
        return WhatWeDoServiceData.get();
    }

    public WhatWeDoService getById(Long id){
        return this.getAll().stream().filter(whatWeDoService -> whatWeDoService.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteById(Long id){}

    public WhatWeDoService update(WhatWeDoService whatWeDoService){
        return null;
    }
}
