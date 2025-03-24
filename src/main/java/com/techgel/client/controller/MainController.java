package com.techgel.client.controller;

import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.service.HomeNavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("")
    public String viewHomagePage(Model model){
        List<String> navigations = new ArrayList<>();
        navigations.add("Về Techgel");
        navigations.add("Năng lực thi công");
        navigations.add("Dự án");
        navigations.add("Tin tức");
        navigations.add("Cổ đông");
        navigations.add("Tuyển dụng");
        navigations.add("Liên hệ");

        List<List<String>> subnavigations = new ArrayList<>();
        subnavigations.add(new ArrayList<>(){{
            add("Tổng quan");
            add("Sơ đồ tổ chức");
            add("Tầm nhìn giá trị cốt lõi");
            add("Giấy phép & chứng chỉ");
            add("Đối tác khách hàng");
        }});
        subnavigations.add(new ArrayList<>(){{
            add("Lĩnh vực hoạt động");
            add("Hồ sơ năng lực");
            add("Phát triển bề vững");
            add("Hình ảnh thi công");
        }});
        subnavigations.add(new ArrayList<>(){{
            add("Năng lượng");
            add("Hàng không");
            add("Công nghiệp");
            add("Hạ tầng giao thông");
            add("Dân dụng");
            add("Công nghệ");
        }});
        subnavigations.add(new ArrayList<>(){{
            add("Tin dự án");
            add("Hoạt động nội bộ");
            add("Hoạt động đào tạo");
        }});
        subnavigations.add(new ArrayList<>(){{
            add("Đại hội cổ đông");
            add("Các báo cáo");
            add("Công bố thông tin");
            add("Thông tin cổ phiếu");
        }});
        subnavigations.add(new ArrayList<>(){{
            add("Cơ hội nghề nghiệp");
            add("Chính sách nhân sự");
            add("Phát triển nguồn nhân lực");
            add("Văn hóa Techgel");
        }});
        subnavigations.add(new ArrayList<>());

        List<String> banners = new ArrayList<>();
//        banners.add("https://www.centralcons.vn/wp-content/uploads/2025/02/TAIPEI-WEB-2-scaled.jpg");
//        banners.add("https://www.centralcons.vn/wp-content/uploads/2025/02/Zhongya-Anju-Social-Housing-WWEb-scaled.jpg");
//        banners.add("https://www.centralcons.vn/wp-content/uploads/2025/02/SUMO-WEB-2-scaled.jpg");
//        banners.add("https://www.centralcons.vn/wp-content/uploads/2025/02/BANGTONG-Web-1-scaled.jpg");

        banners.add("/imgs/46736717-3837-4318-8fa9-c3e0fed82c68.jfif");
        banners.add("/imgs/b29dced9-353e-4031-bb40-d5e1e45753f6.jfif");
        banners.add("/imgs/068a850f-79c2-493a-b394-54fff1eb5eb4.jfif");
        banners.add("/imgs/carosel-04.jpg");

        model.addAttribute("testNavigations", navigations);
        model.addAttribute("subnavigations", subnavigations);
        model.addAttribute("banners", banners);
        return "clients/index";
    }

    @GetMapping("/brochure")
    public String viewBrochure(){
        return "/clients/brochure";
    }
}
