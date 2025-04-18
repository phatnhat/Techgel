package com.techgel.common.repository;

import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.entity.adminSettings.ProjectCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
