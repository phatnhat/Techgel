package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.WhatWeDoOurBusinessLine;
import com.techgel.common.repository.WhatWeDoOurBusinessLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WhatWeDoOurBusinessLineService {
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
