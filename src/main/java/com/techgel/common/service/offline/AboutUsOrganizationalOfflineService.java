package com.techgel.common.service.offline;

import com.techgel.StaticData.AboutUsOrganizationalChartData;
import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChart;
import com.techgel.common.service.AboutUsOrganizationalService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class AboutUsOrganizationalOfflineService implements AboutUsOrganizationalService {
    public List<AboutUsOrganizationalChart> getAll(){
        return AboutUsOrganizationalChartData.get();
    }

    public AboutUsOrganizationalChart getById(Long id){
        return this.getAll().stream().filter(aboutUsOrganizationalChart -> aboutUsOrganizationalChart.getId().equals(id)).findFirst().orElse(null);
    }

    public AboutUsOrganizationalChart update(AboutUsOrganizationalChart aboutUsOrganizationalChart){
        return null;
    }
}
