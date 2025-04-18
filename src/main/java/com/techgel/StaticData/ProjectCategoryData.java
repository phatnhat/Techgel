package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.ProjectCategory;

import java.util.List;

public abstract class ProjectCategoryData {
    public static List<ProjectCategory> get(){
        ProjectCategory projectCategory1 = new ProjectCategory(1L, "Năng lượng", "Energy", "energy", 1);
        ProjectCategory projectCategory2 = new ProjectCategory(2L, "Công trình nhà ga", "Aviation", "aviation", 2);
        ProjectCategory projectCategory3 = new ProjectCategory(3L, "Công nghiệp", "Industry", "industry", 3);
        ProjectCategory projectCategory4 = new ProjectCategory(4L, "Dân dụng", "Civil", "civil", 4);
        ProjectCategory projectCategory5 = new ProjectCategory(5L, "Hạ tầng giao thông", "Infrastructure", "infratructure", 5);
        ProjectCategory projectCategory6 = new ProjectCategory(6L, "Công nghệ", "Technology", "technology", 6);

        return List.of(projectCategory1, projectCategory2, projectCategory3, projectCategory4, projectCategory5, projectCategory6);
    }
}
