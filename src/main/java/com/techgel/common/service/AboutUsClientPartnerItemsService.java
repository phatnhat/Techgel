package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsClientPartnerItems;

import java.util.List;

public interface AboutUsClientPartnerItemsService {
    List<AboutUsClientPartnerItems> getAll();
    AboutUsClientPartnerItems getById(Long id);
    AboutUsClientPartnerItems getByIdAndParentId(Long id, Long parentId);
    AboutUsClientPartnerItems update(AboutUsClientPartnerItems AboutUsClientPartnerItems);
    void deleteById(Long id);
    List<AboutUsClientPartnerItems> getAllByAboutUsLicensesCertificateId(Long id);
}
