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
@Table(name = "hr_policies")
public class HRPolicies extends BasedEntity {
    private String title_vi;
    private String title_en;

    private String banner_url;

    public HRPolicies(Long id, String title_vi, String title_en, String banner_url) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.banner_url = banner_url;
    }

    public String getTitle(String lang){
        return "vi".equalsIgnoreCase(lang) ? title_vi : title_en;
    }
}
