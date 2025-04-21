package com.techgel.common.service.offline;

import com.techgel.StaticData.CareerRecruitmentData;
import com.techgel.common.entity.adminSettings.CareerRecruitment;
import com.techgel.common.repository.CareerRecruitmentRepository;
import com.techgel.common.service.CareerRecruitmentService;
import com.techgel.common.utils.PaginateList;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class CareerRecruitmentOfflineService implements CareerRecruitmentService {
    public Page<CareerRecruitment> getAll(Pageable pageable){
        List<CareerRecruitment> careerRecruitments = CareerRecruitmentData.get();

        return PaginateList.page(careerRecruitments, pageable);
    }


    public CareerRecruitment getById(Long id){
        return CareerRecruitmentData.get().stream()
                .filter(careerRecruitment -> careerRecruitment.getId().equals(id)).findFirst().orElse(null);
    }


    public CareerRecruitment update(CareerRecruitment careerRecruitment){
        return null;
    }

}
