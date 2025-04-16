package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsClientPartner;

import java.util.List;

public interface AboutUsClientPartnerService {
    List<AboutUsClientPartner> getAll();
    AboutUsClientPartner getById(Long id);
    AboutUsClientPartner update(AboutUsClientPartner AboutUsClientPartner);
    void deleteById(Long id);
}
