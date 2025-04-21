package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "career_recruitments")
public class CareerRecruitment extends BasedEntity {
    private String title_vi;
    private String title_en;
    private int quantity;
    private String qualification_vi;
    private String qualification_en;
    private String experience_vi;
    private String experience_en;
    private String workplace_vi;
    private String workplace_en;
    private Date expiration_date;
    @Lob
    private String description_vi;
    @Lob
    private String description_en;
    private String image_url;

    public CareerRecruitment(Long id, String title_vi, String title_en, int quantity, String qualification_vi, String qualification_en, String experience_vi, String experience_en, String workplace_vi, String workplace_en, Date expiration_date, String description_vi, String description_en, String image_url) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.quantity = quantity;
        this.qualification_vi = qualification_vi;
        this.qualification_en = qualification_en;
        this.experience_vi = experience_vi;
        this.experience_en = experience_en;
        this.workplace_vi = workplace_vi;
        this.workplace_en = workplace_en;
        this.expiration_date = expiration_date;
        this.description_vi = description_vi;
        this.description_en = description_en;
        this.image_url = image_url;
    }
}
