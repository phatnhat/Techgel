package com.techgel.admin;

import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.entity.adminSettings.SEO;
import com.techgel.common.repository.HomeNavigationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class HomeNavigationRepositoryTests {
    @Autowired
    HomeNavigationRepository homeNavigationRepository;

    @Test
    public void testCreateHomeNavigation(){
        //HomeNavigation home = new HomeNavigation("Trang chủ", "Home", true, 1);
        HomeNavigation aboutUs = new HomeNavigation("Về Techgel", "About Techgel", true, new SEO(), 1);
        HomeNavigation whatWeDo = new HomeNavigation("Năng lực thi công", "What we do", true, new SEO(), 2);
        HomeNavigation projects = new HomeNavigation("Dự án", "Projects", true, new SEO(), 3);
        HomeNavigation blog = new HomeNavigation("Tin tức", "News", true, new SEO(), 4);
        HomeNavigation investor = new HomeNavigation("Cổ đông", "Investors", true, new SEO(), 4);
        HomeNavigation careers = new HomeNavigation("Tuyển dụng", "Careers", true, new SEO(), 6);
        HomeNavigation contact = new HomeNavigation("Liên hệ", "Contact us", true, new SEO(), 7);

        homeNavigationRepository.saveAll(List.of(aboutUs, whatWeDo, projects, blog, investor, careers, contact));
    }

    @Test
    public void testCreateSubHomeNavigation(){
        HomeNavigation aboutUsParent = homeNavigationRepository.findById(1L).get();
        HomeNavigation aboutUs1 = new HomeNavigation("Tổng quan", "", true, 1, new SEO(), aboutUsParent);
        HomeNavigation aboutUs2 = new HomeNavigation("Sơ đồ tổ chức", "", true, 2, new SEO(), aboutUsParent);
        HomeNavigation aboutUs3 = new HomeNavigation("Tầm nhìn giá trị cốt lõi", "", true, 3, new SEO(), aboutUsParent);
        HomeNavigation aboutUs4 = new HomeNavigation("Giấy phép & chứng chỉ", "", true, 4, new SEO(), aboutUsParent);
        HomeNavigation aboutUs5 = new HomeNavigation("Đối tác khách hàng", "", true, 5, new SEO(), aboutUsParent);

        HomeNavigation whatWeDoParent = homeNavigationRepository.findById(2L).get();
        HomeNavigation whatWeDo1 = new HomeNavigation("Lĩnh vực hoạt động", "", true, 1, new SEO(), whatWeDoParent);
        HomeNavigation whatWeDo2 = new HomeNavigation("Hồ sơ năng lực", "", true, 2,new SEO(), whatWeDoParent);
        HomeNavigation whatWeDo3 = new HomeNavigation("Phát triển bề vững", "", true, 3,new SEO(), whatWeDoParent);
        HomeNavigation whatWeDo4 = new HomeNavigation("Hình ảnh thi công", "", true, 4,new SEO(), whatWeDoParent);

        HomeNavigation projectsParent = homeNavigationRepository.findById(3L).get();
        HomeNavigation projects1 = new HomeNavigation("Năng lượng", "", true, 1,new SEO(), projectsParent);
        HomeNavigation projects2 = new HomeNavigation("Công trình hàng không", "", true, 2,new SEO(), projectsParent);
        HomeNavigation projects3 = new HomeNavigation("Công nghiệp", "", true, 3,new SEO(), projectsParent);
        HomeNavigation projects4 = new HomeNavigation("Dân dụng", "", true, 4,new SEO(), projectsParent);
        HomeNavigation projects5 = new HomeNavigation("Hạ tầng giao thông", "", true, 5,new SEO(), projectsParent);
        HomeNavigation projects6 = new HomeNavigation("Công nghệ", "", true, 6,new SEO(), projectsParent);

//        HomeNavigation blogParent = homeNavigationRepository.findById(4L).get();
//        HomeNavigation blog1 = new HomeNavigation("Tin dự án", "", true, 1,"", blogParent);
//        HomeNavigation blog2 = new HomeNavigation("Hoạt động nội bộ", "", true, 2,"", blogParent);
//        HomeNavigation blog3 = new HomeNavigation("Hoạt động đào tạo", "", true, 3,"", blogParent);

        HomeNavigation investorParent = homeNavigationRepository.findById(5L).get();
        HomeNavigation investor1 = new HomeNavigation("Quan hệ cổ đông", "", true, 1,new SEO(), investorParent);
        HomeNavigation investor2 = new HomeNavigation("Thông tin cổ phiếu", "", true, 2,new SEO(), investorParent);

        HomeNavigation careersParent = homeNavigationRepository.findById(6L).get();
        HomeNavigation careers1 = new HomeNavigation("Cơ hội nghề nghiệp", "", true, 1,new SEO(), careersParent);
        HomeNavigation careers2 = new HomeNavigation("Chính sách nhân sự", "", true, 2,new SEO(), careersParent);
        HomeNavigation careers3 = new HomeNavigation("Văn hóa Techgel", "", true, 3,new SEO(), careersParent);

        homeNavigationRepository.saveAll(List.of(aboutUs1, aboutUs2, aboutUs3, aboutUs4, aboutUs5,
                whatWeDo1, whatWeDo2, whatWeDo3, whatWeDo4,
                projects1, projects2, projects3, projects4, projects5, projects6,
                investor1, investor2,
                careers1, careers2, careers3));
    }
}
