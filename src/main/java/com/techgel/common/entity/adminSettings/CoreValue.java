package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "core-values")
public class CoreValue extends BasedEntity {
    private String title_vi;
    private String title_en;

    public CoreValue(Long id, String title_vi, String title_en) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
    }

    public String getTitle(String lang) {
        return "vi".equalsIgnoreCase(lang) ? title_vi : title_en;
    }
}
