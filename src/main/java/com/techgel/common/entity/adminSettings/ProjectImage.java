package com.techgel.common.entity.adminSettings;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "project_images")
public class ProjectImage extends BasedEntity {
    private String image_url;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "project_id")
    private Project project;

    public ProjectImage(Long id, String image_url) {
        super(id);
        this.image_url = image_url;
    }
}
