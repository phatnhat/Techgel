package com.techgel.common.service.offline;

import com.techgel.client.StaticData;
import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.entity.adminSettings.ProjectImage;
import com.techgel.common.service.ProjectImageService;
import com.techgel.common.service.ProjectService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
public class ProjectImageOfflineService implements ProjectImageService {

    public List<ProjectImage> getAll(){
        return StaticData.projectImageData();
    }

    public ProjectImage getById(Long id){
        return this.getAll().stream().filter(project -> project.getId().equals(id)).findFirst().orElse(null);
    }

    public ProjectImage update(ProjectImage projectImage){
        return null;
    }

    public void deleteById(Long id){}

}
