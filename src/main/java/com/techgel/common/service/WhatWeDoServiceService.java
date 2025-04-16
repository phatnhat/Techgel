package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.WhatWeDoService;

import java.util.List;

public interface WhatWeDoServiceService {
    List<WhatWeDoService> getAll();
    WhatWeDoService getById(Long id);
    void deleteById(Long id);
    WhatWeDoService update(WhatWeDoService whatWeDoService);
}
