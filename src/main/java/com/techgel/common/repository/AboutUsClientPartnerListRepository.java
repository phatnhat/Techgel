package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AboutUsClientPartner;
import com.techgel.common.entity.adminSettings.AboutUsClientPartnerList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutUsClientPartnerListRepository extends JpaRepository<AboutUsClientPartnerList, Long> {
}
