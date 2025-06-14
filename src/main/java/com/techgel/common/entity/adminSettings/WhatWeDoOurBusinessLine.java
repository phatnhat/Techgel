package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "what_we_do_our_business_line")
public class WhatWeDoOurBusinessLine extends BasedEntity {
    private String title_vi;
    private String title_en;
    @Lob
    private String general_introduction_vi;
    @Lob
    private String general_introduction_en;
    private String banner_url;

    public WhatWeDoOurBusinessLine(Long id, String title_vi, String title_en, String general_introduction_vi, String general_introduction_en, String banner_url) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.general_introduction_vi = general_introduction_vi;
        this.general_introduction_en = general_introduction_en;
        this.banner_url = banner_url;
    }

    public String getTitle(String lang){
        return "vi".equalsIgnoreCase(lang) ? title_vi : title_en;
    }

    public String getGeneralIntroduction(String lang){
        return "vi".equalsIgnoreCase(lang) ? general_introduction_vi : general_introduction_en;
    }
}
