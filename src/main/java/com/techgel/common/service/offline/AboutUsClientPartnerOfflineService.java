package com.techgel.common.service.offline;

import com.techgel.client.StaticData;
import com.techgel.common.entity.adminSettings.AboutUsClientPartner;
import com.techgel.common.repository.AboutUsClientPartnerRepository;
import com.techgel.common.service.AboutUsClientPartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
public class AboutUsClientPartnerOfflineService implements AboutUsClientPartnerService {

    public List<AboutUsClientPartner> getAll(){
        return StaticData.aboutUsClientPartnerData();
    }

    public AboutUsClientPartner getById(Long id){
        return this.getAll().stream().filter(aboutUsClientPartner -> aboutUsClientPartner.getId().equals(id)).findFirst().orElse(null);
    }

    public AboutUsClientPartner update(AboutUsClientPartner AboutUsClientPartner){
        return null;
    }

    public void deleteById(Long id){}
}
