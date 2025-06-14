package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AttractTalentItems;
import com.techgel.common.entity.adminSettings.News;

import java.util.List;

public interface AttractTalentItemsService {
    AttractTalentItems getById(Long id);
    List<AttractTalentItems> getAll();
    AttractTalentItems update(AttractTalentItems attractTalentItems);
}
