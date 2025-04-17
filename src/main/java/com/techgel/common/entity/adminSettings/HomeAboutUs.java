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
@Table(name = "home_about_us")
public class HomeAboutUs extends BasedEntity {
    private String title_vi;
    private String title_en;
    private String subtitle_vi;
    private String subtitle_en;
    @Lob
    private String content_vi;
    @Lob
    private String content_en;
    private String image_url_1;
    private String image_url_2;
    private String image_url_3;

    public HomeAboutUs(String title_vi, String title_en, String subtitle_vi, String subtitle_en) {
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.subtitle_vi = subtitle_vi;
        this.subtitle_en = subtitle_en;
    }

    public HomeAboutUs(Long id, String title_vi, String title_en, String subtitle_vi, String subtitle_en, String content_vi, String content_en, String image_url_1, String image_url_2, String image_url_3) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.subtitle_vi = subtitle_vi;
        this.subtitle_en = subtitle_en;
        this.content_vi = content_vi;
        this.content_en = content_en;
        this.image_url_1 = image_url_1;
        this.image_url_2 = image_url_2;
        this.image_url_3 = image_url_3;
    }
}
