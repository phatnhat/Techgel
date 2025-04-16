package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.HomeStatisticItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeStatisticItemsRepository extends JpaRepository<HomeStatisticItems, Long> {
}
