package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChart;

import java.util.List;

public abstract class AboutUsOrganizationalChartData {
    public static List<AboutUsOrganizationalChart> get(){
        AboutUsOrganizationalChart aboutUsOrganizationalChart = new AboutUsOrganizationalChart(1L,
                "Sơ đồ tổ chức", "Organizational Chart",
                "TECHGEL", "TECHGEL", "/files/TECHGEL-COMPANY-PROFILE-2025-02.pdf");
        return List.of(aboutUsOrganizationalChart);
    }
}
