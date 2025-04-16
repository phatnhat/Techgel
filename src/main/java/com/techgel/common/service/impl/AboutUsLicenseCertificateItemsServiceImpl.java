package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificateItems;
import com.techgel.common.repository.AboutUsLicenseCertificateItemsRepository;
import com.techgel.common.service.AboutUsLicenseCertificateItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class AboutUsLicenseCertificateItemsServiceImpl implements AboutUsLicenseCertificateItemsService {
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
