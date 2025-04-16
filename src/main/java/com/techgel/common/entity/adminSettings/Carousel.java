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
}
