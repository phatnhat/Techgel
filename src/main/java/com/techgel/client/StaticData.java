package com.techgel.client;

import com.techgel.common.entity.adminSettings.*;
import org.apache.commons.text.StringEscapeUtils;

import java.util.*;
import java.util.stream.Collectors;

public abstract class StaticData {
    public static List<HomeNavigation> homeNavigationData(){
        HomeNavigation homepage = new HomeNavigation("Trang chủ", "Homepage", true, 1, "/");
        HomeNavigation aboutUs = new HomeNavigation("Về Techgel", "About Techgel", true, 1, "/about-us");
        HomeNavigation whatWeDo = new HomeNavigation("Năng lực thi công", "What we do", true, 2, "/what-we-do");
        HomeNavigation projects = new HomeNavigation("Dự án", "Projects", true, 3, "/projects");
        HomeNavigation blog = new HomeNavigation("Tin tức", "News", true, 4, "/news");
        HomeNavigation careers = new HomeNavigation("Tuyển dụng", "Careers", true, 6, "/careers");
        HomeNavigation contact = new HomeNavigation("Liên hệ", "Contact us", true, 7, "/contact-us");

        HomeNavigation aboutUs1 = new HomeNavigation("Tổng quan", "1", true, 1, aboutUs, "/about-us/overview", "/imgs/banners/building.jpg");
        HomeNavigation aboutUs2 = new HomeNavigation("Sơ đồ tổ chức", "2", true, 2, aboutUs, "/about-us/organizational-chart", "/imgs/banners/orgchart.jpg");
        HomeNavigation aboutUs3 = new HomeNavigation("Tầm nhìn, giá trị cốt lõi", "3", true, 3, aboutUs, "/about-us/vision-mission-values", "/imgs/banners/vision-banner.jpg");
        HomeNavigation aboutUs4 = new HomeNavigation("Giấy phép & chứng chỉ", "4", true, 4, aboutUs, "/about-us/licenses-certificates", "/imgs/banners/certifications.jpg");
        HomeNavigation aboutUs5 = new HomeNavigation("Quan hệ cổ đông", "5", true, 5, aboutUs, "/about-us/shareholder", "/imgs/banners/shareholders.jpg");
        HomeNavigation aboutUs6 = new HomeNavigation("Đối tác khách hàng", "6", true, 6, aboutUs, "/about-us/clients-partners", "/imgs/banners/handshake.jpg");
        aboutUs.setChildren(Set.of(aboutUs1, aboutUs2, aboutUs3, aboutUs4, aboutUs5, aboutUs6).stream().sorted(Comparator.comparingInt(HomeNavigation::getDisplayOrder)).collect(Collectors.toCollection(LinkedHashSet::new)));

        HomeNavigation whatWeDo1 = new HomeNavigation("Lĩnh vực hoạt động", "6", true, 1, whatWeDo, "/what-we-do/our-business-lines", "/imgs/banners/tech-field.jpg");
        HomeNavigation whatWeDo3 = new HomeNavigation("Phát triển bền vững", "8", true, 3, whatWeDo, "/what-we-do/sustainable-development", "/imgs/banners/growth-sustain.jpg");
        HomeNavigation whatWeDo4 = new HomeNavigation("Hình ảnh thi công", "9", true, 4, whatWeDo, "/what-we-do/gallery", "/imgs/banners/news-banner.jpg");
        whatWeDo.setChildren(Set.of(whatWeDo1, whatWeDo3, whatWeDo4).stream().sorted(Comparator.comparingInt(HomeNavigation::getDisplayOrder)).collect(Collectors.toCollection(LinkedHashSet::new)));

        HomeNavigation projects1 = new HomeNavigation("Năng lượng", "10", true, 1, projects, "/projects/energy", "/imgs/banners/building.jpg");
        HomeNavigation projects2 = new HomeNavigation("Công trình hàng không", "11", true, 2, projects, "/projects/aviation", "/imgs/banners/building.jpg");
        HomeNavigation projects3 = new HomeNavigation("Công nghiệp", "12", true, 3, projects, "/projects/industry", "/imgs/banners/building.jpg");
        HomeNavigation projects4 = new HomeNavigation("Dân dụng", "13", true, 4, projects, "/projects/civil", "/imgs/banners/building.jpg");
        HomeNavigation projects5 = new HomeNavigation("Hạ tầng giao thông", "14", true, 5, projects, "/projects/infrastructure", "/imgs/banners/building.jpg");
        HomeNavigation projects6 = new HomeNavigation("Công nghệ", "15", true, 6, projects, "/projects/technology", "/imgs/banners/building.jpg");
        projects.setChildren(Set.of(projects1, projects2, projects3, projects4, projects5, projects6).stream().sorted(Comparator.comparingInt(HomeNavigation::getDisplayOrder)).collect(Collectors.toCollection(LinkedHashSet::new)));

        HomeNavigation careers1 = new HomeNavigation("Cơ hội nghề nghiệp", "18", true, 1, careers, "/careers/job-opportunities", "/imgs/banners/building.jpg");
        HomeNavigation careers2 = new HomeNavigation("Chính sách nhân sự", "19", true, 2, careers, "/careers/hr-policies", "/imgs/banners/building.jpg");
        HomeNavigation careers3 = new HomeNavigation("Văn hóa Techgel", "20", true, 3, careers, "/careers/cultural-techgel", "/imgs/banners/building.jpg");
        careers.setChildren(Set.of(careers1, careers2, careers3).stream().sorted(Comparator.comparingInt(HomeNavigation::getDisplayOrder)).collect(Collectors.toCollection(LinkedHashSet::new)));

        return List.of(homepage, aboutUs, whatWeDo, projects, blog, careers, contact);
    }

