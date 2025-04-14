package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificate;
import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificateItems;
import com.techgel.common.repository.AboutUsLicenseCertificateItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutUsLicenseCertificateItemsService {
    private final AboutUsLicenseCertificateItemsRepository aboutUsLicenseCertificateItemsRepository;

    public List<AboutUsLicenseCertificateItems> getAll(){
        return aboutUsLicenseCertificateItemsRepository.findAll();
    }

    public AboutUsLicenseCertificateItems getById(Long id){
        return aboutUsLicenseCertificateItemsRepository.findById(id).orElse(null);
    }

    public AboutUsLicenseCertificateItems getByIdAndParentId(Long id, Long parentId){
        return aboutUsLicenseCertificateItemsRepository.findByIdAndAboutUsLicenseCertificateId(id, parentId).orElse(null);
    }

    public AboutUsLicenseCertificateItems update(AboutUsLicenseCertificateItems AboutUsLicenseCertificateItems){
        return aboutUsLicenseCertificateItemsRepository.save(AboutUsLicenseCertificateItems);
    }

    public void deleteById(Long id){
        aboutUsLicenseCertificateItemsRepository.deleteById(id);
    }

    public List<AboutUsLicenseCertificateItems> getAllByAboutUsLicensesCertificateId(Long id){
        return aboutUsLicenseCertificateItemsRepository.findAllByAboutUsLicenseCertificateId(id);
    }
}
