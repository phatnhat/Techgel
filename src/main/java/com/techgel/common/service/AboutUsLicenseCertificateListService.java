package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificateList;

import java.util.List;

public interface AboutUsLicenseCertificateListService {
    List<AboutUsLicenseCertificateList> getAll();
    AboutUsLicenseCertificateList getById(Long id);
    AboutUsLicenseCertificateList update(AboutUsLicenseCertificateList aboutUsLicenseCertificate);
    void deleteById(Long id);
}
