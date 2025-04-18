package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.entity.adminSettings.ProjectCategory;
import com.techgel.common.repository.ProjectCategoryRepository;
import com.techgel.common.repository.ProjectRepository;
import com.techgel.common.service.ProjectCategoryService;
import com.techgel.common.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public List<Project> getAll(){
        return projectRepository.findAll();
    }

    public Project getById(Long id){
        return projectRepository.findById(id).orElse(null);
    }

    public Project update(Project project){
        return projectRepository.save(project);
    }

    public void deleteById(Long id){
        projectRepository.deleteById(id);
    }

}
