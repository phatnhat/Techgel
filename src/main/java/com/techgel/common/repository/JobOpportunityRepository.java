package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.JobOpportunity;
import com.techgel.common.entity.adminSettings.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOpportunityRepository extends JpaRepository<JobOpportunity, Long> {
}
