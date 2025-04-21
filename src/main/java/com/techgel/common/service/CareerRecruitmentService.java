package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.CareerRecruitment;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.enums.NewsType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CareerRecruitmentService {
    CareerRecruitment getById(Long id);
    Page<CareerRecruitment> getAll(Pageable pageable);
    CareerRecruitment update(CareerRecruitment careerRecruitment);
}
