package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsVMVItems;

import java.util.List;

public interface AboutUsVMVItemService {
    List<AboutUsVMVItems> getAll();
    AboutUsVMVItems getById(Long id);
    AboutUsVMVItems update(AboutUsVMVItems aboutUsVMVItems);
    void deleteById(Long id);
}
