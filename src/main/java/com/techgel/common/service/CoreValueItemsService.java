package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.CoreValue;
import com.techgel.common.entity.adminSettings.CoreValueItems;

import java.util.List;

public interface CoreValueItemsService {
    List<CoreValueItems> getAll();
    CoreValueItems getById(Long id);
}
