package com.techgel.client.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;

@ControllerAdvice
public class GlobalModelAttributes {
    @ModelAttribute
    public void addCommonAttributes(Model model) {
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
                put("Lĩnh vực hoạt động", "");
                put("Phát triển bền vững", "");
                put("Hình ảnh thi công", "");
            }});
        }});
        test.add(new ArrayList<>(){{
            add(new LinkedHashMap<>(){{
                put("Dự án nổi bật", "");
                put("Năng lượng", "");
                put("Hàng không", "");
                put("Công nghiệp", "");
                put("Hạ tầng giao thông", "");
                put("Dân dụng", "");
                put("Công nghệ", "");
            }});
        }});
        test.add(new ArrayList<>(){{
            add(new LinkedHashMap<>(){{
                put("Tin dự án", "");
                put("Hoạt động nội bộ", "");
                put("Hoạt động đào tạo", "");
            }});
        }});
        test.add(new ArrayList<>(){{
            add(new LinkedHashMap<>(){{
                put("Đại hội cổ đông", "");
                put("Các báo cáo", "");
                put("Công bố thông tin", "");
                put("Thông tin cổ phiếu", "");
            }});
        }});
        test.add(new ArrayList<>(){{
            add(new LinkedHashMap<>(){{
                put("Cơ hội nghề nghiệp", "");
                put("Chính sách nhân sự", "");
                put("Phát triển nguồn nhân lực", "");
                put("Văn hóa Techgel", "");
            }});
        }});
        test.add(new ArrayList<>());

        model.addAttribute("testNavigations", navigations);
        model.addAttribute("subnavigations", test);
    }
}
