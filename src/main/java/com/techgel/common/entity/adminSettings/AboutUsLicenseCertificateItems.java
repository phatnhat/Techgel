package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "about_us_license_certificate_items")
public class AboutUsLicenseCertificateItems extends BasedEntity {
    private String title_vi;
    private String title_en;
    private String image_url_vi;
    private String image_url_en;
    private int displayOrder;

    @ManyToOne
    @JoinColumn(name = "about_us_license_certificate_id")
    private AboutUsLicenseCertificateList aboutUsLicenseCertificateList;

    public AboutUsLicenseCertificateItems(Long id, String title_vi, String title_en, String image_url_vi, String image_url_en, int displayOrder, AboutUsLicenseCertificateList aboutUsLicenseCertificateList) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.image_url_vi = image_url_vi;
        this.image_url_en = image_url_en;
        this.displayOrder = displayOrder;
        this.aboutUsLicenseCertificateList = aboutUsLicenseCertificateList;
    }

    public String getTitle(String lang){
        return "vi".equalsIgnoreCase(lang) ? title_vi : title_en;
    }

    public String getImageUrl(String lang) {
        return "vi".equalsIgnoreCase(lang) ? image_url_vi : image_url_en;
    }
}
