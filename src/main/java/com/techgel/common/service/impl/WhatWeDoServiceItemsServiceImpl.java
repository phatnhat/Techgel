package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.WhatWeDoServiceItems;
import com.techgel.common.repository.WhatWeDoServiceItemsRepository;
import com.techgel.common.service.WhatWeDoServiceItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class WhatWeDoServiceItemsServiceImpl implements WhatWeDoServiceItemsService {
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
