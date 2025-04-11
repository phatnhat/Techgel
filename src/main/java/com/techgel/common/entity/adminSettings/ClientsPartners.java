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
@Table(name = "clients-partners")
public class ClientsPartners extends BasedEntity {
    private String title;
    private String image_url;
    private String link;
    private boolean is_published;
    private int display_order;
}
