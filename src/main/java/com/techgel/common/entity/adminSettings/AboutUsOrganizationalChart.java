package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "about_us_organizational_charts")
public class AboutUsOrganizationalChart extends BasedEntity {
    private String title_vi;
    private String title_en;
    private String subtitle_vi;
    private String subtitle_en;
    private String file_url;

    public AboutUsOrganizationalChart(String title_vi, String title_en, String subtitle_vi, String subtitle_en) {
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.subtitle_vi = subtitle_vi;
        this.subtitle_en = subtitle_en;
    }

    public AboutUsOrganizationalChart(Long id, String title_vi, String title_en, String subtitle_vi, String subtitle_en, String file_url) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.subtitle_vi = subtitle_vi;
        this.subtitle_en = subtitle_en;
        this.file_url = file_url;
    }
}
