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
    private String title_vi;
    private String title_en;

    private String banner_url;

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

    public WhatWeDoSustainableDevelopment(Long id, String title_vi, String title_en, String banner_url, String quote_vi, String quote_en, String commit_title_vi, String commit_title_en, String commit_content_vi, String commit_content_en) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.banner_url = banner_url;
        this.quote_vi = quote_vi;
        this.quote_en = quote_en;
        this.commit_title_vi = commit_title_vi;
        this.commit_title_en = commit_title_en;
        this.commit_content_vi = commit_content_vi;
        this.commit_content_en = commit_content_en;
    }

    public String getTitle(String lang){
        return "vi".equalsIgnoreCase(lang) ? title_vi : title_en;
    }

    public String getQuote(String lang){
        return "vi".equalsIgnoreCase(lang) ? quote_vi : quote_en;
    }

    public String getCommitTitle(String lang){
        return "vi".equalsIgnoreCase(lang) ? commit_title_vi : commit_title_en;
    }

    public String getCommitContent(String lang){
        return "vi".equalsIgnoreCase(lang) ? commit_content_vi : commit_content_en;
    }
}
