package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificate;
import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificateItems;
import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AboutUsLicenseCertificateItemsRepository extends JpaRepository<AboutUsLicenseCertificateItems, Long> {
    List<AboutUsLicenseCertificateItems> findAllByAboutUsLicenseCertificateId(Long id);

    Optional<AboutUsLicenseCertificateItems> findByIdAndAboutUsLicenseCertificateId(Long parentId, Long id);
}
