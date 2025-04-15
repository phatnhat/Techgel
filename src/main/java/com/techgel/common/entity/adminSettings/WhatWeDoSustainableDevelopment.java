package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "what_we_do_sustainable_development")
public class WhatWeDoSustainableDevelopment extends BasedEntity {
    @Lob
    private String quote_vi;
    @Lob
    private String quote_en;

    private String commit_title_vi;
    private String commit_title_en;

    @Lob
    private String commit_content_vi;
    @Lob
    private String commit_content_en;
}
