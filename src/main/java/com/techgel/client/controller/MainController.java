package com.techgel.client.controller;

import com.techgel.common.DTOs.SignatureProjectDTO;
import com.techgel.common.entity.adminSettings.*;
import com.techgel.common.entity.enums.NewsType;
import com.techgel.common.DTOs.LogoDTO;
import com.techgel.common.DTOs.NewsDTO;

import com.techgel.common.entity.enums.ProjectRegions;
import com.techgel.common.service.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class MainController {
        private final CarouselService carouselService;
        private final HomeAboutUsService homeAboutUsService;
        private final HomeStatisticService homeStatisticService;
        private final HomeStatisticItemsService homeStatisticItemsService;
        private final HomeOurBusinessLineService homeOurBusinessLineService;
        private final WhatWeDoServiceService whatWeDoServiceService;
        private final AboutUsIntroduceService aboutUsIntroduceService;
        private final EProfileService eProfileService;
        private final AboutUsTestimonialService aboutUsTestimonialService;
        private final AboutUsTestimonialItemsService aboutUsTestimonialItemsService;
        private final AboutUsOrganizationalService aboutUsOrganizationalService;
        private final AboutUsOrganizationalChartItemsService aboutUsOrganizationalChartItemsService;
        private final AboutUsLicenseCertificateService aboutUsLicenseCertificateService;
        private final AboutUsClientPartnerService aboutUsClientPartnerService;
        private final ProjectCategoryService projectCategoryService;
        private final ProjectService projectService;
        private final NewsService newsService;
        private final CareerRecruitmentService careerRecruitmentService;

        @GetMapping("")
        public String viewHomagePage(Model model, HttpServletRequest request) {

                List<Carousel> banners = carouselService.getAll();
                HomeAboutUs homeAboutUs = homeAboutUsService.getById(1L);
                HomeStatistic homeStatistic = homeStatisticService.getById(1L);
                List<HomeStatisticItems> homeStatisticItems = homeStatisticItemsService.getAll();
                HomeOurBusinessLine homeOurBusinessLine = homeOurBusinessLineService.getById(1L);
                List<WhatWeDoService> whatWeDoServices = whatWeDoServiceService.getAll();
                AboutUsTestimonial aboutUsTestimonial = aboutUsTestimonialService.getById(1L);
                List<AboutUsTestimonialItems> aboutUsTestimonialItems = aboutUsTestimonialItemsService.getAll();

                List<AboutUsClientPartner> aboutUsClientPartners = aboutUsClientPartnerService.getAll();
                List<AboutUsClientPartnerItems> aboutUsClientPartnerItems = new ArrayList<AboutUsClientPartnerItems>();

                for (AboutUsClientPartner partnerCategory : aboutUsClientPartners) {
                        aboutUsClientPartnerItems.addAll(partnerCategory.getAboutUsClientPartnerItems());
                }

                model.addAttribute("aboutUsClientPartnerItems", aboutUsClientPartnerItems);

                model.addAttribute("banners", banners);
                model.addAttribute("homeAboutUs", homeAboutUs);
                model.addAttribute("homeStatistic", homeStatistic);
                model.addAttribute("homeStatisticItems", homeStatisticItems);
                model.addAttribute("homeOurBusinessLine", homeOurBusinessLine);
                model.addAttribute("whatWeDoServices", whatWeDoServices);
                model.addAttribute("aboutUsTestimonial", aboutUsTestimonial);
                model.addAttribute("aboutUsTestimonialItems", aboutUsTestimonialItems);

                model.addAttribute("aboutUsClientPartners", aboutUsClientPartners);
                // Get Featured projects
                List<Project> featuredProjects = projectService.getAllByFeaturedIsTrue();
                model.addAttribute("featuredProjects", featuredProjects);

                return "clients/home/home";
        }

        @GetMapping("/profile")
        public String viewEProfile(Model model) {
                return "clients/profile";
        }

        @GetMapping({ "/about-us", "/about-us/overview" })
        public String viewIntroduce(Model model) {
                AboutUsIntroduce aboutUsIntroduce = aboutUsIntroduceService.getById(1L);
                EProfile eProfile = eProfileService.getById(1L);
                AboutUsTestimonial aboutUsTestimonial = aboutUsTestimonialService.getById(1L);
                List<AboutUsTestimonialItems> aboutUsTestimonialItems = aboutUsTestimonialItemsService.getAll();

                List<AboutUsClientPartner> aboutUsClientPartners = aboutUsClientPartnerService.getAll();
                List<AboutUsClientPartnerItems> aboutUsClientPartnerItems = new ArrayList<AboutUsClientPartnerItems>();

                for (AboutUsClientPartner partnerCategory : aboutUsClientPartners) {
                        aboutUsClientPartnerItems.addAll(partnerCategory.getAboutUsClientPartnerItems());
                }

                model.addAttribute("aboutUsClientPartnerItems", aboutUsClientPartnerItems);

                model.addAttribute("aboutUsIntroduce", aboutUsIntroduce);
                model.addAttribute("eProfile", eProfile);
                model.addAttribute("aboutUsTestimonial", aboutUsTestimonial);
                model.addAttribute("aboutUsTestimonialItems", aboutUsTestimonialItems);

                return "clients/about-us/introduce";
        }

        @GetMapping("/about-us/organizational-chart")
        public String viewOrganizationalChart(Model model) {
                AboutUsOrganizationalChart aboutUsOrganizationalChart = aboutUsOrganizationalService.getById(1L);
                List<AboutUsOrganizationalChartItems> aboutUsOrganizationalChartItems = aboutUsOrganizationalChartItemsService
                                .getAll();
                model.addAttribute("aboutUsOrganizationalChart", aboutUsOrganizationalChart);
                model.addAttribute("aboutUsOrganizationalChartItems", aboutUsOrganizationalChartItems);

                return "clients/about-us/organizational-chart";
        }

        @GetMapping("/about-us/vision-mission-values")
        public String viewVisionMissionValues() {
                return "clients/about-us/vision-mission-values";
        }

        @GetMapping("/about-us/licenses-certificates")
        public String viewLicensesCertificates(Model model) {
                List<AboutUsLicenseCertificate> aboutUsLicenseCertificates = aboutUsLicenseCertificateService.getAll();
                model.addAttribute("aboutUsLicenseCertificates", aboutUsLicenseCertificates);

                return "clients/about-us/licenses-certificates";
        }

        @GetMapping("/about-us/clients-partners")
        public String viewClientsPartners(Model model) {
                List<AboutUsClientPartner> aboutUsClientPartners = aboutUsClientPartnerService.getAll();
                model.addAttribute("aboutUsClientPartners", aboutUsClientPartners);

                return "clients/about-us/clients-partners";
        }

        @GetMapping("/about-us/cultural-techgel")
        public String viewCulturalTechgel(@RequestParam(name = "type", defaultValue = "CULTURAL") NewsType type,
                                          @RequestParam(name = "page", defaultValue = "1") int page,
                                          Model model) {
                int pageSize = 3;
                Pageable pageable = PageRequest.of(page - 1, pageSize);

                Page<News> allNews = newsService.getAllByType(type, pageable);

                model.addAttribute("newsList", allNews);
                model.addAttribute("currentType", type.name());

                model.addAttribute("newsListPaged", allNews);
                model.addAttribute("currentPage", page);
                model.addAttribute("totalPages", allNews.getTotalPages());
                model.addAttribute("newsTypeList", NewsType.getCultural());

                return "clients/about-us/cultural-techgel";
        }

        @GetMapping("/about-us/shareholder")
        public String viewShareholder() {
                return "clients/shareholder/shareholder";
        }

        @GetMapping({ "/projects", "/projects/{slug}" })
        public String viewProjects(Model model, @PathVariable(required = false) String slug,
                        @RequestParam(name = "years[]", required = false) List<Integer> years,
                        @RequestParam(name = "regions[]", required = false) List<String> regions) {
                List<ProjectCategory> projectCategories = projectCategoryService.getAll();

                List<Project> projects = null;

                if (slug == null) {
                        projects = projectService.getAll();
                } else if (slug.equals("featured")) {
                        projects = projectService.getAllByFeaturedIsTrue();
                } else {
                        projects = projectService.getAllByProjectCategorySlug(slug);
                }

                if (years != null) {
                        projects = projects.stream().filter(project -> project != null &&
                                        years.contains(project.getYear()))
                                        .collect(Collectors.toList());
                }
                if (regions != null) {
                        projects = projects.stream().filter(project -> project != null &&
                                        project.getRegion() != null &
                                                        regions.contains(project.getRegion()))
                                        .collect(Collectors.toList());
                }

                model.addAttribute("slug", slug);
                model.addAttribute("years_checked", years);
                model.addAttribute("regions_checked", regions);
                model.addAttribute("currentYear", Year.now().getValue());
                model.addAttribute("regions", ProjectRegions.values());
                model.addAttribute("projects", projects);
                model.addAttribute("projectCategories", projectCategories);

                return "clients/projects/projects";
        }

        @GetMapping("/project_details/{projectId}")
        public String viewProjectDetails(Model model, @PathVariable Long projectId) {
                Project project = projectService.getById(projectId);

                model.addAttribute("project", project);

                return "clients/projects/project_details";
        }

        @GetMapping({ "/what-we-do", "/what-we-do/our-business-lines" })
        public String viewOurBusinessLines(Model model) {
                HomeOurBusinessLine homeOurBusinessLine = homeOurBusinessLineService.getById(1L);
                List<WhatWeDoService> whatWeDoServices = whatWeDoServiceService.getAll();

                model.addAttribute("homeOurBusinessLine", homeOurBusinessLine);
                model.addAttribute("whatWeDoServices", whatWeDoServices);
                return "clients/what-we-do/our-business-lines";
        }

        @GetMapping({ "/what-we-do/our-business-line-details" })
        public String viewOurBusinessLineDetails(Model model, @RequestParam Long id) {
                WhatWeDoService whatWeDoService = whatWeDoServiceService.getById(id);

                model.addAttribute("whatWeDoService", whatWeDoService);
                return "clients/what-we-do/our-business-line-details";
        }

        @GetMapping("/what-we-do/sustainable-development")
        public String viewSustainableDevelopment() {
                return "clients/what-we-do/sustainable-development";
        }

        @GetMapping("/what-we-do/gallery")
        public String viewConstructionGallery() {
                return "clients/what-we-do/construction-gallery";
        }

        @GetMapping("/contact-us")
        public String viewContactUs() {
                return "clients/contact-us";
        }

        @GetMapping("/news")
        public String getNewsPage(
                        @RequestParam(name = "type", defaultValue = "PROJECT") NewsType type,
                        @RequestParam(name = "page", defaultValue = "1") int page,
                        Model model) {

                int pageSize = 3;
                Pageable pageable = PageRequest.of(page - 1, pageSize);

                Page<News> allNews = newsService.getAllByType(type, pageable);

                model.addAttribute("newsList", allNews);
                model.addAttribute("currentType", type.name());

            model.addAttribute("newsListPaged", allNews);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", allNews.getTotalPages());
            model.addAttribute("newsTypeList", NewsType.getAllNewsTypes());

                return "clients/news/news";
        }

        @GetMapping("/news-details/{newsId}")
        public String viewNewsDetails(Model model, @PathVariable long newsId) {
                News news = newsService.getById(newsId);

                List<News> relatedNews = newsService.getAllByType(news.getType(), PageRequest.of(0, 2)).stream()
                                .toList();

            model.addAttribute("news", news);
            model.addAttribute("relatedNews", relatedNews);
            model.addAttribute("newsType", NewsType.getAllNewsTypes());

                return "clients/news/news-details";
        }

        @GetMapping({ "/careers", "/careers/job-opportunities" })
        public String viewJobOpportunities(Model model,
                        @RequestParam(name = "page", defaultValue = "1") int page) {

                int pageSize = 9;
                Pageable pageable = PageRequest.of(page - 1, pageSize);

                Page<CareerRecruitment> careerRecruitments = careerRecruitmentService.getAll(pageable);

                model.addAttribute("careerRecruitments", careerRecruitments);
                model.addAttribute("currentPage", page);
                model.addAttribute("totalPages", careerRecruitments.getTotalPages());
                return "clients/careers/job-opportunities";
        }

        @GetMapping("/careers/hr-policies")
        public String viewHrPolicies() {
                return "clients/careers/hr-policies";
        }
}