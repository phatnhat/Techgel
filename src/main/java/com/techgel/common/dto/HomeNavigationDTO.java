package com.techgel.common.dto;

import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.entity.adminSettings.SEO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HomeNavigationDTO {
    private HomeNavigation homeNavigation;
    private SEO seo;

    public HomeNavigationDTO(HomeNavigation homeNavigation) {
        this.homeNavigation = homeNavigation;
    }
}
