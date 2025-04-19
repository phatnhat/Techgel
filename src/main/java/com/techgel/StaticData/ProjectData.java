package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.entity.adminSettings.ProjectCategory;
import com.techgel.common.entity.adminSettings.ProjectImage;
import com.techgel.common.entity.enums.ProjectRegions;

import java.util.List;

public abstract class ProjectData {
    public static List<Project> get() {
        List<ProjectCategory> projectCategories = ProjectCategoryData.get();

        ProjectImage projectImage1 = new ProjectImage(1L, "/imgs/projects/dwight-school-1.jpg");
        ProjectImage projectImage2 = new ProjectImage(2L, "/imgs/projects/dwight-school-1.jpg");
        ProjectImage projectImage3 = new ProjectImage(3L, "/imgs/projects/dwight-school-1.jpg");

        ProjectImage projectImage4 = new ProjectImage(4L, "/imgs/projects/golden-da-lat.webp");
        ProjectImage projectImage5 = new ProjectImage(5L, "/imgs/projects/golden-da-lat.webp");
        ProjectImage projectImage6 = new ProjectImage(6L, "/imgs/projects/golden-da-lat.webp");

        return List.of(
                new Project(1L, "INTERNATIONAL PASSENGER TERMINAL - DANANG AIRPORT", "", "AHT", "", "Thành phố Đà Nẵng",
                        "", "Tổng thầu MEP", "47,000m2", "10/3/2024 ~ 20/4/2025", "10/3/2024 ~ 20/4/2025",
                        "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                        "", "/imgs/projects/Danang_Airport_Overview.jpg", 2025, ProjectRegions.NORTH.name(), true,
                        projectCategories.stream().filter(projectCategory -> projectCategory.getId().equals(2L))
                                .findFirst().orElse(null)),
                new Project(2L, "INTERNATIONAL PASSENGER TERMINAL–CAMRANH AIRPORT (Phase 1A + 1B)", "", "CRTC", "",
                        "Cam Ranh, Khánh Hoà", "", "55,000m2", "", "10/3/2024 ~ 20/4/2025", "10/3/2024 ~ 20/4/2025",
                        "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                        "", "/imgs/projects/cam_ranh.jpeg", 2024, ProjectRegions.FOREIGN_COUNTRY.name(), false,
                        projectCategories.stream().filter(projectCategory -> projectCategory.getId().equals(2L))
                                .findFirst().orElse(null)) {
                    {
                        setProjectImageList(List.of(projectImage1, projectImage2, projectImage3));
                    }
                },
                new Project(3L, "LAE NADZAB INTERNATIONAL TERMINAL AIRPORT", "", "", "",
                        "LAE Capitcal, Papua New Guinea", "", "32,000m2", "", "10/3/2024 ~ 20/4/2025",
                        "10/3/2024 ~ 20/4/2025",
                        "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                        "", "/imgs/projects/lae_nadzab.jpg", 2023, ProjectRegions.SOUTHERN.name(), false,
                        projectCategories.stream().filter(projectCategory -> projectCategory.getId().equals(2L))
                                .findFirst().orElse(null)),

                new Project(5L, "NEXIF POWER WIND FARM", "", "Nexif Energy", "", "Tỉnh Bến Tre", "",
                        "EPC cho đường dây truyền tải 110kV và 35kV", "", "10/3/2024 ~ 20/4/2025",
                        "10/3/2024 ~ 20/4/2025",
                        "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                        "", "/imgs/projects/nexif_power_wind.png", 2024, ProjectRegions.NORTH.name(), true,
                        projectCategories.stream().filter(projectCategory -> projectCategory.getId().equals(1L))
                                .findFirst().orElse(null)) {
                    {
                        setProjectImageList(List.of(projectImage4, projectImage5, projectImage6));
                    }
                },
                new Project(6L, "BANPU VINH CHAU POWER WIND FARM", "", "Banpu Power", "", "Tỉnh Sóc Trăng", "",
                        "EPC đường dây 110kV, ngăn kéo 110kV trạm biến áp Vĩnh Châu", "", "10/3/2024 ~ 20/4/2025",
                        "10/3/2024 ~ 20/4/2025",
                        "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                        "", "/imgs/projects/banpu_vinh_chau.jpg", 2024, ProjectRegions.CENTRAL.name(), false,
                        projectCategories.stream().filter(projectCategory -> projectCategory.getId().equals(1L))
                                .findFirst().orElse(null)),
                new Project(7L, "CU-JUT SOLAR POWER PLANT", "", "EVN CHP", "", "Cư-Jut, Dak-Nong", "", "62 MWp", "",
                        "10/3/2024 ~ 20/4/2025", "10/3/2024 ~ 20/4/2025",
                        "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                        "", "/imgs/projects/cujut.jpg", 2023, ProjectRegions.NORTH.name(), true,
                        projectCategories.stream().filter(projectCategory -> projectCategory.getId().equals(1L))
                                .findFirst().orElse(null)),

                new Project(8L, "TECHTRONIC INDUSTRIES MANUFACTURING (USA)- AES Cu Chi factory", "", "TTI", "",
                        "Thành phố Hồ Chí Minh", "", "70.000 m2", "", "10/3/2024 ~ 20/4/2025", "10/3/2024 ~ 20/4/2025",
                        "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                        "", "/imgs/projects/tti.jpeg", 2022, ProjectRegions.NORTH.name(), true,
                        projectCategories.stream().filter(projectCategory -> projectCategory.getId().equals(3L))
                                .findFirst().orElse(null)),
                new Project(9L, "ONE CVN FACTORY (SCHNEIDER) (LEED PLATINUM Standard)", "", "Schneider Electric", "",
                        "Khu Công nghệ cao Sài Gòn, Quận 9, Thành phố Hồ Chí Minh", "", "M & E and Utility works", "",
                        "10/3/2024 ~ 20/4/2025", "10/3/2024 ~ 20/4/2025",
                        "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                        "", "/imgs/projects/scheiner_electric.jpg", 2024, ProjectRegions.NORTH.name(), true,
                        projectCategories.stream().filter(projectCategory -> projectCategory.getId().equals(3L))
                                .findFirst().orElse(null)),

                new Project(10L, "PALM GARDEN RESORT (5 STAR)", "", "Palm garden resort", "", "Hội An, Tỉnh Quảng Nam",
                        "", "Mechanical & Electrical system", "", "10/3/2024 ~ 20/4/2025", "10/3/2024 ~ 20/4/2025",
                        "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                        "", "/imgs/projects/palm_garden_resort.jpg", 2022, ProjectRegions.CENTRAL.name(), false,
                        projectCategories.stream().filter(projectCategory -> projectCategory.getId().equals(4L))
                                .findFirst().orElse(null)),
                new Project(11L, "MY MY RESORT (NOVABEACH CAM RANH)", "", "Nava Land", "", "Cam Ranh, Khánh Hòa", "",
                        "22.6ha: 182 villas and 26 bungalow, condotel shophouse and 1500 tourist apartments", "",
                        "10/3/2024 ~ 20/4/2025", "10/3/2024 ~ 20/4/2025",
                        "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                        "", "/imgs/projects/NovaBeach-Cam-Ranh-Resort.jpg", 2024, ProjectRegions.NORTH.name(), true,
                        projectCategories.stream().filter(projectCategory -> projectCategory.getId().equals(4L))
                                .findFirst().orElse(null)),
                new Project(12L, "THE EMPIRE LUXURY APARTMENT AND RESORT", "", "Cocobay", "", "Thành phố Đà Nẵng", "",
                        "7 floors; Gross Floor Area: 20,500 m2", "", "10/3/2024 ~ 20/4/2025", "10/3/2024 ~ 20/4/2025",
                        "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                        "", "/imgs/projects/thi-truong-nha-dat-cocobay-da-nang-4.jpg", 2024,
                        ProjectRegions.SOUTHERN.name(), true,
                        projectCategories.stream().filter(projectCategory -> projectCategory.getId().equals(4L))
                                .findFirst().orElse(null)),

                new Project(13L, "DỰ ÁN NHÀ MÁY CẤP NƯỚC AN DƯƠNG, HẢI PHÒNG", "", "", "", "An Dương, Hải Phòng", "",
                        "100,000 m3/ngày", "", "10/3/2024 ~ 20/4/2025", "10/3/2024 ~ 20/4/2025",
                        "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                        "", "/imgs/projects/anduong_haiphong_nha_may_nuoc.jpeg", 2025, ProjectRegions.NORTH.name(),
                        true, projectCategories.stream().filter(projectCategory -> projectCategory.getId().equals(5L))
                                .findFirst().orElse(null)));
    }
}
