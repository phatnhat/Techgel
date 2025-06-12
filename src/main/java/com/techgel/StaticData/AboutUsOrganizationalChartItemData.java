package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChartItems;

import java.util.List;

public abstract class AboutUsOrganizationalChartItemData {
    public static List<AboutUsOrganizationalChartItems> get(){
        AboutUsOrganizationalChartItems aboutUsOrganizationalChartItems1 = new AboutUsOrganizationalChartItems(1L, "/imgs/4.1 TECHGEL-SĐTC (20250203)_page-0001.jpg", 1, AboutUsOrganizationalChartItems.OrganizationalLang.vi);
        AboutUsOrganizationalChartItems aboutUsOrganizationalChartItems2 = new AboutUsOrganizationalChartItems(2L, "/imgs/4.1 TECHGEL-SĐTC (20250203)_page-0002.jpg", 2, AboutUsOrganizationalChartItems.OrganizationalLang.vi);
        AboutUsOrganizationalChartItems aboutUsOrganizationalChartItems3 = new AboutUsOrganizationalChartItems(3L, "/imgs/4.1 TECHGEL-SĐTC (20250203)_page-0003.jpg", 2, AboutUsOrganizationalChartItems.OrganizationalLang.vi);

        AboutUsOrganizationalChartItems aboutUsOrganizationalChartItems4 = new AboutUsOrganizationalChartItems(1L, "/imgs/4.2 TECHGEL-ORG CHART (20250203)_page-0001.jpg", 1, AboutUsOrganizationalChartItems.OrganizationalLang.en);
        AboutUsOrganizationalChartItems aboutUsOrganizationalChartItems5 = new AboutUsOrganizationalChartItems(2L, "/imgs/4.2 TECHGEL-ORG CHART (20250203)_page-0002.jpg", 2, AboutUsOrganizationalChartItems.OrganizationalLang.en);
        AboutUsOrganizationalChartItems aboutUsOrganizationalChartItems6 = new AboutUsOrganizationalChartItems(3L, "/imgs/4.2 TECHGEL-ORG CHART (20250203)_page-0003.jpg", 2, AboutUsOrganizationalChartItems.OrganizationalLang.en);

        return List.of(aboutUsOrganizationalChartItems1, aboutUsOrganizationalChartItems2, aboutUsOrganizationalChartItems3, aboutUsOrganizationalChartItems4, aboutUsOrganizationalChartItems5, aboutUsOrganizationalChartItems6);
    }
}
