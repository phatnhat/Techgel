package com.techgel.common.service.offline;

import com.techgel.StaticData.AboutUsTestimonialItemData;
import com.techgel.common.entity.adminSettings.AboutUsTestimonialItems;
import com.techgel.common.service.AboutUsTestimonialItemsService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
public class AboutUsTestimonialItemsOfflineService implements AboutUsTestimonialItemsService {

    public List<AboutUsTestimonialItems> getAll(){
        return AboutUsTestimonialItemData.get();
    }

    public AboutUsTestimonialItems getById(Long id){
        return this.getAll().stream().filter(aboutUsTestimonialItems -> aboutUsTestimonialItems.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteById(Long id){}

    public AboutUsTestimonialItems update(AboutUsTestimonialItems aboutUsTestimonialItems){
        return null;
    }
}
