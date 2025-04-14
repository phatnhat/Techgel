package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutUsOrganizationalChartRepository extends JpaRepository<AboutUsOrganizationalChart, Long> {
}
