package com.techgel.common.entity.adminSettings;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "home_navigations")
public class HomeNavigation extends BasedEntity {
    @Column(length = 50, nullable = false)
    private String title_vi;

    @Column(length = 50, nullable = false)
    private String title_en;

    private boolean isPublished;

    private int displayOrder;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private HomeNavigation parent;

    @ToString.Exclude
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<HomeNavigation> children = new HashSet<>();

    public HomeNavigation(Long id) {
        this.id = id;
    }

    public HomeNavigation(String title_vi, String title_en, boolean isPublished, int displayOrder) {
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.isPublished = isPublished;
        this.displayOrder = displayOrder;
    }

    public HomeNavigation(String title_vi, String title_en, boolean isPublished, int displayOrder, HomeNavigation parent) {
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.isPublished = isPublished;
        this.displayOrder = displayOrder;
        this.parent = parent;
    }
}
