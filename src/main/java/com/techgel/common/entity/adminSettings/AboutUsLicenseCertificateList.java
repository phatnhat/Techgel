package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
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
@Table(name = "about_us_license_certificate_list")
public class AboutUsLicenseCertificateList extends BasedEntity {
    private String title_vi;
    private String title_en;
    private int displayOrder;

    @OneToMany(mappedBy = "aboutUsLicenseCertificate")
    private List<AboutUsLicenseCertificateItems> aboutUsLicenseCertificateItems = new ArrayList<>();

    public AboutUsLicenseCertificateList(String title_vi, String title_en, int displayOrder) {
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.displayOrder = displayOrder;
    }

    public AboutUsLicenseCertificateList(Long id, String title_vi, String title_en, int displayOrder) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.displayOrder = displayOrder;
    }

    public String getTitle(String lang){
        return "vi".equalsIgnoreCase(lang) ? title_vi : title_en;
    }
}
