package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.HomeOurBusinessLine;
import com.techgel.common.entity.adminSettings.WhatWeDoOurBusinessLine;

import java.util.List;

public interface HomeOurBusinessLineService {
    List<HomeOurBusinessLine> getAll();
    HomeOurBusinessLine getById(Long id);
    HomeOurBusinessLine update(HomeOurBusinessLine homeOurBusinessLine);
}
