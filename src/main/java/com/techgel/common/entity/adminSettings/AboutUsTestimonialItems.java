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
@Table(name = "about_us_testimonial_items")
public class AboutUsTestimonialItems extends BasedEntity {
    @Lob
    private String description_vi;
    @Lob
    private String description_en;
    private String name_vi;
    private String name_en;
    private String designation_vi;
    private String designation_en;
    private String thumbnail_url;
    private int displayOrder;

    public AboutUsTestimonialItems(Long id, String description_vi, String description_en, String name_vi, String name_en, String designation_vi, String designation_en, String thumbnail_url, int displayOrder) {
        super(id);
        this.description_vi = description_vi;
        this.description_en = description_en;
        this.name_vi = name_vi;
        this.name_en = name_en;
        this.designation_vi = designation_vi;
        this.designation_en = designation_en;
        this.thumbnail_url = thumbnail_url;
        this.displayOrder = displayOrder;
    }
}
