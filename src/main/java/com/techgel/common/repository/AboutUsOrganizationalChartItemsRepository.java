package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutUsOrganizationalChartItemsRepository extends JpaRepository<AboutUsOrganizationalChartItems, Long> {
}
