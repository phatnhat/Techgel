package com.techgel.common.service.offline;

import com.techgel.StaticData.ProjectData;
import com.techgel.StaticData.ProjectListData;
import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.entity.adminSettings.ProjectList;
import com.techgel.common.service.ProjectListService;
import com.techgel.common.service.ProjectService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Profile("offline")
public class ProjectListOfflineService implements ProjectListService {

    public List<ProjectList> getAll() {
        return ProjectListData.get();
    }

    public ProjectList getById(Long id) {
        return this.getAll().stream()
                .filter(project -> project.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Project not found"));
    }

    public List<ProjectList> getAllByProjectCategorySlug(String slug) {
        return this.getAll().stream().filter(project -> Objects.nonNull(project.getProjectCategory())
                && project.getProjectCategory().getSlug().equals(slug)).collect(Collectors.toList());
    }

    public List<ProjectList> getAllByFeaturedIsTrue() {
        return this.getAll().stream().filter(ProjectList::isFeatured).collect(Collectors.toList());
    }

    public ProjectList update(ProjectList projectList) {
        return null;
    }

    public void deleteById(Long id) {
    }

}
