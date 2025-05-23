package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.CareerRecruitment;
import com.techgel.common.entity.adminSettings.EProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRecruitmentRepository extends JpaRepository<CareerRecruitment, Long> {
    Page<CareerRecruitment> getAll(Pageable pageable);
}
