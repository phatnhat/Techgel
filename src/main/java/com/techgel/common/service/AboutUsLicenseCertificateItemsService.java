package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificateItems;

import java.util.List;

public interface AboutUsLicenseCertificateItemsService {
    List<AboutUsLicenseCertificateItems> getAll();
    AboutUsLicenseCertificateItems getById(Long id);
    AboutUsLicenseCertificateItems getByIdAndParentId(Long id, Long parentId);
    AboutUsLicenseCertificateItems update(AboutUsLicenseCertificateItems AboutUsLicenseCertificateItems);
    void deleteById(Long id);
    List<AboutUsLicenseCertificateItems> getAllByAboutUsLicensesCertificateId(Long id);
}
