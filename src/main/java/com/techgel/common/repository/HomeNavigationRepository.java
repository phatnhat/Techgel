package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.HomeNavigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeNavigationRepository extends JpaRepository<HomeNavigation, Long> {
}
