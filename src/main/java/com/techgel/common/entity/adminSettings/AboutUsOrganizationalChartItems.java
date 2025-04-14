package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.index.qual.SearchIndexBottom;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "about_us_organizational_chart_items")
public class AboutUsOrganizationalChartItems extends BasedEntity {
    private String image_url;
    private int displayOrder;
}
