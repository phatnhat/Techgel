package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AttractTalentItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractTalentItemsRepository extends JpaRepository<AttractTalentItems, Long> {
}
