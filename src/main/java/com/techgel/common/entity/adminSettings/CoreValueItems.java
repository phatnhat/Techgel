package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "core-value-items")
public class CoreValueItems extends BasedEntity {
    private String title_vi;
    private String title_en;
    private int orderNumber;
    private String content_vi;
    private String content_en;
    private String image_url;

    public CoreValueItems(Long id, String title_vi, String title_en, int orderNumber, String content_vi, String content_en, String image_url) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.orderNumber = orderNumber;
        this.content_vi = content_vi;
        this.content_en = content_en;
        this.image_url = image_url;
    }

    public String getTitle(String lang) {
        return "vi".equalsIgnoreCase(lang) ? title_vi : title_en;
    }

    public String getContent(String lang) {
        return "vi".equalsIgnoreCase(lang) ? content_vi : content_en;
    }
}
