package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.entity.adminSettings.ProjectImage;

import java.util.List;

public interface ProjectImageService {
    List<ProjectImage> getAll();
    ProjectImage getById(Long id);
    ProjectImage update(ProjectImage projectImage);
    void deleteById(Long id);
}
