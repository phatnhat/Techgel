package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.WhatWeDoSustainableDevelopment;

import java.util.List;

public interface WhatWeDoSustainableDevelopmentService {
    List<WhatWeDoSustainableDevelopment> getAll();
    WhatWeDoSustainableDevelopment getById(Long id);
    WhatWeDoSustainableDevelopment update(WhatWeDoSustainableDevelopment whatWeDoSustainableDevelopment);
}
