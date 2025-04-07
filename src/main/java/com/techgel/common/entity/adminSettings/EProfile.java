package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "eprofiles", uniqueConstraints = {
        @UniqueConstraint(columnNames = "title_vi"),
        @UniqueConstraint(columnNames = "title_en")
})
public class EProfile extends BasedEntity {
    @NotBlank(message = "Title vi không được để trống")
    @Size(max = 50, message = "Title en không vượt quá 50 ký tự")
    @Column(length = 50, unique = true, nullable = false)
    private String title_vi;

    @NotBlank(message = "Title en không được để trống")
    @Size(max = 50, message = "Title en không vượt quá 50 ký tự")
    @Column(length = 50, unique = true, nullable = false)
    private String title_en;

    private boolean isPublished;
    private String image_url;
    private String file_url;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "seo_id")
    private SEO seo;

    public EProfile(String title_vi, String title_en, String image_url, boolean isPublished, String file_url, SEO seo) {
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.image_url = image_url;
        this.isPublished = isPublished;
        this.file_url = file_url;
        this.seo = seo;
    }
}
