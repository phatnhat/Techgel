package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "mission_value")
public class VisionMission extends BasedEntity {
    private String title_vi;
    private String title_en;
    @Lob
    private String content_vi;
    @Lob
    private String content_en;
    private String image_url_1;
    private int order;

    public VisionMission(Long id, String title_vi, String title_en, String content_vi, String content_en, String image_url_1, int order) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.content_vi = content_vi;
        this.content_en = content_en;
        this.image_url_1 = image_url_1;
        this.order = order;
    }
}
