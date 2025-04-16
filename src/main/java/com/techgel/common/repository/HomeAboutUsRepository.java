package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.HomeAboutUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeAboutUsRepository extends JpaRepository<HomeAboutUs, Long> {
}
