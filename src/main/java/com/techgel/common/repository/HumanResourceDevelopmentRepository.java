package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.HumanResourceDevelopment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanResourceDevelopmentRepository extends JpaRepository<HumanResourceDevelopment, Long> {
}
