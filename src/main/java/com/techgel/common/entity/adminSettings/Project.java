package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import com.techgel.common.entity.enums.ProjectRegions;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project extends BasedEntity {
    private String title_vi;
    private String title_en;
    private String client_name_vi;
    private String client_name_en;
    private String location_vi;
    private String location_en;
    private String scope_of_word_vi;
    private String scope_of_word_en;
    private String time_vi;
    private String time_en;
    private String description_vi;
    private String description_en;
    private String image_url;
    private int year;
    @Enumerated(EnumType.STRING)
    private String region;
    private boolean isFeatured;

    @ManyToOne
    @JoinColumn(name = "project_category_id")
    private ProjectCategory projectCategory;

    public Project(Long id) {
        super(id);
    }

    public Project(Long id, String title_vi, String title_en, String client_name_vi, String client_name_en,
            String location_vi, String location_en, String scope_of_word_vi, String scope_of_word_en, String time_vi,
            String time_en, String description_vi, String description_en, String image_url, int year, String region,
            boolean isFeatured, ProjectCategory projectCategory) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.client_name_vi = client_name_vi;
        this.client_name_en = client_name_en;
        this.location_vi = location_vi;
        this.location_en = location_en;
        this.scope_of_word_vi = scope_of_word_vi;
        this.scope_of_word_en = scope_of_word_en;
        this.time_vi = time_vi;
        this.time_en = time_en;
        this.description_vi = description_vi;
        this.description_en = description_en;
        this.image_url = image_url;
        this.year = year;
        this.region = region;
        this.isFeatured = isFeatured;
        this.projectCategory = projectCategory;
    }
}
