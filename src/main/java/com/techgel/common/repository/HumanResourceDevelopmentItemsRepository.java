package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.HumanResourceDevelopment;
import com.techgel.common.entity.adminSettings.HumanResourceDevelopmentItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanResourceDevelopmentItemsRepository extends JpaRepository<HumanResourceDevelopmentItems, Long> {
}
