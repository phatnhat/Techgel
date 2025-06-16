package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.VisionMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisionMissionRepository extends JpaRepository<VisionMission, Long> {
}
