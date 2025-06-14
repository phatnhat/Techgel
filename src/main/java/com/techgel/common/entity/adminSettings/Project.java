package com.techgel.common.entity.adminSettings;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.techgel.common.entity.BasedEntity;
import com.techgel.common.entity.enums.ProjectRegions;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project extends BasedEntity {
    private String title_vi;
    private String title_en;

    private String banner_url;

    public Project(Long id, String title_vi, String title_en, String banner_url) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.banner_url = banner_url;
    }

    public String getTitle(String lang){
        if(lang.equalsIgnoreCase("vi")) return this.getTitle_vi();
        return this.getTitle_en();
    }
}
