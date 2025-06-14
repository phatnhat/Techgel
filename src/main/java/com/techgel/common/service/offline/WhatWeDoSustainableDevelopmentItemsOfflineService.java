package com.techgel.common.service.offline;

import com.techgel.StaticData.WhatWeDoSustainableDevelopmentData;
import com.techgel.StaticData.WhatWeDoSustainableDevelopmentItemsData;
import com.techgel.common.entity.adminSettings.WhatWeDoSustainableDevelopment;
import com.techgel.common.entity.adminSettings.WhatWeDoSustainableDevelopmentItems;
import com.techgel.common.service.WhatWeDoSustainableDevelopmentItemsService;
import com.techgel.common.service.WhatWeDoSustainableDevelopmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class WhatWeDoSustainableDevelopmentItemsOfflineService implements WhatWeDoSustainableDevelopmentItemsService {
    public List<WhatWeDoSustainableDevelopmentItems> getAll(){
        return WhatWeDoSustainableDevelopmentItemsData.get();
    }

    public WhatWeDoSustainableDevelopmentItems getById(Long id){
        return this.getAll().stream()
                .filter(whatWeDoSustainableDevelopmentItems -> whatWeDoSustainableDevelopmentItems.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
    }

    public void deleteById(Long id){}

    public WhatWeDoSustainableDevelopmentItems update(WhatWeDoSustainableDevelopmentItems whatWeDoSustainableDevelopmentItems){
        return null;
    }
}
