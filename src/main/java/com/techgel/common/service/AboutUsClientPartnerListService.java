package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsClientPartner;
import com.techgel.common.entity.adminSettings.AboutUsClientPartnerList;

import java.util.List;

public interface AboutUsClientPartnerListService {
    List<AboutUsClientPartnerList> getAll();
    AboutUsClientPartnerList getById(Long id);
    AboutUsClientPartnerList update(AboutUsClientPartnerList aboutUsClientPartnerList);
    void deleteById(Long id);
}
