package com.techgel.common.service.offline;

import com.techgel.StaticData.AboutUsOrganizationalChartItemData;
import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChartItems;
import com.techgel.common.service.AboutUsOrganizationalChartItemsService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
public class AboutUsOrganizationalChartItemsOfflineService implements AboutUsOrganizationalChartItemsService {
    public List<AboutUsOrganizationalChartItems> getAll(){
        return AboutUsOrganizationalChartItemData.get();
    }

    public AboutUsOrganizationalChartItems getById(Long id){
        return this.getAll().stream().filter(aboutUsOrganizationalChartItems -> aboutUsOrganizationalChartItems.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteById(Long id){

    }

    public AboutUsOrganizationalChartItems update(AboutUsOrganizationalChartItems aboutUsTestimonialItems){
        return null;
    }
}
