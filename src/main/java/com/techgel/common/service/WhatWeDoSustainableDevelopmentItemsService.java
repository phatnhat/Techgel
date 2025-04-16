package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.WhatWeDoSustainableDevelopmentItems;

import java.util.List;

public interface WhatWeDoSustainableDevelopmentItemsService {
    List<WhatWeDoSustainableDevelopmentItems> getAll();
    WhatWeDoSustainableDevelopmentItems getById(Long id);
    WhatWeDoSustainableDevelopmentItems update(WhatWeDoSustainableDevelopmentItems whatWeDoSustainableDevelopmentItems);
}
