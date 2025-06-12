package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsClientPartnerItems;
import com.techgel.common.entity.adminSettings.CeoMessage;

import java.util.List;

public interface CeoMessageService {
    List<CeoMessage> getAll();
    CeoMessage getById(Long id);
}
