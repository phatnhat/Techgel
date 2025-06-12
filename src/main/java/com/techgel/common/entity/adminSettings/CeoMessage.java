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
@Table(name = "ceo_messages")
public class CeoMessage extends BasedEntity {
    private String title_vi;
    private String title_en;
    private String subtitle_vi;
    private String subtitle_en;
    private String subtitle_mark_vi;
    private String subtitle_mark_en;
    private String message_vi;
    private String message_en;
    private String signature_image;
    private String name_vi;
    private String name_en;
    private String position_vi;
    private String position_en;

    public CeoMessage(Long id, String title_vi, String title_en, String subtitle_vi, String subtitle_en, String subtitle_mark_vi, String subtitle_mark_en, String message_vi, String message_en, String signature_image, String name_vi, String name_en, String position_vi, String position_en) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.subtitle_vi = subtitle_vi;
        this.subtitle_en = subtitle_en;
        this.subtitle_mark_vi = subtitle_mark_vi;
        this.subtitle_mark_en = subtitle_mark_en;
        this.message_vi = message_vi;
        this.message_en = message_en;
        this.signature_image = signature_image;
        this.name_vi = name_vi;
        this.name_en = name_en;
        this.position_vi = position_vi;
        this.position_en = position_en;
    }

    public String getTitle(String lang) {
        return "vi".equalsIgnoreCase(lang) ? title_vi : title_en;
    }

    public String getSubTitle(String lang) {
        return "vi".equalsIgnoreCase(lang) ? subtitle_vi : subtitle_en;
    }

    public String getSubTitleMark(String lang) {
        return "vi".equalsIgnoreCase(lang) ? subtitle_mark_vi : subtitle_mark_en;
    }

    public String getMessage(String lang) {
        return "vi".equalsIgnoreCase(lang) ? message_vi : message_en;
    }

    public String getName(String lang) {
        return "vi".equalsIgnoreCase(lang) ? name_vi : name_en;
    }

    public String getPosition(String lang) {
        return "vi".equalsIgnoreCase(lang) ? position_vi : position_en;
    }
}
