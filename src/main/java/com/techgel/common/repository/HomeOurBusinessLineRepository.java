package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.HomeOurBusinessLine;
import com.techgel.common.entity.adminSettings.WhatWeDoOurBusinessLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeOurBusinessLineRepository extends JpaRepository<HomeOurBusinessLine, Long> {
}
