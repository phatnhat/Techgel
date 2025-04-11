package com.techgel.common.entity.adminSettings;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "home_navigations")
public class HomeNavigation extends BasedEntity {
    @NotBlank(message = "Title vi không được để trống")
    @Size(max = 50, message = "Title vi không vượt quá 50 ký tự")
    @Column(length = 50, unique = true, nullable = false)
    private String title_vi;

    @NotBlank(message = "Title en không được để trống")
    @Size(max = 50, message = "Title en không vượt quá 50 ký tự")
    @Column(length = 50, unique = true, nullable = false)
    private String title_en;

    private boolean isPublished;

    private int displayOrder;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private HomeNavigation parent;

    @OrderBy(value = "displayOrder ASC")
    @ToString.Exclude
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<HomeNavigation> children = new HashSet<>();

    private String slug;

    public HomeNavigation(Long id) {
        this.id = id;
    }

    public HomeNavigation(String title_vi, String title_en, boolean isPublished, int displayOrder, String slug) {
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.isPublished = isPublished;
        this.displayOrder = displayOrder;
        this.slug = slug;
    }

    public HomeNavigation(String title_vi, String title_en, boolean isPublished, int displayOrder, HomeNavigation parent, String slug) {
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.isPublished = isPublished;
        this.displayOrder = displayOrder;
        this.parent = parent;
        this.slug = slug;
    }

    public List<HomeNavigation> getChildrens(){
        return this.children.stream().filter(navigation -> navigation.getParent() != null && navigation.isPublished() == true).collect(Collectors.toList());
    }
}
