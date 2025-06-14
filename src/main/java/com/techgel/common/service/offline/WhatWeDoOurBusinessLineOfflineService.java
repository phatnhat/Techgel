package com.techgel.common.service.offline;

import com.techgel.StaticData.WhatWeDoOurBusinessLineData;
import com.techgel.StaticData.WhatWeDoServiceData;
import com.techgel.common.entity.adminSettings.WhatWeDoOurBusinessLine;
import com.techgel.common.entity.adminSettings.WhatWeDoService;
import com.techgel.common.service.WhatWeDoOurBusinessLineService;
import com.techgel.common.service.WhatWeDoServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class WhatWeDoOurBusinessLineOfflineService implements WhatWeDoOurBusinessLineService {
    public List<WhatWeDoOurBusinessLine> getAll(){
        return WhatWeDoOurBusinessLineData.get();
    }

    public WhatWeDoOurBusinessLine getById(Long id){
        return this.getAll().stream()
                .filter(whatWeDoOurBusinessLine -> whatWeDoOurBusinessLine.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
    }

    public void deleteById(Long id){}

    public WhatWeDoOurBusinessLine update(WhatWeDoOurBusinessLine whatWeDoOurBusinessLine){
        return null;
    }
}
