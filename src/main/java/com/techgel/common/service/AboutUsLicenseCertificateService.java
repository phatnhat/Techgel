package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificate;

import java.util.List;

public interface AboutUsLicenseCertificateService {
    List<AboutUsLicenseCertificate> getAll();
    AboutUsLicenseCertificate getById(Long id);
    AboutUsLicenseCertificate update(AboutUsLicenseCertificate aboutUsLicenseCertificate);
    void deleteById(Long id);
}
