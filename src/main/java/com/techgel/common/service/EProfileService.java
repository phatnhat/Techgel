package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.EProfile;

import java.util.List;

public interface EProfileService {
    EProfile getById(Long id);
    List<EProfile> getAll();
    void update(EProfile eProfile);
}
