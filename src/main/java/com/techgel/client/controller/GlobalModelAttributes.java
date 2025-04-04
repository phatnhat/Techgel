package com.techgel.client.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;

@ControllerAdvice
public class GlobalModelAttributes {
    @ModelAttribute
    public void addCommonAttributes(Model model) {
        List<Map<String, String>> navigations = new ArrayList<>();
        navigations.add(new HashMap<>(){{
            put("Về Techgel", "about-us");
        }});
        navigations.add(new HashMap<>(){{
            put("Năng lực thi công", "our-business-lines");
        }});
        navigations.add(new HashMap<>(){{
            put("Dự án", "projects");
        }});
        navigations.add(new HashMap<>(){{
            put("Tin tức", "news");
        }});
        navigations.add(new HashMap<>(){{
            put("Cổ đông", "shareholder");
        }});
        navigations.add(new HashMap<>(){{
            put("Tuyển dụng", "job-opportunities");
        }});
        navigations.add(new HashMap<>(){{
            put("Liên hệ", "contact-us");
        }});

        List<List<Map<String, String>>> test = new ArrayList<List<Map<String, String>>>();
        test.add(new ArrayList<>(){{
            add(new LinkedHashMap<>(){{
                put("Tổng quan", "about-us");
                put("Sơ đồ tổ chức", "organizational-chart");
                put("Tầm nhìn giá trị cốt lõi", "vision-mission-values");
                put("Giấy phép & chứng chỉ", "licenses-certificates");
                put("Đối tác khách hàng", "clients-partners");
            }});
        }});
        test.add(new ArrayList<>(){{
            add(new LinkedHashMap<>(){{
                put("Lĩnh vực hoạt động", "our-business-lines");
                put("Phát triển bền vững", "sustainable-development");
                put("Hình ảnh thi công", "gallery");
            }});
        }});
        test.add(new ArrayList<>(){{
            add(new LinkedHashMap<>(){{
                put("Năng lượng", "projects");
                put("Hàng không", "projects");
                put("Công nghiệp", "projects");
                put("Hạ tầng giao thông", "projects");
                put("Dân dụng", "projects");
                put("Công nghệ", "projects");
            }});
        }});
        test.add(new ArrayList<>());
        test.add(new ArrayList<>(){{
            add(new LinkedHashMap<>(){{
//                put("Đại hội cổ đông", "shareholder");
//                put("Báo cáo thường niên", "shareholder");
//                put("Báo cáo tài chính", "shareholder");
//                put("Công bố thông tin", "shareholder");
                put("Quan hệ cổ đông", "shareholder");
                put("Thông tin cổ phiếu", "stock-info");
            }});
        }});
        test.add(new ArrayList<>(){{
            add(new LinkedHashMap<>(){{
                put("Cơ hội nghề nghiệp", "job-opportunities");
                put("Chính sách nhân sự", "hr-policies");
                put("Văn hóa Techgel", "cultural-techgel");
            }});
        }});
        test.add(new ArrayList<>());

        model.addAttribute("testNavigations", navigations);
        model.addAttribute("subnavigations", test);
    }
}
