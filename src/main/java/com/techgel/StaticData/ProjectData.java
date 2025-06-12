package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.entity.adminSettings.ProjectCategory;
import com.techgel.common.entity.adminSettings.ProjectImage;
import com.techgel.common.entity.enums.ProjectRegions;

import java.util.List;

public abstract class ProjectData {
        public static List<Project> get() {
                return List.of(
                        new Project(1L, "Dự án", "Projects", "/imgs/banners/project-banner.webp")
                );
        }
}
