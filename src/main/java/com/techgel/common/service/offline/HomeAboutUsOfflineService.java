package com.techgel.common.service.offline;

import com.techgel.client.StaticData;
import com.techgel.common.entity.adminSettings.HomeAboutUs;
import com.techgel.common.repository.HomeAboutUsRepository;
import com.techgel.common.service.HomeAboutUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
public class HomeAboutUsOfflineService implements HomeAboutUsService {
    public List<HomeAboutUs> getAll(){
        return StaticData.homeAboutUsData();
    }

    public HomeAboutUs getById(Long id){
        return this.getAll().stream().filter(homeAboutUs -> homeAboutUs.getId().equals(id)).findFirst().orElse(null);
    }

    public HomeAboutUs update(HomeAboutUs homeAboutUs){
        return null;
    }
}
