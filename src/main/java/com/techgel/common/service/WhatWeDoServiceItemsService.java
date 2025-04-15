package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsClientPartnerItems;
import com.techgel.common.entity.adminSettings.WhatWeDoService;
import com.techgel.common.entity.adminSettings.WhatWeDoServiceItems;
import com.techgel.common.repository.WhatWeDoServiceItemsRepository;
import com.techgel.common.repository.WhatWeDoServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WhatWeDoServiceItemsService {
    private final WhatWeDoServiceItemsRepository whatWeDoServiceItemsRepository;

    public List<WhatWeDoServiceItems> getAll(){
        return whatWeDoServiceItemsRepository.findAll();
    }

    public WhatWeDoServiceItems getById(Long id){
        return whatWeDoServiceItemsRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        whatWeDoServiceItemsRepository.deleteById(id);
    }

    public WhatWeDoServiceItems update(WhatWeDoServiceItems whatWeDoServiceItems) {
        return whatWeDoServiceItemsRepository.save(whatWeDoServiceItems);
    }

    public WhatWeDoServiceItems getByIdAndParentId(Long id, Long parentId){
        return whatWeDoServiceItemsRepository.findByIdAndWhatWeDoServiceId(id, parentId).orElse(null);
    }

    public List<WhatWeDoServiceItems> getAllByWhatWeDoServiceId(Long id){
        return whatWeDoServiceItemsRepository.findAllByWhatWeDoServiceId(id);
    }
}
