package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.AboutUsClientPartner;
import com.techgel.common.repository.AboutUsClientPartnerRepository;
import com.techgel.common.service.AboutUsClientPartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class AboutUsClientPartnerServiceImpl implements AboutUsClientPartnerService {
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
