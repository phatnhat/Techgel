package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AboutUsIntroduce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutUsIntroduceRepository extends JpaRepository<AboutUsIntroduce, Long> {
}
