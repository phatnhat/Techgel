package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificate;
import com.techgel.common.repository.AboutUsLicenseCertificateRepository;
import com.techgel.common.service.AboutUsLicenseCertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class AboutUsLicenseCertificateServiceImpl implements AboutUsLicenseCertificateService {
    private final AboutUsLicenseCertificateRepository aboutUsLicenseCertificateRepository;

    public List<AboutUsLicenseCertificate> getAll(){
        return aboutUsLicenseCertificateRepository.findAll();
    }

    public AboutUsLicenseCertificate getById(Long id){
        return aboutUsLicenseCertificateRepository.findById(id).orElse(null);
    }

    public AboutUsLicenseCertificate update(AboutUsLicenseCertificate aboutUsLicenseCertificate){
        return aboutUsLicenseCertificateRepository.save(aboutUsLicenseCertificate);
    }

    public void deleteById(Long id){
        aboutUsLicenseCertificateRepository.deleteById(id);
    }
}
