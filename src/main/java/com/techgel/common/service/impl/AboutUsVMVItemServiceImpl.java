package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.AboutUsVMVItems;
import com.techgel.common.repository.AboutUsVMVItemsRepository;
import com.techgel.common.service.AboutUsVMVItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class AboutUsVMVItemServiceImpl implements AboutUsVMVItemService {
    private final AboutUsVMVItemsRepository aboutUsVMVItemsRepository;

    public List<AboutUsVMVItems> getAll(){
        return aboutUsVMVItemsRepository.findAll();
    }

    public AboutUsVMVItems getById(Long id){
        return aboutUsVMVItemsRepository.findById(id).orElse(null);
    }

    public AboutUsVMVItems update(AboutUsVMVItems aboutUsVMVItems){
        return aboutUsVMVItemsRepository.save(aboutUsVMVItems);
    }

    public void deleteById(Long id){
        aboutUsVMVItemsRepository.deleteById(id);
    }
}
