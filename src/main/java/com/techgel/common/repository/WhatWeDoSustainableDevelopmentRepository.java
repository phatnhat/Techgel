package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.WhatWeDoSustainableDevelopment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhatWeDoSustainableDevelopmentRepository extends JpaRepository<WhatWeDoSustainableDevelopment, Long> {
}
