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
}
