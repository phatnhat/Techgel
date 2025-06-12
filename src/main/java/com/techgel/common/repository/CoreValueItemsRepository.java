package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.CoreValue;
import com.techgel.common.entity.adminSettings.CoreValueItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreValueItemsRepository extends JpaRepository<CoreValueItems, Long> {
}
