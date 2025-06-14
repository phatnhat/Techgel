package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificate;
import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificateItems;
import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificateList;

import java.util.List;

public abstract class AboutUsLicenseCertificateData {
    public static List<AboutUsLicenseCertificate> get(){
        return List.of(
                new AboutUsLicenseCertificate(1L, "Giấy phép và Chứng chỉ", "Licenses & Certificates", "/imgs/banners/certifications.jpg")
        );
    }
}
