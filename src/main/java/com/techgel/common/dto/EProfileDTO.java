package com.techgel.common.dto;

import com.techgel.common.entity.adminSettings.EProfile;
import com.techgel.common.entity.adminSettings.SEO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EProfileDTO {
    @Valid
    private EProfile eProfile;

    @Valid
    private SEO seo;

    public EProfileDTO(@Valid EProfile eProfile) {
        this.eProfile = eProfile;
    }
}
