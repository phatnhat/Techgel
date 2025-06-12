package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.CeoMessage;
import com.techgel.common.entity.adminSettings.CoreValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreValueRepository extends JpaRepository<CoreValue, Long> {
}
