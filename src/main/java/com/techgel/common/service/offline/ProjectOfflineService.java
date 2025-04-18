package com.techgel.common.service.offline;

import com.techgel.client.StaticData;
import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.repository.ProjectRepository;
import com.techgel.common.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
public class ProjectOfflineService implements ProjectService {

    public List<Project> getAll(){
        return StaticData.projectData();
    }

    public Project getById(Long id){
        return this.getAll().stream().filter(project -> project.getId().equals(id)).findFirst().orElse(null);
    }

    public Project update(Project project){
        return null;
    }

    public void deleteById(Long id){}

}
