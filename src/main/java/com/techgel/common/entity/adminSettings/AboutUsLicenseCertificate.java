package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "about_us_license_certificate")
public class AboutUsLicenseCertificate extends BasedEntity {
    private String title_vi;
    private String title_en;
    private int displayOrder;

    @OneToMany(mappedBy = "aboutUsLicenseCertificate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AboutUsLicenseCertificateItems> aboutUsLicenseCertificateItems = new ArrayList<>();

    public AboutUsLicenseCertificate(String title_vi, String title_en, int displayOrder) {
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.displayOrder = displayOrder;
    }
}
