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
@Table(name = "home_statistic_items")
public class HomeStatisticItems extends BasedEntity {
    private String title_vi;
    private String title_en;
    private double counter;
    private int displayOrder;
    private String unit_vi;
    private String unit_en;

    public HomeStatisticItems(Long id, String title_vi, String title_en, double counter, int displayOrder, String unit_vi, String unit_en) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.counter = counter;
        this.displayOrder = displayOrder;
        this.unit_vi = unit_vi;
        this.unit_en = unit_en;
    }
}