    public static EProfile eProfileData(){
        return new EProfile("Hồ sơ năng lực", "E-Profile", "/imgs/HSNL.png", true, "/files/TECHGEL-COMPANY-PROFILE-2025-02.pdf");
    }

    public static List<Carousel> carouselsData(){
        Carousel carousel1 = new Carousel(1L, 1, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-1.jpg", StringEscapeUtils.unescapeHtml4("<div style=\"\"><pre style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 9.8pt;\"><font color=\"#ffffff\">&lt;h3&gt;NHÀ CHỜ T3 TÂN SƠN NHẤT&lt;/h3&gt;&lt;span&gt;Khánh thành: Ngày 30/04/2025.&lt;/span&gt;&lt;span&gt;Dịch vụ: MEP và Kiot checkin.&lt;/span&gt;</font></pre></div>"));
        Carousel carousel2 = new Carousel(2L, 2, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-soha.jpg", StringEscapeUtils.unescapeHtml4("<div style=\"\"><pre style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 9.8pt;\"><font color=\"#ffffff\">&lt;h3&gt;NHÀ CHỜ T3 TÂN SƠN NHẤT&lt;/h3&gt;&lt;span&gt;Khánh thành: Ngày 30/04/2025.&lt;/span&gt;&lt;span&gt;Dịch vụ: MEP và Kiot checkin.&lt;/span&gt;</font></pre></div>"));
        Carousel carousel3 = new Carousel(3L, 3, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-3.jpg", StringEscapeUtils.unescapeHtml4("<div style=\"\"><pre style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 9.8pt;\"><font color=\"#ffffff\">&lt;h3&gt;NHÀ CHỜ T3 TÂN SƠN NHẤT&lt;/h3&gt;&lt;span&gt;Khánh thành: Ngày 30/04/2025.&lt;/span&gt;&lt;span&gt;Dịch vụ: MEP và Kiot checkin.&lt;/span&gt;</font></pre></div>"));
        Carousel carousel4 = new Carousel(4L, 4, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-4.jpg", StringEscapeUtils.unescapeHtml4("<div style=\"\"><pre style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 9.8pt;\"><font color=\"#ffffff\">&lt;h3&gt;NHÀ CHỜ T3 TÂN SƠN NHẤT&lt;/h3&gt;&lt;span&gt;Khánh thành: Ngày 30/04/2025.&lt;/span&gt;&lt;span&gt;Dịch vụ: MEP và Kiot checkin.&lt;/span&gt;</font></pre></div>"));
        Carousel carousel5 = new Carousel(5L, 5, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-5.jpg", StringEscapeUtils.unescapeHtml4("<div style=\"\"><pre style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 9.8pt;\"><font color=\"#ffffff\">&lt;h3&gt;NHÀ CHỜ T3 TÂN SƠN NHẤT&lt;/h3&gt;&lt;span&gt;Khánh thành: Ngày 30/04/2025.&lt;/span&gt;&lt;span&gt;Dịch vụ: MEP và Kiot checkin.&lt;/span&gt;</font></pre></div>"));
        Carousel carousel6 = new Carousel(6L, 6, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-6.jpg", StringEscapeUtils.unescapeHtml4("<div style=\"\"><pre style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 9.8pt;\"><font color=\"#ffffff\">&lt;h3&gt;NHÀ CHỜ T3 TÂN SƠN NHẤT&lt;/h3&gt;&lt;span&gt;Khánh thành: Ngày 30/04/2025.&lt;/span&gt;&lt;span&gt;Dịch vụ: MEP và Kiot checkin.&lt;/span&gt;</font></pre></div>"));

        return List.of(carousel1, carousel2, carousel3, carousel4, carousel5, carousel6);
    }

    public static List<HomeAboutUs> homeAboutUsData(){
        HomeAboutUs homeAboutUs1 = new HomeAboutUs(1L, "Về chúng tôi", "About us", "TECHGEL", "TECHGEL", "Công ty CP Kỹ thuật Công nghệ Sài Gòn (TECHGEL) là một trong những đơn vị hàng đầu tại Việt Nam trong lĩnh vực thiết kế, cung cấp và lắp đặt hệ thống điện, hàng không, công nghiệp, dân dụng, hạ tầng & công nghệ. Với hơn 25 năm kinh nghiệm, TECHGEL đã khẳng định được vị thế của mình trên thị trường và mang đến cho khách hàng những giải pháp toàn diện, tiên tiến, hiệu quả và bền vững, đạt tiêu chuẩn hàng đầu quốc tế & trong nước.",
                "Saigon Technology Engineering Joint Stock Company (TECHGEL) is one of Vietnam’s leading companies in the design, supply, and installation of electrical, aviation, industrial, civil, infrastructure, and technology systems. With over 25 years of experience, TECHGEL has established its position in the market, providing customers with comprehensive, advanced, efficient, and sustainable solutions that meet top international and domestic standards.", "/imgs/home/mer-adv.jpg", "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png", "/imgs/news/nha-ga-t3-tt/nha-ga-t3-soha.jpg");

        return List.of(homeAboutUs1);
    }

    public static List<HomeStatistic> homeStatisticData(){
        HomeStatistic homeStatistic = new HomeStatistic(1L, "Doanh nghiệp xuất sắc", "Excellent enterprise", "Top 500 tại Việt Nam", "Top 500 in Vietnam");

        return List.of(homeStatistic);
    }

    public static List<HomeStatisticItems> homeStatisticItemsData(){
        HomeStatisticItems homeStatisticItem1 = new HomeStatisticItems(1L, "DỰ ÁN THI CÔNG", "CONSTRUCTION PROJECT", 100, 1, "+", "+");
        HomeStatisticItems homeStatisticItem2 = new HomeStatisticItems(2L, "TỔNG TÀI SẢN", "TOTAL ASSETS", 1.754, 2, "tỷ", "billion");
        HomeStatisticItems homeStatisticItem3 = new HomeStatisticItems(3L, "TỔNG SỐ NHÂN VIÊN", "TOTAL NUMBER OF EMPLOYEES", 450, 3, "+", "+");
        HomeStatisticItems homeStatisticItem4 = new HomeStatisticItems(4L, "LỰC LƯỢNG THI CÔNG", "CONSTRUCTION FORCE", 1000, 4, "+", "+");

        return List.of(homeStatisticItem1, homeStatisticItem2, homeStatisticItem3, homeStatisticItem4);
    }

    public static List<HomeOurBusinessLine> homeOurBusinessLineData(){
        HomeOurBusinessLine homeOurBusinessLine = new HomeOurBusinessLine(1L, "Lĩnh vực hoạt động", "Field of activity", "Lĩnh vực chuyên ngành", "Field of specialization");

        return List.of(homeOurBusinessLine);
    }

    public static List<WhatWeDoService> whatWeDoServiceData(){
        WhatWeDoService item1 = new WhatWeDoService(1L, "Năng lượng", "Energy", 1, "/imgs/solar_energy.jpg", "");
        WhatWeDoService item2 = new WhatWeDoService(2L, "Công trình hàng không", "Aviation", 2, "https://hips.hearstapps.com/hmg-prod/images/gettyimages-637243664-1520356722.jpg?resize=640:*", "");
        WhatWeDoService item3 = new WhatWeDoService(3L, "Công nghiệp", "Industry", 3, "https://d2csxpduxe849s.cloudfront.net/media/E32629…4925E4/WebsiteJpg_XL-FIENG_Main%20Visual_Cyan.jpg", "");
        WhatWeDoService item4 = new WhatWeDoService(4L, "Dân dụng", "Civil", 4, "https://5.imimg.com/data5/SELLER/Default/2024/7/43…43654/building-construction-services-500x500.jpeg", "");
        WhatWeDoService item5 = new WhatWeDoService(5L, "Hạ tầng giao thông", "Infrastructure", 5, "https://www.letsbuild.com/wp-content/uploads/2023/07/types-of-infrastructure.jpeg", "");
        WhatWeDoService item6 = new WhatWeDoService(6L, "Công nghệ", "Technology", 6, "https://cdn.britannica.com/84/203584-131-357FBE7D/speed-internet-technology-background.jpg", "");

        return List.of(item1, item2, item3, item4, item5, item6);
    }

    public static List<AboutUsIntroduce> aboutUsIntroduceData(){
        AboutUsIntroduce aboutUsIntroduce = new AboutUsIntroduce(1L, "Về chúng tôi" , "About us", "TECHGEL", "TECHGEL", "Công ty CP Kỹ thuật Công nghệ Sài Gòn (TECHGEL) là một trong những đơn vị hàng đầu tại Việt Nam trong lĩnh vực thiết kế, cung cấp và lắp đặt hệ thống điện, hàng không, công nghiệp, dân dụng, hạ tầng & công nghệ. Với hơn 25 năm kinh nghiệm, TECHGEL đã khẳng định được vị thế của mình trên thị trường và mang đến cho khách hàng những giải pháp toàn diện, tiên tiến, hiệu quả và bền vững, đạt tiêu chuẩn hàng đầu quốc tế & trong nước.",
                "Saigon Technology Engineering Joint Stock Company (TECHGEL) is one of Vietnam’s leading companies in the design, supply, and installation of electrical, aviation, industrial, civil, infrastructure, and technology systems. With over 25 years of experience, TECHGEL has established its position in the market, providing customers with comprehensive, advanced, efficient, and sustainable solutions that meet top international and domestic standards.",
                "/imgs/gioi-thieu-Cong-Ty-Cp-Ky-Thuat-Cong-Nghe-Sai-Gon.png", "Kỹ thuật Công nghệ Sài Gòn", "Saigon Technology Engineering", "Công nghệ tiên phong, kiến tạo nền tảng vững chắc cho mọi công trình", "Pioneering technology, building a solid foundation for every project.");
        return List.of(aboutUsIntroduce);
    }

    public static List<AboutUsTestimonial> aboutUsTestimonialData(){
        AboutUsTestimonial aboutUsTestimonial = new AboutUsTestimonial(1L, "Khách hàng đã nói gì về chúng tôi?", "What do our customers say about us?", "CẢM NHẬN KHÁCH HÀNG", "CUSTOMER FEEDBACK");
        return List.of(aboutUsTestimonial);
    }

    public static List<AboutUsTestimonialItems> aboutUsTestimonialItemData(){
        AboutUsTestimonialItems aboutUsTestimonialItems1 = new AboutUsTestimonialItems(1L,
                "Với mục đích để giảm bớt chi phí tiền điện cho doanh nghiệp, tự chủ được nguồn điện sử dụng. Tôi đã liên hệ hợp tác với Công ty  để triển khai dự án lắp đặt hệ thống điện mặt trời cho doanh nghiệp của tôi. Tôi rất hài lòng về sản phẩm và sự chuyên nghiệp trong cách làm việc của Techgel.",
                "We are very proud of Techgel on this project. During this difficult period, we all have great confidence in Coteccons’ ability to complete the project on time and meet our quality expectations. First of all, Techgel is the most prestigious contractor in Vietnam. We are very proud to have a partnership with Techgel on the Ho Tram project. This is a relationship that we have developed in the past and look forward to continuing in the future.",
                "Ông John", "Mr.John", "Giám đốc", "General Director",
                "/imgs/recommendations/mrtruyen.png",
                1);

        AboutUsTestimonialItems aboutUsTestimonialItems2 = new AboutUsTestimonialItems(1L,
                "Hệ thống ngay sau khi lắp đặt đã đi vào hoạt động ổn định. Dòng điện tổng hợp được từ ánh sáng mặt trời đã hòa vào lưới phục vụ nhu cầu sử dụng của gia đình tôi. Có những tấm pin, tôi cảm thấy nhà mát mẻ hơn do tác dụng chống nóng rất đặc biệt của nó.",
                "We are very proud of Techgel on this project. During this difficult period, we all have great confidence in Coteccons’ ability to complete the project on time and meet our quality expectations. First of all, Techgel is the most prestigious contractor in Vietnam. We are very proud to have a partnership with Techgel on the Ho Tram project. This is a relationship that we have developed in the past and look forward to continuing in the future.",
                "Ông Thế", "Mr.Thế", "Chủ tịch", "CEO",
                "/imgs/recommendations/mrthe.png",
                2);

        AboutUsTestimonialItems aboutUsTestimonialItems3 = new AboutUsTestimonialItems(1L,
                "Tôi có nhờ bên TECHGEL lắp đặt hệ thống cơ điện lạnh cho terminal T3 và tôi cảm thấy rất chất lượng. Đội ngũ làm việc cực kì năng động, chuyên nghiệp với quy trình rõ ràng và hiệu quả khiến cho việc khánh thành ngày 30/4 thuận lợi hơn bao giờ hết.",
                "We are very proud of Techgel on this project. During this difficult period, we all have great confidence in Coteccons’ ability to complete the project on time and meet our quality expectations. First of all, Techgel is the most prestigious contractor in Vietnam. We are very proud to have a partnership with Techgel on the Ho Tram project. This is a relationship that we have developed in the past and look forward to continuing in the future.",
                "Lê Mạnh Hùng", "Mr.Hùng", "Chủ tịch", "CEO",
                "/imgs/recommendations/lemanhhung.jpg",
                3);

        return List.of(aboutUsTestimonialItems1, aboutUsTestimonialItems2, aboutUsTestimonialItems3);
    }

    public static List<AboutUsOrganizationalChart> aboutUsOrganizationalChartData(){
        AboutUsOrganizationalChart aboutUsOrganizationalChart = new AboutUsOrganizationalChart(1L,
                "Sơ đồ tổ chức", "Organizational Chart",
                "TECHGEL", "TECHGEL", "/files/TECHGEL-COMPANY-PROFILE-2025-02.pdf");
        return List.of(aboutUsOrganizationalChart);
    }

    public static List<AboutUsOrganizationalChartItems> aboutUsOrganizationalChartItemData(){
        AboutUsOrganizationalChartItems aboutUsOrganizationalChartItems1 = new AboutUsOrganizationalChartItems(1L, "/imgs/organizational-page-0001.jpg", 1);
        AboutUsOrganizationalChartItems aboutUsOrganizationalChartItems2 = new AboutUsOrganizationalChartItems(2L, "/imgs/organizational-page-0002.jpg", 2);
        return List.of(aboutUsOrganizationalChartItems1, aboutUsOrganizationalChartItems2);
    }

    public static List<AboutUsLicenseCertificate> aboutUsLicenseCertificateData(){
        AboutUsLicenseCertificate aboutUsLicenseCertificate1 = new AboutUsLicenseCertificate("Giấy phép", "License", 1);
        AboutUsLicenseCertificate aboutUsLicenseCertificate2 = new AboutUsLicenseCertificate("Chứng chỉ", "Certificate", 2);

        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems1 = new AboutUsLicenseCertificateItems(1L, "TECHGEL Business Registration License 05.04.2023", "TECHGEL Business Registration License 05.04.2023", "/imgs/licenses-certificates/licenses1.png", 1, aboutUsLicenseCertificate1);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems2 = new AboutUsLicenseCertificateItems(2L, "TECHGEL Business Registration License 05.04.2023", "TECHGEL Business Registration License 05.04.2023", "/imgs/licenses-certificates/licenses2.png", 2, aboutUsLicenseCertificate1);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems3 = new AboutUsLicenseCertificateItems(3L, "TECHGEL Business Registration License 05.04.2023", "TECHGEL Business Registration License 05.04.2023", "/imgs/licenses-certificates/licenses3.jpg", 3, aboutUsLicenseCertificate1);
        aboutUsLicenseCertificate1.setAboutUsLicenseCertificateItems(List.of(aboutUsLicenseCertificateItems1, aboutUsLicenseCertificateItems2, aboutUsLicenseCertificateItems3));

        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems4 = new AboutUsLicenseCertificateItems(3L, "TECHGEL Business Registration License 05.04.2023", "TECHGEL Business Registration License 05.04.2023", "/imgs/licenses-certificates/certificate1.png", 1, aboutUsLicenseCertificate2);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems5 = new AboutUsLicenseCertificateItems(3L, "TECHGEL Business Registration License 05.04.2023", "TECHGEL Business Registration License 05.04.2023", "/imgs/licenses-certificates/certificate2.png", 2, aboutUsLicenseCertificate2);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems6 = new AboutUsLicenseCertificateItems(3L, "TECHGEL Business Registration License 05.04.2023", "TECHGEL Business Registration License 05.04.2023", "/imgs/licenses-certificates/certificate3.png", 3, aboutUsLicenseCertificate2);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems7 = new AboutUsLicenseCertificateItems(3L, "TECHGEL Business Registration License 05.04.2023", "TECHGEL Business Registration License 05.04.2023", "/imgs/licenses-certificates/certificate4.png", 4, aboutUsLicenseCertificate2);
        aboutUsLicenseCertificate2.setAboutUsLicenseCertificateItems(List.of(aboutUsLicenseCertificateItems4, aboutUsLicenseCertificateItems5, aboutUsLicenseCertificateItems6, aboutUsLicenseCertificateItems7));

        return List.of(aboutUsLicenseCertificate1, aboutUsLicenseCertificate2);
    }
}
