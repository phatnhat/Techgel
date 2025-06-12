package com.techgel.common.service.offline;

import com.techgel.StaticData.WhatWeDoServiceData;
import com.techgel.StaticData.WhatWeDoSustainableDevelopmentData;
import com.techgel.common.entity.adminSettings.WhatWeDoService;
import com.techgel.common.entity.adminSettings.WhatWeDoSustainableDevelopment;
import com.techgel.common.service.WhatWeDoServiceService;
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
public class WhatWeDoSustainableDevelopmentOfflineService implements WhatWeDoSustainableDevelopmentService {
    public List<WhatWeDoSustainableDevelopment> getAll(){
        return WhatWeDoSustainableDevelopmentData.get();
    }

    public WhatWeDoSustainableDevelopment getById(Long id){
        return this.getAll().stream()
                .filter(whatWeDoSustainableDevelopment -> whatWeDoSustainableDevelopment.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
    }

    public void deleteById(Long id){}

    public WhatWeDoSustainableDevelopment update(WhatWeDoSustainableDevelopment whatWeDoSustainableDevelopment){
        return null;
    }
}
