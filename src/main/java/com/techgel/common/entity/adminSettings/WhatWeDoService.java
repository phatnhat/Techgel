package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "what_we_do_service")
public class WhatWeDoService extends BasedEntity {
    private String title_vi;
    private String title_en;
    private int displayOrder;
    private String image_url;
    private String image_popup_url;
    @Lob
    private String description_vi;
    @Lob
    private String description_en;

    @OneToMany(mappedBy = "whatWeDoService", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WhatWeDoServiceItems> whatWeDoServiceItems = new ArrayList<>();

    public WhatWeDoService(Long id, String title_vi, String title_en, int displayOrder, String image_url, String image_popup_url, String description_vi, String description_en) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.displayOrder = displayOrder;
        this.image_url = image_url;
        this.image_popup_url = image_popup_url;
        this.description_vi = description_vi;
        this.description_en = description_en;
    }
}
