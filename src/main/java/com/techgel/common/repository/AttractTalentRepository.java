package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AttractTalent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractTalentRepository extends JpaRepository<AttractTalent, Long> {
}
