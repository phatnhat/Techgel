package com.techgel.common.entity.adminSettings;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "about_us_vmv_items")
public class AboutUsVMVItems extends BasedEntity {
    private String title_vi;
    private String title_en;
    private String content_vi;
    private String content_en;
    private int displayOrder;
    private boolean hasChildren;
    private String image_url;
    private String icon_url;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private AboutUsVMVItems parent;

    public AboutUsVMVItems(String title_vi, String title_en, String content_vi, String content_en, int displayOrder, boolean hasChildren, AboutUsVMVItems parent) {
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.content_vi = content_vi;
        this.content_en = content_en;
        this.displayOrder = displayOrder;
        this.hasChildren = hasChildren;
        this.parent = parent;
    }
}
