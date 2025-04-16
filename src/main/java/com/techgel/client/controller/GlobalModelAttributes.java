package com.techgel.client.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributes {
    @ModelAttribute
    public void addCommonAttributes(Model model) {
        List<Map<String, String>> navigations = new ArrayList<>();
        navigations.add(new HashMap<>(){{
            put("Trang chủ", "/");
        }});
        navigations.add(new HashMap<>(){{
            put("Về Techgel", "/about-us/overview");
        }});
        navigations.add(new HashMap<>(){{
            put("Năng lực", "/what-we-do/our-business-lines");
        }});
        navigations.add(new HashMap<>(){{
            put("Dự án", "/projects");
        }});
        navigations.add(new HashMap<>(){{
            put("Tin tức", "/news");
        }});
        navigations.add(new HashMap<>(){{
            put("Tuyển dụng", "/careers/job-opportunities");
        }});
        navigations.add(new HashMap<>(){{
            put("Liên hệ", "/contact-us");
        }});



        List<List<Map<String, String>>> test = new ArrayList<List<Map<String, String>>>();
        test.add(new ArrayList<>());
        test.add(new ArrayList<>(){{
            add(new LinkedHashMap<>(){{
                put("Tổng quan", "/about-us/overview");
                put("Sơ đồ tổ chức", "/about-us/organizational-chart");
                put("Tầm nhìn giá trị cốt lõi", "/about-us/vision-mission-values");
                put("Giấy phép & chứng chỉ", "/about-us/licenses-certificates");
                put("Quan hệ cổ đông", "/about-us/shareholder");
                put("Đối tác khách hàng", "/about-us/clients-partners");
            }});
        }});
        test.add(new ArrayList<>(){{
            add(new LinkedHashMap<>(){{
                put("Lĩnh vực hoạt động", "/what-we-do/our-business-lines");
                put("Phát triển bền vững", "/what-we-do/sustainable-development");
                put("Hình ảnh thi công", "/what-we-do/gallery");
            }});
        }});
        test.add(new ArrayList<>(){{
            add(new LinkedHashMap<>(){{
                put("Năng lượng", "/projects");
                put("Nhà ga", "/projects");
                put("Công nghiệp", "/projects");
                put("Hạ tầng giao thông", "/projects");
                put("Dân dụng", "/projects");
                put("Công nghệ", "/projects");
            }});
        }});
        test.add(new ArrayList<>());
        test.add(new ArrayList<>(){{
            add(new LinkedHashMap<>(){{
                put("Cơ hội nghề nghiệp", "/careers/job-opportunities");
                put("Chính sách nhân sự", "/careers/hr-policies");
                put("Văn hóa Techgel", "/careers/cultural-techgel");
            }});
        }});
        test.add(new ArrayList<>());

        model.addAttribute("testNavigations", navigations);
        model.addAttribute("subnavigations", test);
    }
}
