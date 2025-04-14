package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsVMVItems;
import com.techgel.common.repository.AboutUsVMVItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutUsVMVItemService {
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
