package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.Carousel;
import com.techgel.common.entity.adminSettings.ProjectCategory;

import java.util.List;

public interface ProjectCategoryService {
    List<ProjectCategory> getAll();
    ProjectCategory getById(Long id);
    ProjectCategory update(ProjectCategory projectCategory);
    void deleteById(Long id);
}
