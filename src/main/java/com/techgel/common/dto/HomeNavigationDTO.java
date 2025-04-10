package com.techgel.common.dto;

import com.techgel.common.entity.adminSettings.HomeNavigation;
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
public class HomeNavigationDTO {
    @Valid
    private HomeNavigation homeNavigation;

    @Valid
    private SEO seo;

    public HomeNavigationDTO(@Valid HomeNavigation homeNavigation) {
        this.homeNavigation = homeNavigation;
    }
}
