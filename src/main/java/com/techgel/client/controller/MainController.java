package com.techgel.client.controller;

import com.techgel.common.DTOs.SignatureProjectDTO;
import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.service.HomeNavigationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    final HomeNavigationService homeNavigationService;

    @GetMapping("")
    public String viewHomagePage(Model model){

        // Banners
        List<String> banners = new ArrayList<>();

        banners.add("/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-1.jpg");
        banners.add("/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-2.jpg");
        banners.add("/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-3.jpg");
        banners.add("/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-4.jpg");
        banners.add("/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-5.jpg");
        banners.add("/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-6.jpg");

        model.addAttribute("banners", banners);

        // Signature Projects
        List<SignatureProjectDTO> signatureProjectsCarousel = List.of(
        new SignatureProjectDTO(
            "Nhà ga T3 Sân bay Tân Sơn Nhất",
            "https://lh3.googleusercontent.com/OGs3rJJO8ojjjYhRTIxKtgrseMDz_m5cgEYJOk74MeVZl3BGB58b7JCxOqPpZqKHXznUeBWpkm0sa4Tjf0JyU4_lA0VzkREBtXf8ZKCs1GMVETrr_gkDke74WeaoDEB6h2_dGMMALgSBT_FtW6oGFftVaYIhky4S38GxuY0ls8bzSC-MH_7l0PhUAPtIMuGh",
            "Cảng hàng không Việt Nam",
            "Quận Tân Bình",
            "Tổng thầu MEP",
            "/projects/t3-terminal"
        ),
        new SignatureProjectDTO(
            "Dwight School",
            "/imgs/projects/dwight-school-1.jpg",
            "Dwight School Hanoi",
            "Hà Nội",
            "Tổng thầy MEPF",
            "/projects/solar-recycling"
        ),
        new SignatureProjectDTO(
            "Điện gió Thái Hòa",
            "/imgs/projects/thai_hoa_power_wind_farm.jpg",
            "Tập đoàn Thái Bình Dương",
            "39C7, Hòa Thắng, Bắc Bình, Bình Thuận",
            "Trạm biến áp 220kV, trạm chuyển mạch, đường dây truyền tải cáp ngầm 22KV",
            "/projects/solar-recycling"
        ),
        new SignatureProjectDTO(
            "TTI",
            "https://newtecons.vn/wp-content/uploads/2023/06/1.-Southwest-conrner-1536x864.png",
            "EVN",
            "Đường 27, khu công nghiệp Việt Nam, xã Vĩnh Tân, TP. Tân Uyên, tỉnh Bình Dương",
            "Tổng thầu MEP",
            "/projects/solar-recycling"
        ),
        new SignatureProjectDTO(
            "Golden Hotel Đà Lạt",
            "/imgs/projects/golden-da-lat.webp",
            "Công ty Cổ phần Golden City",
            "Đà Lạt, Lâm Đồng",
            "Tổng thầu MEP",
            "/projects/solar-recycling"
        )
        );
        
        
        model.addAttribute("signatureProjects", signatureProjectsCarousel);

        return "clients/home/home";
    }



    @GetMapping("/profile")
    public String viewBrochure(){
        return "clients/profile";
    }

    @GetMapping({"/about-us", "/about-us/overview"})
    public String viewIntroduce(){
        return "clients/about-us/introduce";
    }

    @GetMapping("/about-us/organizational-chart")
    public String viewOrganizationalChart(){
        return "clients/about-us/organizational-chart";
    }

    @GetMapping("/about-us/vision-mission-values")
    public String viewVisionMissionValues(){
        return "clients/about-us/vision-mission-values";
    }

    @GetMapping("/about-us/licenses-certificates")
    public String viewLicensesCertificates(){
        return "clients/about-us/licenses-certificates";
    }

    @GetMapping("/about-us/clients-partners")
    public String viewClientsPartners(){
        return "clients/about-us/clients-partners";
    }

    @GetMapping({"/projects", "/projects/{slug}"})
    public String viewProjects(@PathVariable(required = false) String slug){
        return "clients/projects";
    }

    @GetMapping("/what-we-do/our-business-lines")
    public String viewOurBusinessLines(){
        return "clients/what-we-do/our-business-lines";
    }

    @GetMapping("/what-we-do/sustainable-development")
    public String viewSustainableDevelopment() {
        return "clients/what-we-do/sustainable-development";
    }

    @GetMapping("/what-we-do/gallery")
    public String viewConstructionGallery(){
        return "clients/what-we-do/construction-gallery";
    }

    @GetMapping("/contact-us")
    public String viewContactUs(){
        return "clients/contact-us";
    }

    @GetMapping("/news")
    public String viewNews(){
        return "clients/news/news";
    }

    @GetMapping("/news-details")
    public String viewNewsDetails() {
        return "clients/news/news-details";
    }

    @GetMapping("/investor/shareholder")
    public String viewShareholder() {
        return "clients/shareholder/shareholder";
    }

    @GetMapping("/investor/stock-info")
    public String viewStockInfo() {
        return "clients/shareholder/stock-info";
    }

    @GetMapping("/careers/job-opportunities")
    public String viewJobOpportunities() {
        return "clients/careers/job-opportunities";
    }

    @GetMapping("/careers/hr-policies")
    public String viewHrPolicies() {
        return "clients/careers/hr-policies";
    }

    @GetMapping("/careers/cultural-techgel")
    public String viewCulturalTechgel() {
        return "clients/careers/cultural-techgel";
    }
}
