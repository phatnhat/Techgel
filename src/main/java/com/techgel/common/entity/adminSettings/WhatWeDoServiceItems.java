package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "what_we_do_service_items")
public class WhatWeDoServiceItems extends BasedEntity {
    private String title_vi;
    private String title_en;
    private int displayOrder;
    @Lob
    private String description_vi;
    @Lob
    private String description_en;

    @ManyToOne
    @JoinColumn(name = "what_we_do_service_id")
    private WhatWeDoService whatWeDoService;

    public WhatWeDoServiceItems(Long id, String title_vi, String title_en, int displayOrder, String description_vi, String description_en) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.displayOrder = displayOrder;
        this.description_vi = description_vi;
        this.description_en = description_en;
    }
}
