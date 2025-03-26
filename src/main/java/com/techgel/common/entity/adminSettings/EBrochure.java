package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ebrochures")
public class EBrochure extends BasedEntity {
    private String title;
    private boolean isPublished;
    private String file_url;

    public EBrochure(String title, boolean isPublished, String file_url) {
        this.title = title;
        this.isPublished = isPublished;
        this.file_url = file_url;
    }
}
