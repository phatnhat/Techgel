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
        navigations.add("Trang chủ");
        navigations.add("Giới thiệu");
        navigations.add("Dự án");
        navigations.add("Tin tức");
        navigations.add("Tuyển dụng");
        navigations.add("Liên hệ");

        List<List<String>> subnavigations = new ArrayList<>();
        subnavigations.add(new ArrayList<>());
        subnavigations.add(new ArrayList<>(){{
            add("Giới thiệu");
            add("Sơ đồ tổ chức");
            add("Giấy phép và chứng chỉ");
            add("Hồ sơ năng lực");
        }});
        subnavigations.add(new ArrayList<>(){{
            add("Năng lượng");
            add("Công nghệ");
            add("Công nghiệp");
            add("Hạ tầng");
            add("Công trình dân dụng");
        }});
        subnavigations.add(new ArrayList<>(){{
            add("Thông tin nổi bật");
            add("Tin tức hằng ngày");
        }});
        subnavigations.add(new ArrayList<>(){{
            add("Cơ hội nghề nghiệp");
            add("Chính sách nhân sự");
            add("Phát triển nguồn nhân lực");

        }});
        subnavigations.add(new ArrayList<>());

        List<String> banners = new ArrayList<>();
        banners.add("https://www.centralcons.vn/wp-content/uploads/2025/02/TAIPEI-WEB-2-scaled.jpg");
        banners.add("https://www.centralcons.vn/wp-content/uploads/2025/02/Zhongya-Anju-Social-Housing-WWEb-scaled.jpg");
        banners.add("https://www.centralcons.vn/wp-content/uploads/2025/02/SUMO-WEB-2-scaled.jpg");
        banners.add("https://www.centralcons.vn/wp-content/uploads/2025/02/BANGTONG-Web-1-scaled.jpg");

        model.addAttribute("navigations", navigations);
        model.addAttribute("subnavigations", subnavigations);
        model.addAttribute("banners", banners);
        return "clients/index";
    }
}
