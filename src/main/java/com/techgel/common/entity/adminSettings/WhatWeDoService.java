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

    @OneToMany(mappedBy = "whatWeDoService", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WhatWeDoServiceItems> whatWeDoServiceItems = new ArrayList<>();
}
