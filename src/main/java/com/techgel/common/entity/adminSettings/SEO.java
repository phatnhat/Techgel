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
    private String meta_title_vi;
    private String meta_title_en;
    private String meta_description_vi;
    private String meta_description_en;
    private String meta_keywords_vi;
    private String meta_keywords_en;
    private String slug_vi;
    private String slug_en;
    private String entity_type;
}
