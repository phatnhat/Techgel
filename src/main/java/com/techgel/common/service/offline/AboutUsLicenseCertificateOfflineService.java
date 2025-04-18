package com.techgel.common.service.offline;

import com.techgel.StaticData.AboutUsLicenseCertificateData;
import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificate;
import com.techgel.common.service.AboutUsLicenseCertificateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
public class AboutUsLicenseCertificateOfflineService implements AboutUsLicenseCertificateService {
    public List<AboutUsLicenseCertificate> getAll(){
        return AboutUsLicenseCertificateData.get();
    }

    public AboutUsLicenseCertificate getById(Long id){
        return this.getAll().stream().filter(aboutUsLicenseCertificate -> aboutUsLicenseCertificate.getId().equals(id)).findFirst().orElse(null);
    }

    public AboutUsLicenseCertificate update(AboutUsLicenseCertificate aboutUsLicenseCertificate){
        return null;
    }

    public void deleteById(Long id){}
}
