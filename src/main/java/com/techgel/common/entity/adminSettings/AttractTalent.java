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
@Table(name = "attract_talents")
public class AttractTalent extends BasedEntity {
    private String title_vi;
    private String title_en;
    private String image_general_image;
    @Lob
    private String general_content_vi;
    @Lob
    private String general_content_en;
    private String description_vi;
    private String description_en;

    public AttractTalent(Long id, String title_vi, String title_en, String image_general_image, String general_content_vi, String general_content_en, String description_vi, String description_en) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.image_general_image = image_general_image;
        this.general_content_vi = general_content_vi;
        this.general_content_en = general_content_en;
        this.description_vi = description_vi;
        this.description_en = description_en;
    }

    public String getTitle(String lang){
        return "vi".equalsIgnoreCase(lang) ? title_vi : title_en;
    }

    public String getGeneralContent(String lang){
        return "vi".equalsIgnoreCase(lang) ? general_content_vi : general_content_en;
    }

    public String getDescription(String lang){
        return "vi".equalsIgnoreCase(lang) ? description_vi : description_en;
    }
}
