package com.techgel.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("")
    public String viewHomagePage(Model model){

        List<String> banners = new ArrayList<>();

        banners.add("/imgs/068a850f-79c2-493a-b394-54fff1eb5eb4.jfif");
        banners.add("/imgs/46736717-3837-4318-8fa9-c3e0fed82c68.jfif");
        banners.add("/imgs/b29dced9-353e-4031-bb40-d5e1e45753f6.jfif");
        banners.add("/imgs/carosel-04.jpg");

        model.addAttribute("banners", banners);
        return "clients/home/home";
    }

    @GetMapping("/profile")
    public String viewBrochure(){
        return "clients/profile";
    }

    @GetMapping("/about-us")
    public String viewIntroduce(){
        return "clients/about-us/introduce";
    }

    @GetMapping("/organizational-chart")
    public String viewOrganizationalChart(){
        return "clients/about-us/organizational-chart";
    }

    @GetMapping("/vision-mission-values")
    public String viewVisionMissionValues(){
        return "clients/about-us/vision-mission-values";
    }

    @GetMapping("/licenses-certificates")
    public String viewLicensesCertificates(){
        return "clients/about-us/licenses-certificates";
    }

    @GetMapping("/clients-partners")
    public String viewClientsPartners(){
        return "clients/about-us/clients-partners";
    }

    @GetMapping("/projects")
    public String viewProjects(){
        return "clients/projects";
    }

    @GetMapping("/our-business-lines")
    public String viewOurBusinessLines(){
        return "clients/what-we-do/our-business-lines";
    }

    @GetMapping("/gallery")
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

    @GetMapping("/shareholder")
    public String viewShareholder() {
        return "clients/shareholder/shareholder";
    }

    @GetMapping("/stock-info")
    public String viewStockInfo() {
        return "clients/shareholder/stock-info";
    }

    @GetMapping("/job-opportunities")
    public String viewJobOpportunities() {
        return "clients/careers/job-opportunities";
    }

    @GetMapping("/hr-policies")
    public String viewHrPolicies() {
        return "clients/careers/hr-policies";
    }

    @GetMapping("/sustainable-development")
    public String viewSustainableDevelopment() {
        return "clients/what-we-do/sustainable-development";
    }

    @GetMapping("/cultural-techgel")
    public String viewCulturalTechgel() {
        return "clients/careers/cultural-techgel";
    }
}
