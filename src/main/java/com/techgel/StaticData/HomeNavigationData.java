package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.entity.enums.NewsType;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public abstract class HomeNavigationData {
    public static List<HomeNavigation> get(){
        HomeNavigation homepage = new HomeNavigation("Trang chủ", "Homepage", true, 1, "/");
        HomeNavigation aboutUs = new HomeNavigation("Về chúng tôi", "About Techgel", true, 1, "/about-us");
        HomeNavigation whatWeDo = new HomeNavigation("Năng lực thi công", "What we do", true, 2, "/what-we-do");
        HomeNavigation projects = new HomeNavigation("Dự án", "Projects", true, 3, "/projects");
        HomeNavigation news = new HomeNavigation("Tin tức", "News", true, 4, "/news");
        HomeNavigation careers = new HomeNavigation("Tuyển dụng", "Careers", true, 6, "/careers");
        HomeNavigation contact = new HomeNavigation("Liên hệ", "Contact us", true, 7, "/contact-us");

        HomeNavigation aboutUs1 = new HomeNavigation("Tầm nhìn, giá trị cốt lõi", "3", true, 1, aboutUs, "/about-us/vision-mission-values", "/imgs/banners/vision-banner.jpg");
        HomeNavigation aboutUs2 = new HomeNavigation("Văn hóa Techgel", "20", true, 2, aboutUs, "/about-us/cultural-techgel", "/imgs/banners/building.jpg");
        HomeNavigation aboutUs3 = new HomeNavigation("Sơ đồ tổ chức", "2", true, 3, aboutUs, "/about-us/organizational-chart", "/imgs/banners/orgchart.jpg");
        HomeNavigation aboutUs4 = new HomeNavigation("Giấy phép & chứng chỉ", "4", true, 4, aboutUs, "/about-us/licenses-certificates", "/imgs/banners/certifications.jpg");
        HomeNavigation aboutUs5 = new HomeNavigation("Đối tác khách hàng", "6", true, 5, aboutUs, "/about-us/clients-partners", "/imgs/banners/handshake.jpg");
        HomeNavigation aboutUs6 = new HomeNavigation("Quan hệ cổ đông", "5", false, 6, aboutUs, "/about-us/shareholder", "/imgs/banners/shareholders.jpg");
        //HomeNavigation aboutUs1 = new HomeNavigation("Tổng quan", "1", false, 1, aboutUs, "/about-us/overview", "/imgs/banners/building.jpg");
        aboutUs.setChildren(Set.of(aboutUs1, aboutUs2, aboutUs3, aboutUs4, aboutUs5, aboutUs6).stream().sorted(Comparator.comparingInt(HomeNavigation::getDisplayOrder)).collect(Collectors.toCollection(LinkedHashSet::new)));

        HomeNavigation whatWeDo1 = new HomeNavigation("Lĩnh vực hoạt động", "6", true, 1, whatWeDo, "/what-we-do/our-business-lines", "/imgs/banners/tech-field.jpg");
        HomeNavigation whatWeDo3 = new HomeNavigation("Phát triển bền vững", "8", true, 3, whatWeDo, "/what-we-do/sustainable-development", "/imgs/banners/growth-sustain.jpg");
        HomeNavigation whatWeDo4 = new HomeNavigation("Hình ảnh thi công", "9", false, 4, whatWeDo, "/what-we-do/gallery", "/imgs/banners/news-banner.jpg");
        whatWeDo.setChildren(Set.of(whatWeDo1, whatWeDo3, whatWeDo4).stream().sorted(Comparator.comparingInt(HomeNavigation::getDisplayOrder)).collect(Collectors.toCollection(LinkedHashSet::new)));

        HomeNavigation projects1 = new HomeNavigation("Năng lượng", "10", true, 1, projects, "/projects/energy", "/imgs/banners/building.jpg");
        HomeNavigation projects2 = new HomeNavigation("Công trình nhà ga", "11", true, 2, projects, "/projects/aviation", "/imgs/banners/building.jpg");
        HomeNavigation projects3 = new HomeNavigation("Công nghiệp", "12", true, 3, projects, "/projects/industry", "/imgs/banners/building.jpg");
        HomeNavigation projects4 = new HomeNavigation("Dân dụng", "13", true, 4, projects, "/projects/civil", "/imgs/banners/building.jpg");
        HomeNavigation projects5 = new HomeNavigation("Hạ tầng giao thông", "14", true, 5, projects, "/projects/infrastructure", "/imgs/banners/building.jpg");
        HomeNavigation projects6 = new HomeNavigation("Công nghệ", "15", true, 6, projects, "/projects/technology", "/imgs/banners/building.jpg");
        projects.setChildren(Set.of(projects1, projects2, projects3, projects4, projects5, projects6).stream().sorted(Comparator.comparingInt(HomeNavigation::getDisplayOrder)).collect(Collectors.toCollection(LinkedHashSet::new)));

        HomeNavigation news1 = new HomeNavigation(NewsType.PROJECT.getVietnameseName(), NewsType.PROJECT.getEnglishName(), true, 1, news, "/news?type=PROJECT", "");
        HomeNavigation news2 = new HomeNavigation(NewsType.INTERNAL.getVietnameseName(), NewsType.INTERNAL.getEnglishName(), true, 2, news, "/news?type=INTERNAL", "");
        HomeNavigation news3 = new HomeNavigation(NewsType.TRAINING.getVietnameseName(), NewsType.TRAINING.getEnglishName(), true, 3, news, "/news?type=TRAINING", "");
        news.setChildren(Set.of(news1, news2, news3).stream().sorted(Comparator.comparingInt(HomeNavigation::getDisplayOrder)).collect(Collectors.toCollection(LinkedHashSet::new)));

        HomeNavigation careers1 = new HomeNavigation("Cơ hội nghề nghiệp", "18", true, 1, careers, "/careers/job-opportunities", "/imgs/banners/building.jpg");
        HomeNavigation careers2 = new HomeNavigation("Chính sách nhân sự", "19", true, 2, careers, "/careers/hr-policies", "/imgs/banners/building.jpg");
        careers.setChildren(Set.of(careers1, careers2).stream().sorted(Comparator.comparingInt(HomeNavigation::getDisplayOrder)).collect(Collectors.toCollection(LinkedHashSet::new)));

        return List.of(homepage, aboutUs, whatWeDo, projects, news, careers, contact);
    }
}
