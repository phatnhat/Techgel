package com.techgel.common.entity.adminSettings;

import com.techgel.admin.validator.UniqueSlug;
import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "seos", uniqueConstraints = {
        @UniqueConstraint(columnNames = "seo_slug_vi"),
        @UniqueConstraint(columnNames = "seo_slug_en")
})
public class SEO extends BasedEntity {
    @UniqueSlug(idField = "id", langField = "vi", message = "Link thân thiên Vi đã được sử dụng")
    private String seo_slug_vi;
    @UniqueSlug(idField = "id", langField = "en", message = "Link thân thiện En đã được sử dụng")
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
}
