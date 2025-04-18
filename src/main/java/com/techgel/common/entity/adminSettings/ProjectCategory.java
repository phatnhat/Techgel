package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "project_categories")
public class ProjectCategory extends BasedEntity {
    private String name_vi;
    private String name_en;
    private String slug;
    private int displayOrder;

    @OneToMany(mappedBy = "aboutUsClientPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AboutUsClientPartnerItems> aboutUsClientPartnerItems = new ArrayList<>();

    public ProjectCategory(Long id) {
        super(id);
    }

    public ProjectCategory(Long id, String name_vi, String name_en, String slug, int displayOrder) {
        super(id);
        this.name_vi = name_vi;
        this.name_en = name_en;
        this.slug = slug;
        this.displayOrder = displayOrder;
    }
}
