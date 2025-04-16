package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsIntroduce;

import java.util.List;

public interface AboutUsIntroduceService {
    List<AboutUsIntroduce> getAll();
    AboutUsIntroduce getById(Long id);
    AboutUsIntroduce update(AboutUsIntroduce aboutUsIntroduce);
}
