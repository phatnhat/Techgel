package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.CareerRecruitment;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.enums.NewsType;
import com.techgel.common.repository.CareerRecruitmentRepository;
import com.techgel.common.repository.NewsRepository;
import com.techgel.common.service.CareerRecruitmentService;
import com.techgel.common.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class CareerRecruitmentServiceImpl implements CareerRecruitmentService {
    private final CareerRecruitmentRepository careerRecruitmentRepository;

    public Page<CareerRecruitment> getAll(Pageable pageable){
        return careerRecruitmentRepository.findAll(pageable);
    }


    public CareerRecruitment getById(Long id){
        return careerRecruitmentRepository.findById(id).orElse(null);
    }


    public CareerRecruitment update(CareerRecruitment careerRecruitment){
        return careerRecruitmentRepository.save(careerRecruitment);
    }

}
