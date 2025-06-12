package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificateList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutUsLicenseCertificateListRepository extends JpaRepository<AboutUsLicenseCertificateList, Long> {
}
