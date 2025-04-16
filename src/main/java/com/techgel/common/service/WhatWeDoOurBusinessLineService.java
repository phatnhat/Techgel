package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.WhatWeDoOurBusinessLine;

import java.util.List;

public interface WhatWeDoOurBusinessLineService {
    List<WhatWeDoOurBusinessLine> getAll();
    WhatWeDoOurBusinessLine getById(Long id);
    WhatWeDoOurBusinessLine update(WhatWeDoOurBusinessLine whatWeDoOurBusinessLine);
}
