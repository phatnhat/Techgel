package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.Carousel;
import com.techgel.common.entity.adminSettings.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();
    Project getById(Long id);
    List<Project> getAllByProjectCategorySlug(String slug);
    Project update(Project project);
    void deleteById(Long id);
}
