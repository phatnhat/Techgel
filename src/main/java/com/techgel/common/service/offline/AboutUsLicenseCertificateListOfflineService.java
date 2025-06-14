package com.techgel.common.service.offline;

import com.techgel.StaticData.AboutUsLicenseCertificateListData;
import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificateList;
import com.techgel.common.service.AboutUsLicenseCertificateListService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
public class AboutUsLicenseCertificateListOfflineService implements AboutUsLicenseCertificateListService {
    public List<AboutUsLicenseCertificateList> getAll(){
        return AboutUsLicenseCertificateListData.get();
    }

    public AboutUsLicenseCertificateList getById(Long id){
        return this.getAll().stream().filter(aboutUsLicenseCertificate -> aboutUsLicenseCertificate.getId().equals(id)).findFirst().orElse(null);
    }

    public AboutUsLicenseCertificateList update(AboutUsLicenseCertificateList aboutUsLicenseCertificate){
        return null;
    }

    public void deleteById(Long id){}
}
