package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.repository.HomeNavigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeNavigationService {
    @Autowired
    HomeNavigationRepository homeNavigationRepository;

    public List<HomeNavigation> getAll(){
        return homeNavigationRepository.findAll(Sort.by(Sort.Direction.ASC, "displayOrder"));
    }

    public List<HomeNavigation> getParents(){
        return this.getAll().stream().filter(navigation -> navigation.getParent() == null && navigation.isPublished() == true).toList();
    }

    public List<HomeNavigation> getChildrens(){
        return this.getAll().stream().filter(navigation -> navigation.getParent() != null && navigation.isPublished() == true).collect(Collectors.toList());
    }

    public HomeNavigation getById(Long id){
        return homeNavigationRepository.findById(id).get();
    }

    public void update(HomeNavigation homeNavigation){
        homeNavigationRepository.save(homeNavigation);
    }
}
