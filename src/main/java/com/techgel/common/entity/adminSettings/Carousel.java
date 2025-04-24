package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "carousels")
public class Carousel extends BasedEntity {
    private int displayOrder;
    private String image_url;
    private String description_vi;
    private String description_en;

    public Carousel(Long id, int displayOrder, String image_url, String description_vi, String description_en) {
        super(id);
        this.displayOrder = displayOrder;
        this.image_url = image_url;
        this.description_vi = description_vi;
        this.description_en = description_en;
    }
}
