package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.entity.adminSettings.ProjectList;

import java.util.List;

public interface ProjectListService {
    List<ProjectList> getAll();
    ProjectList getById(Long id);
    List<ProjectList> getAllByProjectCategorySlug(String slug);
    List<ProjectList> getAllByFeaturedIsTrue();
    ProjectList update(ProjectList projectList);
    void deleteById(Long id);
}
