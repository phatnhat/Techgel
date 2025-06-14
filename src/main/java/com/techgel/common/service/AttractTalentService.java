package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AttractTalent;
import com.techgel.common.entity.adminSettings.News;

import java.util.List;

public interface AttractTalentService {
    AttractTalent getById(Long id);
    List<AttractTalent> getAll();
    AttractTalent update(AttractTalent attractTalent);
}
