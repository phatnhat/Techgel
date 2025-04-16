package com.techgel.common.service.offline;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.service.HomeNavigationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeNavigationOfflineService implements HomeNavigationService {
    @Override
    public List<HomeNavigation> getAll() {
//        List<Map<String, String>> navigations = new ArrayList<>();
//        navigations.add(new HashMap<>(){{
//            put("Trang chủ", "/");
//        }});
//        navigations.add(new HashMap<>(){{
//            put("Về Techgel", "/about-us/overview");
//        }});
//        navigations.add(new HashMap<>(){{
//            put("Năng lực thi công", "/what-we-do/our-business-lines");
//        }});
//        navigations.add(new HashMap<>(){{
//            put("Dự án", "/projects");
//        }});
//        navigations.add(new HashMap<>(){{
//            put("Tin tức", "/news");
//        }});
//        navigations.add(new HashMap<>(){{
//            put("Tuyển dụng", "/careers/job-opportunities");
//        }});
//        navigations.add(new HashMap<>(){{
//            put("Liên hệ", "/contact-us");
//        }});


        HomeNavigation aboutUs = new HomeNavigation("Về Techgel", "About Techgel", true, 1, "/about-us");
        HomeNavigation whatWeDo = new HomeNavigation("Năng lực thi công", "What we do", true, 2, "/what-we-do");
        HomeNavigation projects = new HomeNavigation("Dự án", "Projects", true, 3, "/projects");
        HomeNavigation blog = new HomeNavigation("Tin tức", "News", true, 4, "/news");
        HomeNavigation careers = new HomeNavigation("Tuyển dụng", "Careers", true, 6, "/careers");
        HomeNavigation contact = new HomeNavigation("Liên hệ", "Contact us", true, 7, "/contact-us");

        HomeNavigation aboutUs1 = new HomeNavigation("Tổng quan", "1", true, 1, aboutUs, "/about-us/overview");
        HomeNavigation aboutUs2 = new HomeNavigation("Sơ đồ tổ chức", "2", true, 2, aboutUs, "/about-us/organizational-chart");
        HomeNavigation aboutUs3 = new HomeNavigation("Tầm nhìn giá trị cốt lõi", "3", true, 3, aboutUs, "/about-us/vision-mission-values");
        HomeNavigation aboutUs4 = new HomeNavigation("Giấy phép & chứng chỉ", "4", true, 4, aboutUs, "/about-us/licenses-certificates");
        HomeNavigation aboutUs5 = new HomeNavigation("Giấy phép & chứng chỉ", "4", true, 4, aboutUs, "/about-us/licenses-certificates");
        HomeNavigation aboutUs6 = new HomeNavigation("Đối tác khách hàng", "5", true, 5, aboutUs, "/about-us/clients-partners");

        HomeNavigation whatWeDo1 = new HomeNavigation("Lĩnh vực hoạt động", "6", true, 1, whatWeDo, "/what-we-do/our-business-lines/");
        HomeNavigation whatWeDo2 = new HomeNavigation("Hồ sơ năng lực", "7", true, 2, whatWeDo, "/what-we-do/profile/");
        HomeNavigation whatWeDo3 = new HomeNavigation("Phát triển bền vững", "8", true, 3, whatWeDo, "/what-we-do/sustainable-development/");
        HomeNavigation whatWeDo4 = new HomeNavigation("Hình ảnh thi công", "9", true, 4, whatWeDo, "/what-we-do/gallery/");

        HomeNavigation projects1 = new HomeNavigation("Năng lượng", "10", true, 1, projects, "/projects/energy");
        HomeNavigation projects2 = new HomeNavigation("Công trình hàng không", "11", true, 2, projects, "/projects/aviation");
        HomeNavigation projects3 = new HomeNavigation("Công nghiệp", "12", true, 3, projects, "/projects/industry");
        HomeNavigation projects4 = new HomeNavigation("Dân dụng", "13", true, 4, projects, "/projects/civil");
        HomeNavigation projects5 = new HomeNavigation("Hạ tầng giao thông", "14", true, 5, projects, "/projects/infrastructure");
        HomeNavigation projects6 = new HomeNavigation("Công nghệ", "15", true, 6, projects, "/projects/technology");

        HomeNavigation careers1 = new HomeNavigation("Cơ hội nghề nghiệp", "18", true, 1, careers, "/careers/job-opportunities");
        HomeNavigation careers2 = new HomeNavigation("Chính sách nhân sự", "19", true, 2, careers, "/careers/hr-policies");
        HomeNavigation careers3 = new HomeNavigation("Văn hóa Techgel", "20", true, 3, careers, "/careers/cultural-techgel");

        return null;
    }

    @Override
    public List<HomeNavigation> getParents() {
        return null;
    }

    @Override
    public List<HomeNavigation> getAllParents() {
        return null;
    }

    @Override
    public HomeNavigation getById(Long id) {
        return null;
    }

    @Override
    public void update(HomeNavigation homeNavigation) {

    }
}
