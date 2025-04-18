package com.techgel.common.service.offline;

import com.techgel.client.StaticData;
import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.entity.adminSettings.ProjectCategory;
import com.techgel.common.service.ProjectCategoryService;
import com.techgel.common.service.ProjectService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
public class ProjectCategoryOfflineService implements ProjectCategoryService {

    public List<ProjectCategory> getAll(){
        return StaticData.projectCategoryData();
    }

    public ProjectCategory getById(Long id){
        return this.getAll().stream().filter(projectCategory -> projectCategory.getId().equals(id)).findFirst().orElse(null);
    }

    public ProjectCategory update(ProjectCategory projectCategory){
        return null;
    }

    public void deleteById(Long id){}

}
