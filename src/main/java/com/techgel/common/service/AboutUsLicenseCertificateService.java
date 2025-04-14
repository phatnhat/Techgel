package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificate;
import com.techgel.common.repository.AboutUsLicenseCertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutUsLicenseCertificateService {
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
