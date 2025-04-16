package com.techgel.admin;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.repository.HomeNavigationRepository;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class HomeNavigationRepositoryTests {
    @Autowired
    HomeNavigationRepository homeNavigationRepository;

    @Test
    public void testCreateHomeNavigation(){
        //HomeNavigation home = new HomeNavigation("Trang chủ", "Home", true, 1);
        HomeNavigation aboutUs = new HomeNavigation("Về Techgel", "About Techgel", true, 1, "/about-us");
        HomeNavigation whatWeDo = new HomeNavigation("Năng lực", "What we do", true, 2, "/what-we-do");
        HomeNavigation projects = new HomeNavigation("Dự án", "Projects", true, 3, "/projects");
        HomeNavigation blog = new HomeNavigation("Tin tức", "News", true, 4, "/news");
        HomeNavigation investor = new HomeNavigation("Cổ đông", "Investors", true, 4, "/investor");
        HomeNavigation careers = new HomeNavigation("Tuyển dụng", "Careers", true, 6, "/careers");
        HomeNavigation contact = new HomeNavigation("Liên hệ", "Contact us", true, 7, "/contact-us");

        homeNavigationRepository.saveAll(List.of(aboutUs, whatWeDo, projects, blog, investor, careers, contact));
    }

    @Test
    public void testCreateSubHomeNavigation(){
        HomeNavigation aboutUsParent = homeNavigationRepository.findById(1L).get();
        HomeNavigation aboutUs1 = new HomeNavigation("Tổng quan", "1", true, 1, aboutUsParent, "/about-us/overview");
        HomeNavigation aboutUs2 = new HomeNavigation("Sơ đồ tổ chức", "2", true, 2, aboutUsParent, "/about-us/organizational-chart");
        HomeNavigation aboutUs3 = new HomeNavigation("Tầm nhìn giá trị cốt lõi", "3", true, 3, aboutUsParent, "/about-us/vision-mission-values");
        HomeNavigation aboutUs4 = new HomeNavigation("Giấy phép & chứng chỉ", "4", true, 4, aboutUsParent, "/about-us/licenses-certificates");
        HomeNavigation aboutUs5 = new HomeNavigation("Đối tác khách hàng", "5", true, 5, aboutUsParent, "/about-us/clients-partners");

        HomeNavigation whatWeDoParent = homeNavigationRepository.findById(2L).get();
        HomeNavigation whatWeDo1 = new HomeNavigation("Lĩnh vực hoạt động", "6", true, 1, whatWeDoParent, "/what-we-do/our-business-lines/");
        HomeNavigation whatWeDo2 = new HomeNavigation("Hồ sơ năng lực", "7", true, 2, whatWeDoParent, "/what-we-do/profile/");
        HomeNavigation whatWeDo3 = new HomeNavigation("Phát triển bền vững", "8", true, 3, whatWeDoParent, "/what-we-do/sustainable-development/");
        HomeNavigation whatWeDo4 = new HomeNavigation("Hình ảnh thi công", "9", true, 4, whatWeDoParent, "/what-we-do/gallery/");

        HomeNavigation projectsParent = homeNavigationRepository.findById(3L).get();
        HomeNavigation projects1 = new HomeNavigation("Năng lượng", "10", true, 1, projectsParent, "/projects/energy");
        HomeNavigation projects2 = new HomeNavigation("Công trình hàng không", "11", true, 2, projectsParent, "/projects/aviation");
        HomeNavigation projects3 = new HomeNavigation("Công nghiệp", "12", true, 3, projectsParent, "/projects/industry");
        HomeNavigation projects4 = new HomeNavigation("Dân dụng", "13", true, 4, projectsParent, "/projects/civil");
        HomeNavigation projects5 = new HomeNavigation("Hạ tầng giao thông", "14", true, 5, projectsParent, "/projects/infrastructure");
        HomeNavigation projects6 = new HomeNavigation("Công nghệ", "15", true, 6, projectsParent, "/projects/technology");

//        HomeNavigation blogParent = homeNavigationRepository.findById(4L).get();
//        HomeNavigation blog1 = new HomeNavigation("Tin dự án", "", true, 1,"", blogParent);
//        HomeNavigation blog2 = new HomeNavigation("Hoạt động nội bộ", "", true, 2,"", blogParent);
//        HomeNavigation blog3 = new HomeNavigation("Hoạt động đào tạo", "", true, 3,"", blogParent);

        HomeNavigation investorParent = homeNavigationRepository.findById(5L).get();
        HomeNavigation investor1 = new HomeNavigation("Quan hệ cổ đông", "16", true, 1, investorParent, "/investor/shareholder");
        HomeNavigation investor2 = new HomeNavigation("Thông tin cổ phiếu", "17", true, 2, investorParent, "/investor/stock-info");

        HomeNavigation careersParent = homeNavigationRepository.findById(6L).get();
        HomeNavigation careers1 = new HomeNavigation("Cơ hội nghề nghiệp", "18", true, 1, careersParent, "/careers/job-opportunities");
        HomeNavigation careers2 = new HomeNavigation("Chính sách nhân sự", "19", true, 2, careersParent, "/careers/hr-policies");
        HomeNavigation careers3 = new HomeNavigation("Văn hóa Techgel", "20", true, 3, careersParent, "/careers/cultural-techgel");

        homeNavigationRepository.saveAll(List.of(aboutUs1, aboutUs2, aboutUs3, aboutUs4, aboutUs5,
                whatWeDo1, whatWeDo2, whatWeDo3, whatWeDo4,
                projects1, projects2, projects3, projects4, projects5, projects6,
                investor1, investor2,
                careers1, careers2, careers3));
    }
}
