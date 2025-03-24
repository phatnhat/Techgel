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
    private String slug_vi;
    private String slug_en;
    private String title_vi;
    private String title_en;
    private String description_vi;
    private String description_en;
    private String keywords_vi;
    private String keywords_en;
    private String og_title_vi;
    private String og_title_en;
    private String og_description_vi;
    private String og_description_en;
    private String entity_type;
}
