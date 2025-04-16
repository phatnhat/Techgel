package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.WhatWeDoServiceItems;

import java.util.List;

public interface WhatWeDoServiceItemsService {
    List<WhatWeDoServiceItems> getAll();
    WhatWeDoServiceItems getById(Long id);
    void deleteById(Long id);
    WhatWeDoServiceItems update(WhatWeDoServiceItems whatWeDoServiceItems);
    WhatWeDoServiceItems getByIdAndParentId(Long id, Long parentId);
    List<WhatWeDoServiceItems> getAllByWhatWeDoServiceId(Long id);
}
