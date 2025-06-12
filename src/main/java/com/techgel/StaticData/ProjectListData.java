package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.Project;
import com.techgel.common.entity.adminSettings.ProjectCategory;
import com.techgel.common.entity.adminSettings.ProjectImage;
import com.techgel.common.entity.adminSettings.ProjectList;
import com.techgel.common.entity.enums.ProjectRegions;

import java.util.List;

public abstract class ProjectListData {
        public static List<ProjectList> get() {
                List<ProjectCategory> projectCategories = ProjectCategoryData.get();

                ProjectImage projectImage1 = new ProjectImage(1L, "/imgs/projects/dwight-school-1.jpg");
                ProjectImage projectImage2 = new ProjectImage(2L, "/imgs/projects/dwight-school-1.jpg");
                ProjectImage projectImage3 = new ProjectImage(3L, "/imgs/projects/dwight-school-1.jpg");

                ProjectImage projectImage4 = new ProjectImage(4L, "/imgs/projects/golden-da-lat.webp");
                ProjectImage projectImage5 = new ProjectImage(5L, "/imgs/projects/golden-da-lat.webp");
                ProjectImage projectImage6 = new ProjectImage(6L, "/imgs/projects/golden-da-lat.webp");

                return List.of(
                                new ProjectList(1L, "Nhà ga hành khách quốc tế - Sân bay Đà Nẵng",
                                                "International passenger terminal - Da Nang airport", "AHT",
                                                "AHT", "Thành phố Đà Nẵng",
                                                "Da Nang city",
                                                "Tổng thầu MEP", "47,000m2",
                                                "10/3/2024 ~ 20/4/2025",
                                                "10/3/2024 ~ 20/4/2025",
                                                "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                                                "A model urban mega-city—civilized, modern, and diverse in housing, commercial, and service offerings—is being developed to become a \"dream eco-urban area\" with many distinctive architectural highlights. The project promises to be an ideal place to live for residents and one of the most attractive entertainment and leisure destinations in the capital.",
                                                "/imgs/projects/Danang_Airport_Overview.jpg", 2025,
                                                ProjectRegions.NORTH.name(), true,
                                                projectCategories.stream().filter(
                                                                projectCategory -> projectCategory.getId().equals(2L))
                                                                .findFirst().orElse(null)),
                                new ProjectList(2L, "Nhà ga hành khách quốc tế - Sân bay Cam Ranh (Giai đoạn 1A + 1B)", "International passenger terminal - Cam Ranh airport (Phase 1A + 1B)",
                                                "CRTC", "CRTC",
                                                "Cam Ranh, Khánh Hoà", "Cam Ranh, Khanh Hoa", "55,000m2", "55,000m2", "10/3/2024 ~ 20/4/2025",
                                                "10/3/2024 ~ 20/4/2025",
                                                "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                                                "A model urban mega-city—civilized, modern, and diverse in housing, commercial, and service offerings—is being developed to become a \"dream eco-urban area\" with many distinctive architectural highlights. The project promises to be an ideal place to live for residents and one of the most attractive entertainment and leisure destinations in the capital.", "/imgs/projects/cam_ranh.jpeg", 2024,
                                                ProjectRegions.FOREIGN_COUNTRY.name(), false,
                                                projectCategories.stream().filter(
                                                                projectCategory -> projectCategory.getId().equals(2L))
                                                                .findFirst().orElse(null)) {
                                        {
                                                setProjectImageList(
                                                                List.of(projectImage1, projectImage2, projectImage3));
                                        }
                                },
                                new ProjectList(3L, "Sân bay quốc tế Lae Nadzab", "Lae Nadzab International terminal airport", "", "",
                                                "Thủ đô LAE, Papua New Guinea", "LAE Capitcal, Papua New Guinea", "32,000m2", "32,000m2",
                                                "10/3/2024 ~ 20/4/2025",
                                                "10/3/2024 ~ 20/4/2025",
                                                "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                                                "A model urban mega-city—civilized, modern, and diverse in housing, commercial, and service offerings—is being developed to become a \"dream eco-urban area\" with many distinctive architectural highlights. The project promises to be an ideal place to live for residents and one of the most attractive entertainment and leisure destinations in the capital.", "/imgs/projects/lae_nadzab.jpg", 2023,
                                                ProjectRegions.SOUTHERN.name(), false,
                                                projectCategories.stream().filter(
                                                                projectCategory -> projectCategory.getId().equals(2L))
                                                                .findFirst().orElse(null)),

                                new ProjectList(5L, "Trang trại điện gió NEXIF", "Nexif power wind farm", "Nexif Energy", "Nexif Energy",
                                                "Tỉnh Bến Tre", "Ben Tre Province",
                                                "EPC cho đường dây truyền tải 110kV và 35kV", "EPC for 110kV and 35kV transmission lines",
                                                "10/3/2024 ~ 20/4/2025",
                                                "10/3/2024 ~ 20/4/2025",
                                                "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                                                "A model urban mega-city—civilized, modern, and diverse in housing, commercial, and service offerings—is being developed to become a \"dream eco-urban area\" with many distinctive architectural highlights. The project promises to be an ideal place to live for residents and one of the most attractive entertainment and leisure destinations in the capital.", "/imgs/projects/nexif_power_wind.png", 2024,
                                                ProjectRegions.NORTH.name(), true,
                                                projectCategories.stream().filter(
                                                                projectCategory -> projectCategory.getId().equals(1L))
                                                                .findFirst().orElse(null)) {
                                        {
                                                setProjectImageList(
                                                                List.of(projectImage4, projectImage5, projectImage6));
                                        }
                                },
                                new ProjectList(6L, "Nhà máy điện gió Banpu Vĩnh Châu", "Banpu Vinh Chau power wind farm",
                                                "Banpu Power", "Banpu Power",
                                                "Tỉnh Sóc Trăng", "Soc Trang Province",
                                                "EPC đường dây 110kV, ngăn kéo 110kV trạm biến áp Vĩnh Châu", "EPC 110kV line, 110kV expansion of Vinh Chau transformer station\n",
                                                "10/3/2024 ~ 20/4/2025",
                                                "10/3/2024 ~ 20/4/2025",
                                                "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                                                "A model urban mega-city—civilized, modern, and diverse in housing, commercial, and service offerings—is being developed to become a \"dream eco-urban area\" with many distinctive architectural highlights. The project promises to be an ideal place to live for residents and one of the most attractive entertainment and leisure destinations in the capital.", "/imgs/projects/banpu_vinh_chau.jpg", 2024,
                                                ProjectRegions.CENTRAL.name(), false,
                                                projectCategories.stream().filter(
                                                                projectCategory -> projectCategory.getId().equals(1L))
                                                                .findFirst().orElse(null)),
                                new ProjectList(7L, "Nhà máy điện mặt trời Cu-Jut", "Cu-Jut solar power plant", "EVN CHP", "EVN CHP",
                                                "Cư-Jut, Dak-Nong", "Cu-Jut, Dak-Nong",
                                                "62 MWp", "62 MWp",
                                                "10/3/2024 ~ 20/4/2025", "10/3/2024 ~ 20/4/2025",
                                                "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                                                "A model urban mega-city—civilized, modern, and diverse in housing, commercial, and service offerings—is being developed to become a \"dream eco-urban area\" with many distinctive architectural highlights. The project promises to be an ideal place to live for residents and one of the most attractive entertainment and leisure destinations in the capital.", "/imgs/projects/cujut.jpg", 2023, ProjectRegions.NORTH.name(), true,
                                                projectCategories.stream().filter(
                                                                projectCategory -> projectCategory.getId().equals(1L))
                                                                .findFirst().orElse(null)),

                                new ProjectList(8L, "Công ty sản xuất công nghiệp Techtronic (USA) - Nhà máy AES Củ Chi",
                                                "TECHTRONIC INDUSTRIES MANUFACTURING (USA)- AES Cu Chi factory",
                                                "TTI", "TTI",
                                                "Thành phố Hồ Chí Minh", "Ho Chi Minh city", "70.000 m2", "70.000 m2", "10/3/2024 ~ 20/4/2025",
                                                "10/3/2024 ~ 20/4/2025",
                                                "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                                                "A model urban mega-city—civilized, modern, and diverse in housing, commercial, and service offerings—is being developed to become a \"dream eco-urban area\" with many distinctive architectural highlights. The project promises to be an ideal place to live for residents and one of the most attractive entertainment and leisure destinations in the capital.", "/imgs/projects/tti.jpeg", 2022, ProjectRegions.NORTH.name(), true,
                                                projectCategories.stream().filter(
                                                                projectCategory -> projectCategory.getId().equals(3L))
                                                                .findFirst().orElse(null)),
                                new ProjectList(9L, "Nhà máy one cvn (Schneider) (Tiêu chuẩn Leed Platium)", "ONE CVN FACTORY (SCHNEIDER) (LEED PLATINUM Standard)",
                                                "Schneider Electric", "Schneider Electric",
                                                "Khu Công nghệ cao Sài Gòn, Quận 9, Thành phố Hồ Chí Minh", "Saigon Hi-Tech Park, District 9, Ho Chi Minh City\n",
                                                "M & E and Utility works", "Công trình M&E và Tiện ích",
                                                "10/3/2024 ~ 20/4/2025", "10/3/2024 ~ 20/4/2025",
                                                "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                                                "A model urban mega-city—civilized, modern, and diverse in housing, commercial, and service offerings—is being developed to become a \"dream eco-urban area\" with many distinctive architectural highlights. The project promises to be an ideal place to live for residents and one of the most attractive entertainment and leisure destinations in the capital.", "/imgs/projects/scheiner_electric.jpg", 2024,
                                                ProjectRegions.NORTH.name(), true,
                                                projectCategories.stream().filter(
                                                                projectCategory -> projectCategory.getId().equals(3L))
                                                                .findFirst().orElse(null)),

                                new ProjectList(10L, "Khu nghỉ dưỡng Palm Garden (5 sao)", "Palm garden resort (5 star)",
                                                "Khu nghỉ dưỡng Palm garden", "Palm garden resort",
                                                "Hội An, Tỉnh Quảng Nam",
                                                "Hoi An, Quang Nam Province",
                                                "Hệ thống Cơ & Điện", "Mechanical & Electrical systems", "10/3/2024 ~ 20/4/2025",
                                                "10/3/2024 ~ 20/4/2025",
                                                "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                                                "A model urban mega-city—civilized, modern, and diverse in housing, commercial, and service offerings—is being developed to become a \"dream eco-urban area\" with many distinctive architectural highlights. The project promises to be an ideal place to live for residents and one of the most attractive entertainment and leisure destinations in the capital.", "/imgs/projects/palm_garden_resort.jpg", 2022,
                                                ProjectRegions.CENTRAL.name(), false,
                                                projectCategories.stream().filter(
                                                                projectCategory -> projectCategory.getId().equals(4L))
                                                                .findFirst().orElse(null)),
                                new ProjectList(11L, "Khu nghỉ dưỡng My My (Novabeach Cam Ranh)", "My My resort (Novabeach Cam Ranh)",
                                                "Nava Land", "Nava Land",
                                                "Cam Ranh, Khánh Hòa", "Cam Ranh, Khanh Hoa",
                                                "22,6ha: 182 căn biệt thự và 26 bungalow, condotel shophouse và 1500 căn hộ du lịch",
                                                "22.6ha: 182 villas and 26 bungalow, condotel shophouse and 1500 tourist apartments",
                                                "10/3/2024 ~ 20/4/2025", "10/3/2024 ~ 20/4/2025",
                                                "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                                                "A model urban mega-city—civilized, modern, and diverse in housing, commercial, and service offerings—is being developed to become a \"dream eco-urban area\" with many distinctive architectural highlights. The project promises to be an ideal place to live for residents and one of the most attractive entertainment and leisure destinations in the capital.", "/imgs/projects/NovaBeach-Cam-Ranh-Resort.jpg", 2024,
                                                ProjectRegions.NORTH.name(), true,
                                                projectCategories.stream().filter(
                                                                projectCategory -> projectCategory.getId().equals(4L))
                                                                .findFirst().orElse(null)),
                                new ProjectList(12L, "Căn hộ và khu nghỉ dưỡng cao cấp Empire", "The empire luxury apartment and resort",
                                                "Cocobay", "Cocobay",
                                                "Thành phố Đà Nẵng", "Da Nang city",
                                                "7 tầng; Tổng diện tích sàn: 20.500 m2", "7 floors; Gross Floor Area: 20,500 m2", "10/3/2024 ~ 20/4/2025",
                                                "10/3/2024 ~ 20/4/2025",
                                                "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                                                "A model urban mega-city—civilized, modern, and diverse in housing, commercial, and service offerings—is being developed to become a \"dream eco-urban area\" with many distinctive architectural highlights. The project promises to be an ideal place to live for residents and one of the most attractive entertainment and leisure destinations in the capital.", "/imgs/projects/thi-truong-nha-dat-cocobay-da-nang-4.jpg", 2024,
                                                ProjectRegions.SOUTHERN.name(), true,
                                                projectCategories.stream().filter(
                                                                projectCategory -> projectCategory.getId().equals(4L))
                                                                .findFirst().orElse(null)),
                                new ProjectList(
                                                14L,
                                                "Cảng hàng không Vân Đồn, Quảng Ninh",
                                                "Van Don airport, Quang Ninh",
                                                "",
                                                "",
                                                "Quảng Ninh",
                                                "Quang Ninh",
                                                "MEP và đường ống thoát nước",
                                                "MEP and plumbing",
                                                "04/2017 - 10/2017",
                                                "04/2017 - 10/2017",
                                                "Dự án Cảng hàng không Vân Đồn là một trong những công trình trọng điểm tại khu vực phía Bắc, đóng vai trò quan trọng trong việc kết nối giao thương và phát triển kinh tế – xã hội. Hạng mục MEP và hệ thống thoát nước được triển khai đồng bộ, hiện đại, góp phần nâng cao hiệu suất vận hành và đảm bảo tiêu chuẩn kỹ thuật cao cho hạ tầng sân bay.",
                                                "A model urban mega-city—civilized, modern, and diverse in housing, commercial, and service offerings—is being developed to become a \"dream eco-urban area\" with many distinctive architectural highlights. The project promises to be an ideal place to live for residents and one of the most attractive entertainment and leisure destinations in the capital.",
                                                "/imgs/projects/hang-khong-van-don/hkvd-1.jpg",
                                                2017,
                                                ProjectRegions.NORTH.name(),
                                                true,
                                                projectCategories.stream()
                                                                .filter(projectCategory -> projectCategory.getId()
                                                                                .equals(2L))
                                                                .findFirst()
                                                                .orElse(null)),

                                new ProjectList(13L, "Dự án nhà máy cấp nước An Dương, Hải Phòng", "An Duong water supply plant project, Hai Phong",
                                                "Ủy ban Nhân Dân TP. Hải Phòng", "People's Committee of Hai Phong City",
                                                "An Dương, Hải Phòng", "An Duong, Hai Phong",
                                                "100,000 m3/ngày", "100,000 m3/day", "10/3/2024 ~ 20/4/2025", "10/3/2024 ~ 20/4/2025",
                                                "Đại đô thị kiểu mẫu, văn minh, hiện đại; đa dạng về sản phẩm nhà ở, thương mại, dịch vụ được kiến tạo để trở thành một “Khu đô thị sinh thái trong mơ” với nhiều điểm nhấn trong thiết kế. Hứa hẹn, Dự Án sẽ trở thành nơi an cư lý tưởng dành cho người dân và điểm đến vui chơi – giải trí hấp dẫn bậc nhất Thủ đô.",
                                                "A model urban mega-city—civilized, modern, and diverse in housing, commercial, and service offerings—is being developed to become a \"dream eco-urban area\" with many distinctive architectural highlights. The project promises to be an ideal place to live for residents and one of the most attractive entertainment and leisure destinations in the capital.", "/imgs/projects/anduong_haiphong_nha_may_nuoc.jpeg", 2025,
                                                ProjectRegions.NORTH.name(),
                                                true,
                                                projectCategories.stream().filter(
                                                                projectCategory -> projectCategory.getId().equals(5L))
                                                                .findFirst().orElse(null)));
        }
}
