package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChartItems;

import java.util.List;

public abstract class AboutUsOrganizationalChartItemData {
    public static List<AboutUsOrganizationalChartItems> get(){
        AboutUsOrganizationalChartItems aboutUsOrganizationalChartItems1 = new AboutUsOrganizationalChartItems(1L, "/imgs/organizational-page-0001.jpg", 1);
        AboutUsOrganizationalChartItems aboutUsOrganizationalChartItems2 = new AboutUsOrganizationalChartItems(2L, "/imgs/organizational-page-0002.jpg", 2);
        return List.of(aboutUsOrganizationalChartItems1, aboutUsOrganizationalChartItems2);
    }
}
