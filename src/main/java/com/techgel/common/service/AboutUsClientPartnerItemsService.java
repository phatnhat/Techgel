package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.AboutUsClientPartnerItems;
import com.techgel.common.repository.AboutUsClientPartnerItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutUsClientPartnerItemsService {
    private final AboutUsClientPartnerItemsRepository aboutUsClientPartnerItemsRepository;

    public List<AboutUsClientPartnerItems> getAll(){
        return aboutUsClientPartnerItemsRepository.findAll();
    }

    public AboutUsClientPartnerItems getById(Long id){
        return aboutUsClientPartnerItemsRepository.findById(id).orElse(null);
    }

    public AboutUsClientPartnerItems getByIdAndParentId(Long id, Long parentId){
        return aboutUsClientPartnerItemsRepository.findByIdAndAboutUsClientPartnerId(id, parentId).orElse(null);
    }

    public AboutUsClientPartnerItems update(AboutUsClientPartnerItems AboutUsClientPartnerItems){
        return aboutUsClientPartnerItemsRepository.save(AboutUsClientPartnerItems);
    }

    public void deleteById(Long id){
        aboutUsClientPartnerItemsRepository.deleteById(id);
    }

    public List<AboutUsClientPartnerItems> getAllByAboutUsLicensesCertificateId(Long id){
        return aboutUsClientPartnerItemsRepository.findAllByAboutUsClientPartnerId(id);
    }
}
