package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsClientPartner;
import com.techgel.common.repository.AboutUsClientPartnerRepository;
import com.techgel.common.repository.AboutUsClientPartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutUsClientPartnerService {
    private final AboutUsClientPartnerRepository aboutUsClientPartnerRepository;

    public List<AboutUsClientPartner> getAll(){
        return aboutUsClientPartnerRepository.findAll();
    }

    public AboutUsClientPartner getById(Long id){
        return aboutUsClientPartnerRepository.findById(id).orElse(null);
    }

    public AboutUsClientPartner update(AboutUsClientPartner AboutUsClientPartner){
        return aboutUsClientPartnerRepository.save(AboutUsClientPartner);
    }

    public void deleteById(Long id){
        aboutUsClientPartnerRepository.deleteById(id);
    }
}
