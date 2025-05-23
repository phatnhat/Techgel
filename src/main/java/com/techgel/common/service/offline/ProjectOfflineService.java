package com.techgel.common.service.offline;

import com.techgel.StaticData.ProjectData;
import com.techgel.common.entity.adminSettings.Project;
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
public class ProjectOfflineService implements ProjectService {

    public List<Project> getAll() {
        return ProjectData.get();
    }

    public Project getById(Long id) {
        return this.getAll().stream()
                .filter(project -> project.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Project not found"));
    }

    public List<Project> getAllByProjectCategorySlug(String slug) {
        return this.getAll().stream().filter(project -> Objects.nonNull(project.getProjectCategory())
                && project.getProjectCategory().getSlug().equals(slug)).collect(Collectors.toList());
    }

    public List<Project> getAllByFeaturedIsTrue() {
        return this.getAll().stream().filter(Project::isFeatured).collect(Collectors.toList());
    }

    public Project update(Project project) {
        return null;
    }

    public void deleteById(Long id) {
    }

}
