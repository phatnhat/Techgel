package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.WhatWeDoOurBusinessLine;
import com.techgel.common.repository.WhatWeDoOurBusinessLineRepository;
import com.techgel.common.service.WhatWeDoOurBusinessLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class WhatWeDoOurBusinessLineServiceImpl implements WhatWeDoOurBusinessLineService {
    private final WhatWeDoOurBusinessLineRepository whatWeDoOurBusinessLineRepository;

    public List<WhatWeDoOurBusinessLine> getAll(){
        return whatWeDoOurBusinessLineRepository.findAll();
    }

    public WhatWeDoOurBusinessLine getById(Long id){
        return whatWeDoOurBusinessLineRepository.findById(id).orElse(null);
    }

    public WhatWeDoOurBusinessLine update(WhatWeDoOurBusinessLine whatWeDoOurBusinessLine){
        return whatWeDoOurBusinessLineRepository.save(whatWeDoOurBusinessLine);
    }
}
