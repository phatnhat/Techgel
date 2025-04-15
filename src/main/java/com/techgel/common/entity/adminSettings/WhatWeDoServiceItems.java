package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    private String icon;

    @ManyToOne
    @JoinColumn(name = "what_we_do_service_id")
    private WhatWeDoService whatWeDoService;
}
