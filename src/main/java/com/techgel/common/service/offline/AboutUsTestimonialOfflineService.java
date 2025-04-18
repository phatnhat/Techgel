package com.techgel.common.service.offline;

import com.techgel.client.StaticData;
import com.techgel.common.entity.adminSettings.AboutUsTestimonial;
import com.techgel.common.repository.AboutUsTestimonialRepository;
import com.techgel.common.service.AboutUsTestimonialService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
public class AboutUsTestimonialOfflineService implements AboutUsTestimonialService {
    public List<AboutUsTestimonial> getAll(){
        return StaticData.aboutUsTestimonialData();
    }

    public AboutUsTestimonial getById(Long id){
        return this.getAll().stream().filter(aboutUsTestimonial -> aboutUsTestimonial.getId().equals(id)).findFirst().orElse(null);
    }

    public AboutUsTestimonial update(AboutUsTestimonial aboutUsTestimonial){
        return null;
    }
}
