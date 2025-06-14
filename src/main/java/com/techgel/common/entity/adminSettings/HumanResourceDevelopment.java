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
@Table(name = "human_resource_development")
public class HumanResourceDevelopment extends BasedEntity {
    private String title_vi;
    private String title_en;
    private String left_content_vi;
    private String left_content_en;
    private String right_content_vi;
    private String right_content_en;
    private String description_vi;
    private String description_en;

    public HumanResourceDevelopment(Long id, String title_vi, String title_en, String left_content_vi, String left_content_en, String right_content_vi, String right_content_en, String description_vi, String description_en) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.left_content_vi = left_content_vi;
        this.left_content_en = left_content_en;
        this.right_content_vi = right_content_vi;
        this.right_content_en = right_content_en;
        this.description_vi = description_vi;
        this.description_en = description_en;
    }

    public String getTitle(String lang){
        return "vi".equalsIgnoreCase(lang) ? title_vi : title_en;
    }

    public String getLeftContent(String lang){ return "vi".equalsIgnoreCase(lang) ? left_content_vi : left_content_en; }

    public String getRightContent(String lang){ return "vi".equalsIgnoreCase(lang) ? right_content_vi : right_content_en; }

    public String getDescription(String lang){ return "vi".equalsIgnoreCase(lang) ? description_vi : description_en; }
}
