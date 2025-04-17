package com.techgel.common.service.offline;

import com.techgel.client.StaticData;
import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.service.HomeNavigationService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("offline")
public class HomeNavigationOfflineService implements HomeNavigationService {
    @Override
    public List<HomeNavigation> getAll() {
        return StaticData.homeNavigationData();
    }

    @Override
    public List<HomeNavigation> getParents() {
        return this.getAll().stream().filter(navigation -> navigation.getParent() == null && navigation.isPublished() == true).toList();
    }

    @Override
    public List<HomeNavigation> getAllParents(){
        return this.getAll().stream().filter(navigation -> navigation.getParent() == null).toList();
    }

    @Override
    public HomeNavigation getById(Long id){
        return this.getAll().stream().filter(navigation -> Objects.equals(navigation.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public void update(HomeNavigation homeNavigation) {}
}
