package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificateList;
import com.techgel.common.repository.AboutUsLicenseCertificateListRepository;
import com.techgel.common.service.AboutUsLicenseCertificateListService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class AboutUsLicenseCertificateListServiceImpl implements AboutUsLicenseCertificateListService {
    private final AboutUsLicenseCertificateListRepository aboutUsLicenseCertificateListRepository;

    public List<AboutUsLicenseCertificateList> getAll(){
        return aboutUsLicenseCertificateListRepository.findAll();
    }

    public AboutUsLicenseCertificateList getById(Long id){
        return aboutUsLicenseCertificateListRepository.findById(id).orElse(null);
    }

    public AboutUsLicenseCertificateList update(AboutUsLicenseCertificateList aboutUsLicenseCertificateList){
        return aboutUsLicenseCertificateListRepository.save(aboutUsLicenseCertificateList);
    }

    public void deleteById(Long id){
        aboutUsLicenseCertificateListRepository.deleteById(id);
    }
}
