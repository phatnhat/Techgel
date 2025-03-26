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
@Table(name = "seos")
public class SEO extends BasedEntity {
    private String seo_slug_vi;
    private String seo_slug_en;
    private String seo_title_vi;
    private String seo_title_en;
    private String seo_description_vi;
    private String seo_description_en;
    private String seo_keywords_vi;
    private String seo_keywords_en;
    private String seo_og_title_vi;
    private String seo_og_title_en;
    private String seo_og_description_vi;
    private String seo_og_description_en;
    private String seo_entity_type;
}
