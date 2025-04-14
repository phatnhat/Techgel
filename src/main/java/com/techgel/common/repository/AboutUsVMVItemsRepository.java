package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AboutUsVMVItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutUsVMVItemsRepository extends JpaRepository<AboutUsVMVItems, Long> {
}
