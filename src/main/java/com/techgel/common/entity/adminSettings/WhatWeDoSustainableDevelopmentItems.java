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
@Table(name = "what_we_do_sustainable_development_items")
public class WhatWeDoSustainableDevelopmentItems extends BasedEntity {
    private String title_vi;
    private String title_en;

    private String image_url;

    @Lob
    private String content_vi;
    @Lob
    private String content_en;
}
