package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.WhatWeDoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhatWeDoServiceRepository extends JpaRepository<WhatWeDoService, Long> {
}
