package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.ProjectCategory;
import com.techgel.common.repository.ProjectCategoryRepository;
import com.techgel.common.service.ProjectCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class ProjectCategoryServiceImpl implements ProjectCategoryService {
    private final ProjectCategoryRepository projectCategoryRepository;

    public List<ProjectCategory> getAll(){
        return projectCategoryRepository.findAll();
    }

    public ProjectCategory getById(Long id){
        return projectCategoryRepository.findById(id).orElse(null);
    }

    public ProjectCategory update(ProjectCategory projectCategory){
        return projectCategoryRepository.save(projectCategory);
    }

    public void deleteById(Long id){
        projectCategoryRepository.deleteById(id);
    }

}
