package com.techgel.client.controller;

import com.techgel.client.Utility;
import com.techgel.common.DTOs.SignatureProjectDTO;
import com.techgel.common.entity.adminSettings.*;
import com.techgel.common.entity.enums.MailType;
import com.techgel.common.entity.enums.NewsType;
import com.techgel.common.DTOs.LogoDTO;
import com.techgel.common.DTOs.NewsDTO;

import com.techgel.common.entity.enums.ProjectRegions;
import com.techgel.common.service.*;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.*;
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
        private final WhatWeDoOurBusinessLineService whatWeDoOurBusinessLineService;
        private final WhatWeDoServiceService whatWeDoServiceService;
        private final AboutUsIntroduceService aboutUsIntroduceService;
        private final EProfileService eProfileService;
        private final AboutUsTestimonialService aboutUsTestimonialService;
        private final AboutUsTestimonialItemsService aboutUsTestimonialItemsService;
        private final AboutUsOrganizationalService aboutUsOrganizationalService;
        private final AboutUsOrganizationalChartItemsService aboutUsOrganizationalChartItemsService;
        private final AboutUsLicenseCertificateService aboutUsLicenseCertificateService;
        private final AboutUsLicenseCertificateListService aboutUsLicenseCertificateListService;
        private final AboutUsClientPartnerService aboutUsClientPartnerService;
        private final AboutUsClientPartnerListService aboutUsClientPartnerListService;
        private final ProjectCategoryService projectCategoryService;
        private final ProjectService projectService;
        private final ProjectListService projectListService;
        private final NewsService newsService;
        private final NewsListService newsListService;
        private final CareerRecruitmentService careerRecruitmentService;
        private final CeoMessageService ceoMessageService;
        private final VisionMissionValueService visionMissionValueService;
        private final VisionMissionService visionMissionService;
        private final CoreValueService coreValueService;
        private final CoreValueItemsService coreValueItemsService;
        private final WhatWeDoSustainableDevelopmentService whatWeDoSustainableDevelopmentService;
        private final WhatWeDoSustainableDevelopmentItemsService whatWeDoSustainableDevelopmentItemsService;
        private final JobOpportunityService jobOpportunityService;
        private final HRPoliciesService hrPoliciesService;
        private final AttractTalentService attractTalentService;
        private final AttractTalentItemsService attractTalentItemsService;
        private final HumanResourceDevelopmentService humanResourceDevelopmentService;
        private final HumanResourceDevelopmentItemsService humanResourceDevelopmentItemsService;
        private final ContactUsService contactUsService;
        private final MailService mailService;


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
                CeoMessage ceoMessage = ceoMessageService.getById(1L);

                List<AboutUsClientPartnerList> aboutUsClientPartnerList = aboutUsClientPartnerListService.getAll();
                List<AboutUsClientPartnerItems> aboutUsClientPartnerItems = new ArrayList<AboutUsClientPartnerItems>();

                for (AboutUsClientPartnerList partnerCategory : aboutUsClientPartnerList) {
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
                model.addAttribute("aboutUsClientPartnerList", aboutUsClientPartnerList);
                model.addAttribute("ceoMessage", ceoMessage);

                // Get Featured projects
                List<ProjectList> featuredProjects = projectListService.getAllByFeaturedIsTrue();
                model.addAttribute("featuredProjects", featuredProjects);
                model.addAttribute("title", "Trang chủ - Techgel");

                return "clients/home/home";
        }

        @GetMapping("/profile")
        public String viewEProfile(Model model) {
                model.addAttribute("title", "Hồ sơ năng lực - Techgel");
                return "clients/profile";
        }

        @GetMapping({ "/about-us/overview" })
        public String viewIntroduce(Model model) {
                AboutUsIntroduce aboutUsIntroduce = aboutUsIntroduceService.getById(1L);
                EProfile eProfile = eProfileService.getById(1L);
                AboutUsTestimonial aboutUsTestimonial = aboutUsTestimonialService.getById(1L);
                List<AboutUsTestimonialItems> aboutUsTestimonialItems = aboutUsTestimonialItemsService.getAll();

                List<AboutUsClientPartnerList> aboutUsClientPartnerList = aboutUsClientPartnerListService.getAll();
                List<AboutUsClientPartnerItems> aboutUsClientPartnerItems = new ArrayList<AboutUsClientPartnerItems>();

                for (AboutUsClientPartnerList partnerCategory : aboutUsClientPartnerList) {
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
                Locale currentLocale = LocaleContextHolder.getLocale();
                String language = currentLocale.getLanguage();

                AboutUsOrganizationalChart aboutUsOrganizationalChart = aboutUsOrganizationalService.getById(1L);
                List<AboutUsOrganizationalChartItems> aboutUsOrganizationalChartItems = aboutUsOrganizationalChartItemsService.getAllByLang(language);

                model.addAttribute("aboutUsOrganizationalChart", aboutUsOrganizationalChart);
                model.addAttribute("aboutUsOrganizationalChartItems", aboutUsOrganizationalChartItems);
                model.addAttribute("title", "Sơ đồ tổ chức - Techgel");

                return "clients/about-us/organizational-chart";
        }

        @GetMapping({"/about-us", "/about-us/vision-mission-values"})
        public String viewVisionMissionValues(Model model) {
                VisionMissionValue visionMissionValue = visionMissionValueService.getById(1L);
                List<VisionMission> visionMissions = visionMissionService.getAll();
                CoreValue coreValue = coreValueService.getById(1L);
                List<CoreValueItems> coreValueItems = coreValueItemsService.getAll();

                model.addAttribute("title", "Tầm nhìn, sứ mệnh & giá trị cốt lõi - Techgel");
                model.addAttribute("visionMissionValue", visionMissionValue);
                model.addAttribute("visionMissions", visionMissions);
                model.addAttribute("coreValue", coreValue);
                model.addAttribute("coreValueItems", coreValueItems);

                return "clients/about-us/vision-mission-values";
        }

        @GetMapping("/about-us/licenses-certificates")
        public String viewLicensesCertificates(Model model) {
                AboutUsLicenseCertificate aboutUsLicenseCertificate = aboutUsLicenseCertificateService.getById(1L);
                List<AboutUsLicenseCertificateList> aboutUsLicenseCertificates = aboutUsLicenseCertificateListService.getAll();

                model.addAttribute("aboutUsLicenseCertificate", aboutUsLicenseCertificate);
                model.addAttribute("aboutUsLicenseCertificates", aboutUsLicenseCertificates);
                model.addAttribute("title", "Giấy phép & chứng chỉ - Techgel");

                return "clients/about-us/licenses-certificates";
        }

        @GetMapping("/about-us/clients-partners")
        public String viewClientsPartners(Model model) {
                AboutUsClientPartner aboutUsClientPartner = aboutUsClientPartnerService.getById(1L);
                List<AboutUsClientPartnerList> aboutUsClientPartnerList = aboutUsClientPartnerListService.getAll();

                model.addAttribute("aboutUsClientPartner", aboutUsClientPartner);
                model.addAttribute("aboutUsClientPartnerList", aboutUsClientPartnerList);
                model.addAttribute("title", "Đối tác khách hàng - Techgel");

                return "clients/about-us/clients-partners";
        }

        @GetMapping("/about-us/cultural-techgel")
        public String viewCulturalTechgel(@RequestParam(name = "type", defaultValue = "CULTURAL") NewsType type,
                                          @RequestParam(name = "page", defaultValue = "1") int page,
                                          Model model) {
                int pageSize = 3;
                Pageable pageable = PageRequest.of(page - 1, pageSize);

                Page<NewsList> allNews = newsListService.getAllByType(type, pageable);

                model.addAttribute("newsList", allNews);
                model.addAttribute("currentType", type.name());

                model.addAttribute("newsListPaged", allNews);
                model.addAttribute("currentPage", page);
                model.addAttribute("totalPages", allNews.getTotalPages());
                model.addAttribute("newsTypeList", NewsType.getCultural());
                model.addAttribute("title", "Văn hóa Techgel - Techgel");

                return "clients/about-us/cultural-techgel";
        }

        @GetMapping("/about-us/shareholder")
        public String viewShareholder(Model model) {
                model.addAttribute("title", "Quan hệ cổ đông - Techgel");
                return "clients/shareholder/shareholder";
        }

        @GetMapping({ "/projects", "/projects/{slug}" })
        public String viewProjects(Model model, @PathVariable(required = false) String slug,
                        @RequestParam(name = "years[]", required = false) List<Integer> years,
                        @RequestParam(name = "regions[]", required = false) List<String> regions) {

                Project project = projectService.getById(1L);
                List<ProjectCategory> projectCategories = projectCategoryService.getAll();
                List<ProjectList> projects = null;

                if (slug == null) {
                        projects = projectListService.getAll();
                } else if (slug.equals("featured")) {
                        projects = projectListService.getAllByFeaturedIsTrue();
                } else {
                        projects = projectListService.getAllByProjectCategorySlug(slug);
                }

                if (years != null) {
                        projects = projects.stream().filter(p -> p != null &&
                                        years.contains(p.getYear()))
                                        .collect(Collectors.toList());
                }
                if (regions != null) {
                        projects = projects.stream().filter(p -> p != null &&
                                        p.getRegion() != null &
                                                        regions.contains(p.getRegion()))
                                        .collect(Collectors.toList());
                }

                model.addAttribute("slug", slug);
                model.addAttribute("years_checked", years);
                model.addAttribute("regions_checked", regions);
                model.addAttribute("currentYear", Year.now().getValue());
                model.addAttribute("regions", ProjectRegions.values());
                model.addAttribute("projects", projects);
                model.addAttribute("project", project);
                model.addAttribute("projectCategories", projectCategories);
                model.addAttribute("title", "Dự án - Techgel");

                return "clients/projects/projects";
        }

        @GetMapping("/project_details/{projectId}")
        public String viewProjectDetails(Model model, @PathVariable Long projectId) {
                ProjectList project = projectListService.getById(projectId);

                model.addAttribute("project", project);
                model.addAttribute("title", project.getTitle_vi() + " - Techgel");

                return "clients/projects/project_details";
        }

        @GetMapping({ "/what-we-do", "/what-we-do/our-business-lines" })
        public String viewOurBusinessLines(Model model) {
                WhatWeDoOurBusinessLine whatWeDoOurBusinessLine = whatWeDoOurBusinessLineService.getById(1L);
                List<WhatWeDoService> whatWeDoServices = whatWeDoServiceService.getAll();

                model.addAttribute("whatWeDoOurBusinessLine", whatWeDoOurBusinessLine);
                model.addAttribute("whatWeDoServices", whatWeDoServices);
                model.addAttribute("title", "Lĩnh vực hoạt động - Techgel");
                return "clients/what-we-do/our-business-lines";
        }

        @GetMapping({ "/what-we-do/our-business-line-details" })
        public String viewOurBusinessLineDetails(Model model, @RequestParam Long id) {
                WhatWeDoService whatWeDoService = whatWeDoServiceService.getById(id);

                model.addAttribute("whatWeDoService", whatWeDoService);
                model.addAttribute("title", whatWeDoService.getTitle_vi() + " - Techgel");
                return "clients/what-we-do/our-business-line-details";
        }

        @GetMapping("/what-we-do/sustainable-development")
        public String viewSustainableDevelopment(Model model) {
                WhatWeDoSustainableDevelopment whatWeDoSustainableDevelopment = whatWeDoSustainableDevelopmentService.getById(1L);
                List<WhatWeDoSustainableDevelopmentItems> whatWeDoSustainableDevelopmentItems = whatWeDoSustainableDevelopmentItemsService.getAll();

                model.addAttribute("whatWeDoSustainableDevelopment", whatWeDoSustainableDevelopment);
                model.addAttribute("whatWeDoSustainableDevelopmentItems", whatWeDoSustainableDevelopmentItems);
                model.addAttribute("title", "Phát triển bền vững - Techgel");
                return "clients/what-we-do/sustainable-development";
        }

        @GetMapping("/what-we-do/gallery")
        public String viewConstructionGallery() {
                return "clients/what-we-do/construction-gallery";
        }

        @GetMapping("/contact-us")
        public String viewContactUs(Model model) {
                ContactUs contactUs = contactUsService.getById(1L);

                model.addAttribute("contactUs", contactUs);
                model.addAttribute("title", "Liên hệ - Techgel");
                return "clients/contact-us";
        }

        @GetMapping("/news")
        public String getNewsPage(
                        @RequestParam(name = "type", defaultValue = "PROJECT") NewsType type,
                        @RequestParam(name = "page", defaultValue = "1") int page,
                        Model model) {

                int pageSize = 3;
                Pageable pageable = PageRequest.of(page - 1, pageSize);

                Page<NewsList> allNews = newsListService.getAllByType(type, pageable);
                News news = newsService.getById(1L);

                model.addAttribute("newsList", allNews);
                model.addAttribute("news", news);
                model.addAttribute("currentType", type.name());

                model.addAttribute("newsListPaged", allNews);
                model.addAttribute("currentPage", page);
                model.addAttribute("totalPages", allNews.getTotalPages());
                model.addAttribute("newsTypeList", NewsType.getAllNewsTypes());
                model.addAttribute("title", type.getVietnameseName() + " - Techgel");

                return "clients/news/news";
        }

        @GetMapping("/news-details/{newsId}")
        public String viewNewsDetails(Model model, @PathVariable long newsId) {
                NewsList newsList = newsListService.getById(newsId);

                List<NewsList> relatedNews = newsListService.getAllByType(newsList.getType(), PageRequest.of(0, 2)).stream()
                                .toList();

            model.addAttribute("newsList", newsList);
            model.addAttribute("relatedNews", relatedNews);
            model.addAttribute("newsType", NewsType.getAllNewsTypes());
            model.addAttribute("title", newsList.getTitle_vi() + " - Techgel");

            return "clients/news/news-details";
        }

        @GetMapping({ "/careers", "/careers/job-opportunities" })
        public String viewJobOpportunities(Model model,
                        @RequestParam(name = "page", defaultValue = "1") int page) {

                JobOpportunity jobOpportunity = jobOpportunityService.getById(1L);

                int pageSize = 9;
                Pageable pageable = PageRequest.of(page - 1, pageSize);

                Page<CareerRecruitment> careerRecruitments = careerRecruitmentService.getAll(pageable);

                model.addAttribute("jobOpportunity", jobOpportunity);
                model.addAttribute("careerRecruitments", careerRecruitments);
                model.addAttribute("currentPage", page);
                model.addAttribute("totalPages", careerRecruitments.getTotalPages());
                model.addAttribute("title", "Cơ hội nghề nghiệp - Techgel");

                return "clients/careers/job-opportunities";
        }

        @GetMapping("/careers/hr-policies")
        public String viewHrPolicies(Model model) {
                HRPolicies hrPolicies = hrPoliciesService.getById(1L);
                AttractTalent attractTalent = attractTalentService.getById(1L);
                List<AttractTalentItems> attractTalentItemsList = attractTalentItemsService.getAll();
                HumanResourceDevelopment humanResourceDevelopment = humanResourceDevelopmentService.getById(1L);
                List<HumanResourceDevelopmentItems> humanResourceDevelopmentItemsList = humanResourceDevelopmentItemsService.getAll();

                model.addAttribute("hrPolicies", hrPolicies);
                model.addAttribute("attractTalent", attractTalent);
                model.addAttribute("attractTalentItemsList", attractTalentItemsList);
                model.addAttribute("humanResourceDevelopment", humanResourceDevelopment);
                model.addAttribute("humanResourceDevelopmentItemsList", humanResourceDevelopmentItemsList);
                model.addAttribute("title", "Chính sách nhân sự - Techgel");
                return "clients/careers/hr-policies";
        }

        public void sendContactEmail(String fullname, String phone, String fromEmail, String fromMessage) throws MessagingException, UnsupportedEncodingException {
                Mail mail = mailService.getByType(MailType.CONTACT);
                JavaMailSenderImpl mailSender = Utility.prepareMailSender(mail);

                String content = mail.getEmailContent();

                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

                helper.setFrom(mail.getFromEmail(), mail.getSenderName());
                helper.setTo(mail.getFromEmail());
                helper.setSubject("Liên hệ từ Website");

                content = content.replace("[[fullname]]", fullname).replace("[[phone]]", phone)
                        .replace("[[email]]", fromEmail).replace("[[message]]", fromMessage);

                helper.setText(content, true);
                mailSender.send(message);
        }

        @PostMapping("/contact-us")
        public String sendContactUs(String fullname, String phone, String email, String message, RedirectAttributes redirectAttributes) throws MessagingException, UnsupportedEncodingException {
                try{
                        sendContactEmail(fullname, phone, email, message);
                        redirectAttributes.addFlashAttribute("isSend", "success");
                }catch (Error error){
                        redirectAttributes.addFlashAttribute("isSend", "error");
                }
                return "redirect:/contact-us";
        }

        public void sendApplyJobEmail(String fullname, String phone, String fromEmail, String position, String fromMessage, MultipartFile cv) throws MessagingException, IOException {
                Mail mail = mailService.getByType(MailType.APPLY_JOB);
                JavaMailSenderImpl mailSender = Utility.prepareMailSender(mail);

                String content = mail.getEmailContent();

                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

                helper.setFrom(mail.getFromEmail(), mail.getSenderName());
                helper.setTo(mail.getFromEmail());
                helper.setSubject("Đơn ứng tuyển từ Website");
                helper.addAttachment(cv.getOriginalFilename(), new ByteArrayResource(cv.getBytes()));

                System.out.println(fromMessage);

                content = content.replace("[[fullname]]", fullname).replace("[[phone]]", phone)
                        .replace("[[email]]", fromEmail).replace("[[position]]", position).replace("[[message]]", fromMessage);

                System.out.println(content);

                helper.setText(content, true);
                mailSender.send(message);
        }

        @PostMapping("/apply-job")
        public String sendApplyJob(@RequestParam String fullname, @RequestParam String phone, @RequestParam String email,
                                   @RequestParam String position, @RequestParam(name = "message") String message, @RequestParam MultipartFile cv,
                                   RedirectAttributes redirectAttributes){
                try{
                        sendApplyJobEmail(fullname, phone, email, position, message, cv);
                        redirectAttributes.addFlashAttribute("isSend", "success");
                }catch (Error | MessagingException | IOException error){
                        redirectAttributes.addFlashAttribute("isSend", "error");
                }
                return "redirect:/careers/job-opportunities";
        }
}