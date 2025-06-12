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
@Table(name = "attract_talent_items")
public class AttractTalentItems extends BasedEntity {
    private String title_vi;
    private String title_en;
    private String image_url;
    private String content_vi;
    private String content_en;

    public AttractTalentItems(Long id, String title_vi, String title_en, String image_url, String content_vi, String content_en) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.image_url = image_url;
        this.content_vi = content_vi;
        this.content_en = content_en;
    }

    public String getTitle(String lang){
        return "vi".equalsIgnoreCase(lang) ? title_vi : title_en;
    }

    public String getContent(String lang){
        return "vi".equalsIgnoreCase(lang) ? content_vi : content_en;
    }
}
