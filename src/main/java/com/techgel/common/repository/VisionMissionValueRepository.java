package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.VisionMissionValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisionMissionValueRepository extends JpaRepository<VisionMissionValue, Long> {
}
