package com.techgel.common.service.impl;

import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.entity.adminSettings.ProjectImage;
import com.techgel.common.repository.ProjectImageRepository;
import com.techgel.common.repository.ProjectRepository;
import com.techgel.common.service.ProjectImageService;
import com.techgel.common.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("online")
@RequiredArgsConstructor
public class ProjectImageServiceImpl implements ProjectImageService {
    private final ProjectImageRepository projectImageRepository;

    public List<ProjectImage> getAll(){
        return projectImageRepository.findAll();
    }

    public ProjectImage getById(Long id){
        return projectImageRepository.findById(id).orElse(null);
    }

    public ProjectImage update(ProjectImage projectImage){
        return projectImageRepository.save(projectImage);
    }

    public void deleteById(Long id){
        projectImageRepository.deleteById(id);
    }

}
