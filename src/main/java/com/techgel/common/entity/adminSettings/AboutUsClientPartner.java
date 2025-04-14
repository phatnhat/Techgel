package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "about_us_client_partner")
public class AboutUsClientPartner extends BasedEntity {
    private String title_vi;
    private String title_en;
    private int displayOrder;

    public AboutUsClientPartner(String title_vi, String title_en, int displayOrder) {
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.displayOrder = displayOrder;
    }
}
