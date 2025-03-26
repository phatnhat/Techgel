package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.EBrochure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EBrochureRepository extends JpaRepository<EBrochure, Long> {
}
