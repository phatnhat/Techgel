package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.entity.adminSettings.ProjectCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByProjectCategorySlug(String slug);
}
