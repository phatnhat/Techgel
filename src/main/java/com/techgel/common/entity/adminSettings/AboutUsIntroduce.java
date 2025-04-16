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
@Table(name = "about_us_introduce")
public class AboutUsIntroduce extends BasedEntity {
    private String title_vi;
    private String title_en;
    private String subtitle_vi;
    private String subtitle_en;
    @Lob
    private String content_vi;
    @Lob
    private String content_en;
    private String image_url;
    private String image_title_vi;
    private String image_title_en;
    private String image_subtitle_vi;
    private String image_subtitle_en;

    public AboutUsIntroduce(String title_vi, String title_en, String subtitle_vi, String subtitle_en) {
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.subtitle_vi = subtitle_vi;
        this.subtitle_en = subtitle_en;
    }
}
