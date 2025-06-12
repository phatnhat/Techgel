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
@Table(name = "human_resource_development_items")
public class HumanResourceDevelopmentItems extends BasedEntity {
    private String image_url;
    private int orderNumber;
    private String content_vi;
    private String content_en;

    public HumanResourceDevelopmentItems(Long id, String image_url, int orderNumber, String content_vi, String content_en) {
        super(id);
        this.image_url = image_url;
        this.orderNumber = orderNumber;
        this.content_vi = content_vi;
        this.content_en = content_en;
    }

    public String getContent(String lang){ return "vi".equalsIgnoreCase(lang) ? content_vi : content_en; }

}
