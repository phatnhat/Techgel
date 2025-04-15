package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AboutUsClientPartner;
import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutUsClientPartnerRepository extends JpaRepository<AboutUsClientPartner, Long> {
}
