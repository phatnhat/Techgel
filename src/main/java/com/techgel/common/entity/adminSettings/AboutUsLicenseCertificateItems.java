package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    private String image_url;
    private int displayOrder;

    @ManyToOne
    @JoinColumn(name = "about_us_license_certificate_id")
    private AboutUsLicenseCertificate aboutUsLicenseCertificate;

    public AboutUsLicenseCertificateItems(String title_vi, String title_en, String image_url, int displayOrder) {
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.image_url = image_url;
        this.displayOrder = displayOrder;
    }

    public AboutUsLicenseCertificateItems(String title_vi, String title_en, String image_url) {
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.image_url = image_url;
    }
}
