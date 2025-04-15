package com.techgel.admin.controller;

import com.techgel.common.entity.adminSettings.*;
import com.techgel.common.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/webadmin")
public class AdminMainController {
    private final HomeNavigationService homeNavigationService;
    private final EProfileService eProfileService;
    private final CarouselService carouselService;
    private final HomeAboutUsService homeAboutUsService;
    private final HomeStatisticService homeStatisticService;
    private final HomeStatisticItemsService homeStatisticItemsService;
    private final AboutUsIntroduceService aboutUsIntroduceService;
    private final AboutUsTestimonialService aboutUsTestimonialService;
    private final AboutUsTestimonialItemsService aboutUsTestimonialItemsService;
    private final AboutUsOrganizationalService aboutUsOrganizationalService;
    private final AboutUsOrganizationalChartItemsService aboutUsOrganizationalChartItemsService;
    private final AboutUsVMVItemService aboutUsVMVItemService;
    private final AboutUsLicenseCertificateService aboutUsLicenseCertificateService;
    private final AboutUsLicenseCertificateItemsService aboutUsLicenseCertificateItemsService;
    private final AboutUsClientPartnerService aboutUsClientPartnerService;
    private final AboutUsClientPartnerItemsService aboutClientPartnerItemsService;
    private final WhatWeDoServiceService whatWeDoServiceService;
    private final WhatWeDoOurBusinessLineService whatWeDoOurBusinessLineService;
    private final WhatWeDoServiceItemsService whatWeDoServiceItemsService;

    @GetMapping("")
    public String viewWebAdmin(){
        return "redirect:webadmin/home/navigation";
    }

    @GetMapping("/login")
    public String viewLoginPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken) return "admin/login";
        return "redirect:/webadmin";
    }

    @GetMapping("/home/navigation")
    public String homeNavigation(Model model){
        List<HomeNavigation> homeNavigations = homeNavigationService.getAllParents();
        model.addAttribute("homeNavigations", homeNavigations);

        return "admin/home/navigation";
    }

    @GetMapping("/home/navigation/edit")
    public String homeNavigationEdit(Model model, @RequestParam(name = "id") Long idNavigation){
        HomeNavigation homeNavigation = homeNavigationService.getById(idNavigation);

        model.addAttribute("homeNavigation", homeNavigation);
        return "admin/home/navigation_edit";
    }

    @PostMapping("/home/navigation/edit")
    public String saveHomeNavigationEdit(RedirectAttributes redirectAttributes, @RequestParam String action,
                                         @Valid HomeNavigation homeNavigation, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), error.getDefaultMessage());
            });
            System.out.println(result.getFieldErrors());

            redirectAttributes.addFlashAttribute("errors", errors);
            redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
        }else{
            homeNavigationService.update(homeNavigation);

            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
        }

        if(action.equals("save")) return "redirect:/webadmin/home/navigation";
        return String.format("redirect:/webadmin/home/navigation/edit?id=%s", homeNavigation.getId());
    }

    @GetMapping("/home/e-profile")
    public String homeEProfile(Model model){
        if(eProfileService.getAll().isEmpty()) model.addAttribute("eProfile", null);
        else{
            EProfile eProfile = eProfileService.getAll().get(0);
            model.addAttribute("eProfile", eProfile);
        }
        return "admin/home/eprofile";
    }

    @GetMapping("/home/e-profile/edit")
    public String homeEProfileEdit(Model model, @RequestParam(name = "id") Long idEProfile){
        EProfile eProfile = eProfileService.getById(idEProfile);

        model.addAttribute("eProfile", eProfile);
        return "admin/home/eprofile_edit";
    }

    @PostMapping("/home/e-profile/edit")
    public String saveEProfileEdit(RedirectAttributes redirectAttributes,
                                   @RequestParam String action,
                                    @RequestParam(name = "image-delete", required = false) boolean image_delete,
                                    @RequestParam(name = "file-delete", required = false) boolean file_delete,
                                    @Valid EProfile eProfile, BindingResult result){

        if(result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), error.getDefaultMessage());
            });
            redirectAttributes.addFlashAttribute("errors", errors);
            redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
        }else{
            if(image_delete) eProfile.setImage_url(null);
            if(file_delete) eProfile.setFile_url(null);

            eProfileService.update(eProfile);

            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
        }

        if(action.equals("save")) return "redirect:/webadmin/home/e-profile";
        return String.format("redirect:/webadmin/home/e-profile/edit?id=%s", eProfile.getId());
    }

    @GetMapping("/home/carousel")
    public String homeCarousel(Model model){
        List<Carousel> carousels = carouselService.getAll();
        model.addAttribute("carousels", carousels);
        return "admin/home/carousel";
    }

    @GetMapping("/home/carousel/create")
    public String homeCarouselCreate(Model model){
        model.addAttribute("carousel", new Carousel());
        return "admin/home/carousel_edit";
    }

    @GetMapping("/home/carousel/edit")
    public String homeCarouselEdit(Model model, @RequestParam Long id){
        try{
            Carousel carousel = carouselService.getById(id);
            if(carousel != null){
                model.addAttribute("carousel", carousel);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/home/carousel_edit";
    }

    @PostMapping("/home/carousel/edit")
    public String saveHomeCarousel(RedirectAttributes redirectAttributes,
                                   @RequestParam String action,
                                   @RequestParam(name = "image-delete", required = false) boolean image_delete,
                                   @Valid Carousel carousel,
                                   BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("errors", errors);
                redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
            }else {
                if(image_delete) carousel.setImage_url(null);
                carouselService.update(carousel);
                redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
            return "redirect:/webadmin/home/carousel";
        }

        if(action.equals("save")) return "redirect:/webadmin/home/carousel";
        return String.format("redirect:/webadmin/home/carousel/edit?id=%s", carousel.getId());
    }


    @GetMapping("/home/about-us")
    public String homeAboutUs(Model model){
        HomeAboutUs homeAboutUs;
        if(homeAboutUsService.getAll().isEmpty())
            homeAboutUs = homeAboutUsService.update(new HomeAboutUs("Về chúng tôi", "TECHGEL", "About Us", "TECHGEL"));
        else homeAboutUs = homeAboutUsService.getAll().get(0);

        model.addAttribute("homeAboutUs", homeAboutUs);

        return "admin/home/about-us";
    }

    @GetMapping("/home/about-us/edit")
    public String homeAboutUslEdit(Model model, @RequestParam Long id){
        try{
            HomeAboutUs homeAboutUs = homeAboutUsService.getById(id);
            if(homeAboutUs != null){
                model.addAttribute("homeAboutUs", homeAboutUs);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/home/about-us_edit";
    }

    @PostMapping("/home/about-us/edit")
    public String saveHomeAboutUs(RedirectAttributes redirectAttributes,
                                   @RequestParam String action,
                                   @RequestParam(name = "image-delete-1", required = false) boolean image_delete_1,
                                   @RequestParam(name = "image-delete-2", required = false) boolean image_delete_2,
                                   @RequestParam(name = "image-delete-3", required = false) boolean image_delete_3,
                                   @Valid HomeAboutUs homeAboutUs,
                                   BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("errors", errors);
                redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
            }else {
                if(image_delete_1) homeAboutUs.setImage_url_1(null);
                if(image_delete_2) homeAboutUs.setImage_url_2(null);
                if(image_delete_3) homeAboutUs.setImage_url_3(null);

                homeAboutUsService.update(homeAboutUs);
                redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errors", new HashMap<>(){{put("", "Có gì đó không đúng");}});
            redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
        }

        if(action.equals("save")) return "redirect:/webadmin/home/about-us";
        return String.format("redirect:/webadmin/home/about-us/edit?id=%s", homeAboutUs.getId());
    }

    @GetMapping("/home/statistic")
    public String homeStatistic(Model model){
        HomeStatistic homeStatistic;

        if(homeStatisticService.getAll().isEmpty())
            homeStatistic = homeStatisticService.update(new HomeStatistic("Doanh nghiệp xuất sắc", "Top 500 doanh nghiệp xuất sắc nhất", "Excellent enterprise", "Top 500 best enterprises"));
        else homeStatistic = homeStatisticService.getAll().get(0);

        List<HomeStatisticItems> homeStatisticItems = homeStatisticItemsService.getAll();

        model.addAttribute("homeStatistic", homeStatistic);
        model.addAttribute("homeStatisticItems", homeStatisticItems);

        return "admin/home/statistic";
    }

    @GetMapping("/home/statistic/edit")
    public String homeStatisticEdit(Model model, @RequestParam Long id){
        try{
            HomeStatistic homeStatistic = homeStatisticService.getById(id);
            if(homeStatistic != null){
                model.addAttribute("homeStatistic", homeStatistic);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/home/statistic_edit";
    }

    @PostMapping("/home/statistic/edit")
    public String saveStatistic(RedirectAttributes redirectAttributes,
                                  @RequestParam String action,
                                  @Valid HomeStatistic homeStatistic,
                                  BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("statistic_errors", errors);
                redirectAttributes.addFlashAttribute("statistic_message", "Xãy ra lỗi");
            }else {
                homeStatisticService.update(homeStatistic);
                redirectAttributes.addFlashAttribute("statistic_message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("statistic_errors", new HashMap<>(){{put("", "Có gì đó không đúng");}});
            redirectAttributes.addFlashAttribute("statistic_message", "Xãy ra lỗi");
        }

        if(action.equals("save")) return "redirect:/webadmin/home/statistic";
        return String.format("redirect:/webadmin/home/statistic/edit?id=%s", homeStatistic.getId());
    }

    @GetMapping("/home/statistic-items/create")
    public String homeStatisticItemCreate(Model model){
        HomeStatisticItems homeStatisticItems = new HomeStatisticItems();
        model.addAttribute("homeStatisticItems", homeStatisticItems);
        return "admin/home/statistic-items_edit";
    }

    @GetMapping("/home/statistic-items/edit")
    public String homeStatisticItemsEdit(Model model, @RequestParam Long id){
        try{
            HomeStatisticItems homeStatisticItems = homeStatisticItemsService.getById(id);
            if(homeStatisticItems != null){
                model.addAttribute("homeStatisticItems", homeStatisticItems);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/home/statistic-items_edit";
    }

    @PostMapping("/home/statistic-items/edit")
    public String saveStatisticItems(RedirectAttributes redirectAttributes,
                                @RequestParam String action,
                                @Valid HomeStatisticItems homeStatisticItems,
                                BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("statistic_items_errors", errors);
                redirectAttributes.addFlashAttribute("statistic_items_message", "Xãy ra lỗi");
            }else {
                homeStatisticItemsService.update(homeStatisticItems);
                redirectAttributes.addFlashAttribute("statistic_items_message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("statistic_items_errors", new HashMap<>(){{put("", "Có gì đó không đúng");}});
            redirectAttributes.addFlashAttribute("statistic_items_message", "Xãy ra lỗi");
        }

        if(action.equals("save")) return "redirect:/webadmin/home/statistic";
        return String.format("redirect:/webadmin/home/statistic-items/edit?id=%s", homeStatisticItems.getId());
    }

    @GetMapping("/about-us/overview/introduce")
    public String aboutUsOverviewIntroduce(Model model){
        AboutUsIntroduce aboutUsIntroduce;
        if(aboutUsIntroduceService.getAll().isEmpty())
            aboutUsIntroduce = aboutUsIntroduceService.update(new AboutUsIntroduce("Về chúng tôi", "TECHGEL", "About Us", "TECHGEL"));
        else aboutUsIntroduce = aboutUsIntroduceService.getAll().get(0);

        model.addAttribute("aboutUsIntroduce", aboutUsIntroduce);

        return "admin/about-us/introduce";
    }

    @GetMapping("/about-us/overview/introduce/edit")
    public String aboutUsOverviewIntroduceEdit(Model model, @RequestParam Long id){
        try{
            AboutUsIntroduce aboutUsIntroduce = aboutUsIntroduceService.getById(id);
            if(aboutUsIntroduce != null){
                model.addAttribute("aboutUsIntroduce", aboutUsIntroduce);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/about-us/introduce_edit";
    }

    @PostMapping("/about-us/overview/introduce/edit")
    public String saveAboutUsOverviewIntroduce(RedirectAttributes redirectAttributes,
                                  @RequestParam String action,
                                  @RequestParam(name = "image-delete", required = false) boolean image_delete,
                                  @Valid AboutUsIntroduce aboutUsIntroduce,
                                  BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("errors", errors);
                redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
            }else {
                if(image_delete) aboutUsIntroduce.setImage_url(null);

                aboutUsIntroduceService.update(aboutUsIntroduce);
                redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errors", new HashMap<>(){{put("", "Có gì đó không đúng");}});
            redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
        }

        if(action.equals("save")) return "redirect:/webadmin/about-us/overview/introduce";
        return String.format("redirect:/webadmin/about-us/overview/introduce/edit?id=%s", aboutUsIntroduce.getId());
    }

    @GetMapping("/about-us/overview/testimonial")
    public String aboutUsOverviewTestimonial(Model model){
        AboutUsTestimonial aboutUsTestimonial;

        if(aboutUsTestimonialService.getAll().isEmpty())
            aboutUsTestimonial = aboutUsTestimonialService.update(new AboutUsTestimonial("Khách hàng đã nói gì về chúng tôi?", "Cảm nhận khách hàng", "What do our customers say about us?", "Customer feedback"));
        else aboutUsTestimonial = aboutUsTestimonialService.getAll().get(0);

        List<AboutUsTestimonialItems> aboutUsTestimonialItems = aboutUsTestimonialItemsService.getAll();

        model.addAttribute("aboutUsTestimonial", aboutUsTestimonial);
        model.addAttribute("aboutUsTestimonialItems", aboutUsTestimonialItems);

        return "admin/about-us/testimonial";
    }

    @GetMapping("/about-us/overview/testimonial/edit")
    public String aboutUsOverviewTestimonialEdit(Model model, @RequestParam Long id){
        try{
            AboutUsTestimonial aboutUsTestimonial = aboutUsTestimonialService.getById(id);
            if(aboutUsTestimonial != null){
                model.addAttribute("aboutUsTestimonial", aboutUsTestimonial);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/about-us/testimonial_edit";
    }

    @PostMapping("/about-us/overview/testimonial/edit")
    public String saveAboutUsTestimonial(RedirectAttributes redirectAttributes,
                                @RequestParam String action,
                                @Valid AboutUsTestimonial aboutUsTestimonial,
                                BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("testimonial_errors", errors);
                redirectAttributes.addFlashAttribute("testimonial_message", "Xãy ra lỗi");
            }else {
                aboutUsTestimonialService.update(aboutUsTestimonial);
                redirectAttributes.addFlashAttribute("testimonial_message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("testimonial_errors", new HashMap<>(){{put("", "Có gì đó không đúng");}});
            redirectAttributes.addFlashAttribute("testimonial_message", "Xãy ra lỗi");
        }

        if(action.equals("save")) return "redirect:/webadmin/about-us/overview/testimonial";
        return String.format("redirect:/webadmin/about-us/overview/testimonial/edit?id=%s", aboutUsTestimonial.getId());
    }

    @GetMapping("/about-us/overview/testimonial-items/create")
    public String aboutUsOverviewItemCreate(Model model){
        AboutUsTestimonialItems aboutUsTestimonialItems = new AboutUsTestimonialItems();
        model.addAttribute("aboutUsTestimonialItems", aboutUsTestimonialItems);
        return "admin/about-us/testimonial-items_edit";
    }

    @GetMapping("/about-us/overview/testimonial-items/edit")
    public String aboutUsTestimonialItemsEdit(Model model, @RequestParam Long id){
        try{
            AboutUsTestimonialItems aboutUsTestimonialItems = aboutUsTestimonialItemsService.getById(id);
            if(aboutUsTestimonialItems != null){
                model.addAttribute("aboutUsTestimonialItems", aboutUsTestimonialItems);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/about-us/testimonial-items_edit";
    }

    @PostMapping("/about-us/overview/testimonial-items/edit")
    public String saveAboutUsTestimonialItems(RedirectAttributes redirectAttributes,
                                     @RequestParam String action,
                                     @RequestParam(name = "image-delete", required = false) boolean image_delete,
                                     @Valid AboutUsTestimonialItems aboutUsTestimonialItems,
                                     BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("testimonial_items_errors", errors);
                redirectAttributes.addFlashAttribute("testimonial_items_message", "Xãy ra lỗi");
            }else {
                if(image_delete) aboutUsTestimonialItems.setThumbnail_url(null);

                aboutUsTestimonialItemsService.update(aboutUsTestimonialItems);
                redirectAttributes.addFlashAttribute("testimonial_items_message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("testimonial_items_errors", new HashMap<>(){{put("", "Có gì đó không đúng");}});
            redirectAttributes.addFlashAttribute("testimonial_items_message", "Xãy ra lỗi");
        }

        if(action.equals("save")) return "redirect:/webadmin/about-us/overview/testimonial";
        return String.format("redirect:/webadmin/about-us/overview/testimonial-items/edit?id=%s", aboutUsTestimonialItems.getId());
    }


    @GetMapping("/about-us/organizational-chart")
    public String aboutUsOverviewOrganizationalChart(Model model){
        AboutUsOrganizationalChart aboutUsOrganizationalChart;

        if(aboutUsOrganizationalService.getAll().isEmpty())
            aboutUsOrganizationalChart = aboutUsOrganizationalService.update(new AboutUsOrganizationalChart("TECHGEL", "Sơ đồ tổ chức", "TECHGEL", "Organizational Chart"));
        else aboutUsOrganizationalChart = aboutUsOrganizationalService.getAll().get(0);

        List<AboutUsOrganizationalChartItems> aboutUsOrganizationalChartItems = aboutUsOrganizationalChartItemsService.getAll();

        model.addAttribute("aboutUsOrganizationalChart", aboutUsOrganizationalChart);
        model.addAttribute("aboutUsOrganizationalChartItems", aboutUsOrganizationalChartItems);

        return "admin/about-us/organizational-chart";
    }

    @GetMapping("/about-us/organizational-chart/edit")
    public String aboutUsOrganizationalChartEdit(Model model, @RequestParam Long id){
        try{
            AboutUsOrganizationalChart aboutUsOrganizationalChart = aboutUsOrganizationalService.getById(id);
            if(aboutUsOrganizationalChart != null){
                model.addAttribute("aboutUsOrganizationalChart", aboutUsOrganizationalChart);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/about-us/organizational-chart_edit";
    }

    @PostMapping("/about-us/organizational-chart/edit")
    public String aboutUsOrganizationalChartEdit(RedirectAttributes redirectAttributes,
                                         @RequestParam String action,
                                         @RequestParam(name = "file-delete", required = false) boolean file_delete,
                                         @Valid AboutUsOrganizationalChart aboutUsOrganizationalChart,
                                         BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("organizational_chart_errors", errors);
                redirectAttributes.addFlashAttribute("organizational_chart_message", "Xãy ra lỗi");
            }else {
                if(file_delete) aboutUsOrganizationalChart.setFile_url(null);
                aboutUsOrganizationalService.update(aboutUsOrganizationalChart);
                redirectAttributes.addFlashAttribute("organizational_chart_message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("organizational_chart_errors", new HashMap<>(){{put("", "Có gì đó không đúng");}});
            redirectAttributes.addFlashAttribute("organizational_chart_message", "Xãy ra lỗi");
        }

        if(action.equals("save")) return "redirect:/webadmin/about-us/organizational-chart";
        return String.format("redirect:/webadmin/about-us/organizational-chart/edit?id=%s", aboutUsOrganizationalChart.getId());
    }

    @GetMapping("/about-us/organizational-chart-items/create")
    public String aboutUsOrganizationalChartItemCreate(Model model){
        AboutUsOrganizationalChartItems aboutUsOrganizationalChartItems = new AboutUsOrganizationalChartItems();
        model.addAttribute("aboutUsOrganizationalChartItems", aboutUsOrganizationalChartItems);
        return "admin/about-us/organizational-chart-items_edit";
    }

    @GetMapping("/about-us/organizational-chart-items/edit")
    public String aboutUsOrganizationalChartItemsEdit(Model model, @RequestParam Long id){
        try{
            AboutUsOrganizationalChartItems aboutUsOrganizationalChartItems = aboutUsOrganizationalChartItemsService.getById(id);
            if(aboutUsOrganizationalChartItems != null){
                model.addAttribute("aboutUsOrganizationalChartItems", aboutUsOrganizationalChartItems);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/about-us/organizational-chart-items_edit";
    }

    @PostMapping("/about-us/organizational-chart-items/edit")
    public String saveAboutUsorganizationalChartItems(RedirectAttributes redirectAttributes,
                                              @RequestParam String action,
                                              @RequestParam(name = "image-delete", required = false) boolean image_delete,
                                              @Valid AboutUsOrganizationalChartItems aboutUsOrganizationalChartItems,
                                              BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("organizational_chart_items_errors", errors);
                redirectAttributes.addFlashAttribute("organizational_chart_items_message", "Xãy ra lỗi");
            }else {
                if(image_delete) aboutUsOrganizationalChartItems.setImage_url(null);

                aboutUsOrganizationalChartItemsService.update(aboutUsOrganizationalChartItems);
                redirectAttributes.addFlashAttribute("organizational_chart_items_message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("organizational_chart_items_errors", new HashMap<>(){{put("", "Có gì đó không đúng");}});
            redirectAttributes.addFlashAttribute("organizational_chart_items_message", "Xãy ra lỗi");
        }

        if(action.equals("save")) return "redirect:/webadmin/about-us/organizational-chart";
        return String.format("redirect:/webadmin/about-us/organizational-chart-items/edit?id=%s", aboutUsOrganizationalChartItems.getId());
    }

    @GetMapping("/about-us/vision-mission-values")
    public String aboutUsVisionMissionValues(Model model){
        if(aboutUsVMVItemService.getAll().isEmpty()) {
            aboutUsVMVItemService.update(new AboutUsVMVItems("Tầm nhìn", "Vision", "", "", 1, false, null));
            aboutUsVMVItemService.update(new AboutUsVMVItems("Sứ mệnh", "Mission", "", "", 2, false, null));
            aboutUsVMVItemService.update(new AboutUsVMVItems("Giá trị cốt lõi", "Values", "", "", 3, true, null));
        }

        List<AboutUsVMVItems> aboutUsVMVItems = aboutUsVMVItemService.getAll();

        model.addAttribute("aboutUsVMVItems", aboutUsVMVItems);

        return "admin/about-us/vision-mission-values";
    }

    @GetMapping("/about-us/licenses-certificates")
    public String aboutUsLicenseCertificate(Model model){
        List<AboutUsLicenseCertificate> aboutUsLicenseCertificates = aboutUsLicenseCertificateService.getAll();

        model.addAttribute("aboutUsLicenseCertificates", aboutUsLicenseCertificates);

        return "admin/about-us/license-certificate";
    }

    @GetMapping("/about-us/licenses-certificates/create")
    public String aboutUsLicensesCertificateSave(Model model){
        model.addAttribute("aboutUsLicenseCertificate", new AboutUsLicenseCertificate());
        return "admin/about-us/license-certificate_edit";
    }

    @GetMapping("/about-us/licenses-certificates/edit")
    public String aboutUsLicensesCertificateEdit(Model model, @RequestParam Long id){
        try{
            AboutUsLicenseCertificate aboutUsLicenseCertificate = aboutUsLicenseCertificateService.getById(id);
            if(aboutUsLicenseCertificate != null){
                model.addAttribute("aboutUsLicenseCertificate", aboutUsLicenseCertificate);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/about-us/license-certificate_edit";
    }

    @PostMapping("/about-us/licenses-certificates/edit")
    public String saveAboutUsLicensesCertificate(RedirectAttributes redirectAttributes,
                                   @RequestParam String action,
                                   @Valid AboutUsLicenseCertificate aboutUsLicenseCertificate,
                                   BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("errors", errors);
                redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
            }else {
                aboutUsLicenseCertificateService.update(aboutUsLicenseCertificate);
                redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
            return "redirect:/webadmin/about-us/licenses-certificates";
        }

        if(action.equals("save")) return "redirect:/webadmin/about-us/licenses-certificates";
        return String.format("redirect:/webadmin/about-us/licenses-certificates/edit?id=%s", aboutUsLicenseCertificate.getId());
    }

    @GetMapping("/about-us/licenses-certificates-items")
    public String aboutUsLicenseCertificateList(Model model, @RequestParam Long id){
        try{
            AboutUsLicenseCertificate aboutUsLicenseCertificate = aboutUsLicenseCertificateService.getById(id);
            if(aboutUsLicenseCertificate != null){
                List<AboutUsLicenseCertificateItems> aboutUsLicenseCertificateItems = aboutUsLicenseCertificateItemsService.getAllByAboutUsLicensesCertificateId(id);

                model.addAttribute("aboutUsLicenseCertificate", aboutUsLicenseCertificate);
                model.addAttribute("aboutUsLicenseCertificateItems", aboutUsLicenseCertificateItems);

                return "admin/about-us/license-certificate-items";
            }
        }catch (Exception e){
            return "redirect:/webadmin";
        }

        return "redirect:/webadmin/about-us/licenses-certificates";
    }

    @GetMapping("/about-us/licenses-certificates-items/create")
    public String aboutUsLicensesCertificateItemSave(Model model, @RequestParam Long parentId){
        AboutUsLicenseCertificate aboutUsLicenseCertificate = aboutUsLicenseCertificateService.getById(parentId);
        if(aboutUsLicenseCertificate != null){
            model.addAttribute("parentId", parentId);
            model.addAttribute("aboutUsLicenseCertificate", aboutUsLicenseCertificate);
            model.addAttribute("aboutUsLicenseCertificateItems", new AboutUsLicenseCertificateItems());
            return "admin/about-us/license-certificate-items_edit";
        }
        return "redirect:/about-us/licenses-certificates";
    }

    @GetMapping("/about-us/licenses-certificates-items/edit")
    public String aboutUsLicenseCertificateItemEdit(Model model, @RequestParam Long id, @RequestParam Long parentId){
        try{
            AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems = aboutUsLicenseCertificateItemsService.getByIdAndParentId(id, parentId);
            if(aboutUsLicenseCertificateItems != null){
                model.addAttribute("aboutUsLicenseCertificate", aboutUsLicenseCertificateService.getById(parentId));
                model.addAttribute("aboutUsLicenseCertificateItems", aboutUsLicenseCertificateItems);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/about-us/license-certificate-items_edit";
    }

    @PostMapping("/about-us/licenses-certificates-items/edit")
    public String saveAboutUsLicensesCertificateItem(RedirectAttributes redirectAttributes,
                                                 @RequestParam String action,
                                                 @RequestParam(name = "image-delete", required = false) boolean image_delete,
                                                 @Valid AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems,
                                                 BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("errors", errors);
                redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
            }else {
                if(image_delete) aboutUsLicenseCertificateItems.setImage_url(null);
                aboutUsLicenseCertificateItemsService.update(aboutUsLicenseCertificateItems);
                redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
            return "redirect:/webadmin/about-us/licenses-certificates-items";
        }

        if(action.equals("save")) return String.format("redirect:/webadmin/about-us/licenses-certificates-items?id=%s", aboutUsLicenseCertificateItems.getAboutUsLicenseCertificate().getId());
        return String.format("redirect:/webadmin/about-us/licenses-certificates-items/edit?parentId=%s&id=%s", aboutUsLicenseCertificateItems.getAboutUsLicenseCertificate().getId(), aboutUsLicenseCertificateItems.getId());
    }

    @GetMapping("/about-us/clients-partners")
    public String aboutUsClientPartner(Model model){
        List<AboutUsClientPartner> aboutUsClientPartners = aboutUsClientPartnerService.getAll();

        model.addAttribute("aboutUsClientPartners", aboutUsClientPartners);

        return "admin/about-us/client-partner";
    }

    @GetMapping("/about-us/clients-partners/create")
    public String aboutUsClientPartnerSave(Model model){
        model.addAttribute("aboutUsClientPartner", new AboutUsClientPartner());
        return "admin/about-us/client-partner_edit";
    }

    @GetMapping("/about-us/clients-partners/edit")
    public String aboutUsClientPartnerEdit(Model model, @RequestParam Long id){
        try{
            AboutUsClientPartner aboutUsClientPartner = aboutUsClientPartnerService.getById(id);
            if(aboutUsClientPartner != null){
                model.addAttribute("aboutUsClientPartner", aboutUsClientPartner);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/about-us/client-partner_edit";
    }

    @PostMapping("/about-us/clients-partners/edit")
    public String saveAboutUsClientPartner(RedirectAttributes redirectAttributes,
                                                 @RequestParam String action,
                                                 @Valid AboutUsClientPartner aboutUsClientPartner,
                                                 BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("errors", errors);
                redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
            }else {
                aboutUsClientPartnerService.update(aboutUsClientPartner);
                redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
            return "redirect:/webadmin/about-us/clients-partners";
        }

        if(action.equals("save")) return "redirect:/webadmin/about-us/clients-partners";
        return String.format("redirect:/webadmin/about-us/clients-partners/edit?id=%s", aboutUsClientPartner.getId());
    }

    @GetMapping("/about-us/clients-partners-items")
    public String aboutUsClientPartnerList(Model model, @RequestParam Long id){
        try{
            AboutUsClientPartner aboutUsClientPartner = aboutUsClientPartnerService.getById(id);
            if(aboutUsClientPartner != null){
                List<AboutUsClientPartnerItems> aboutUsClientPartnerItems = aboutClientPartnerItemsService.getAllByAboutUsLicensesCertificateId(id);

                model.addAttribute("aboutUsClientPartner", aboutUsClientPartner);
                model.addAttribute("aboutUsClientPartnerItems", aboutUsClientPartnerItems);

                return "admin/about-us/client-partner-items";
            }
        }catch (Exception e){
            return "redirect:/webadmin";
        }

        return "redirect:/webadmin/about-us/clients-partners";
    }

    @GetMapping("/about-us/clients-partners-items/create")
    public String aboutUsClientPartnerItemSave(Model model, @RequestParam Long parentId){
        AboutUsClientPartner aboutUsClientPartner = aboutUsClientPartnerService.getById(parentId);
        if(aboutUsClientPartner != null){
            model.addAttribute("parentId", parentId);
            model.addAttribute("aboutUsClientPartner", aboutUsClientPartner);
            model.addAttribute("aboutUsClientPartnerItems", new AboutUsClientPartnerItems());
            return "admin/about-us/client-partner-items_edit";
        }
        return "redirect:/about-us/clients-partners";
    }

    @GetMapping("/about-us/clients-partners-items/edit")
    public String aboutUsClientPartnerItemEdit(Model model, @RequestParam Long id, @RequestParam Long parentId){
        try{
            AboutUsClientPartnerItems aboutUsClientPartnerItems = aboutClientPartnerItemsService.getByIdAndParentId(id, parentId);
            if(aboutUsClientPartnerItems != null){
                model.addAttribute("aboutUsClientPartner", aboutUsClientPartnerService.getById(parentId));
                model.addAttribute("aboutUsClientPartnerItems", aboutUsClientPartnerItems);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/about-us/client-partner-items_edit";
    }

    @PostMapping("/about-us/clients-partners-items/edit")
    public String saveAboutUsClientPartnerItem(RedirectAttributes redirectAttributes,
                                                     @RequestParam String action,
                                                     @RequestParam(name = "image-delete", required = false) boolean image_delete,
                                                     @Valid AboutUsClientPartnerItems aboutUsClientPartnerItems,
                                                     BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("errors", errors);
                redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
            }else {
                if(image_delete) aboutUsClientPartnerItems.setImage_url(null);
                aboutClientPartnerItemsService.update(aboutUsClientPartnerItems);
                redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
            return "redirect:/webadmin/about-us/clients-partners-items";
        }

        if(action.equals("save")) return String.format("redirect:/webadmin/about-us/clients-partners-items?id=%s", aboutUsClientPartnerItems.getAboutUsClientPartner().getId());
        return String.format("redirect:/webadmin/about-us/clients-partners-items/edit?parentId=%s&id=%s", aboutUsClientPartnerItems.getAboutUsClientPartner().getId(), aboutUsClientPartnerItems.getId());
    }

    @GetMapping("/what-we-do/our-business-lines")
    public String whatWeDoOurBusinessLine(Model model){
        WhatWeDoOurBusinessLine whatWeDoOurBusinessLine;

        if(whatWeDoOurBusinessLineService.getAll().isEmpty())
            whatWeDoOurBusinessLine = whatWeDoOurBusinessLineService.update(new WhatWeDoOurBusinessLine("Lĩnh vực hoạt động", "TECHGEL hoạt động trong nhiều lĩnh vực khác nhau", "Our business lines", "TECHGEL operates in various fields"));
        else whatWeDoOurBusinessLine = whatWeDoOurBusinessLineService.getAll().get(0);

        List<WhatWeDoService> whatWeDoServices = whatWeDoServiceService.getAll();

        model.addAttribute("whatWeDoServices", whatWeDoServices);
        model.addAttribute("whatWeDoOurBusinessLine", whatWeDoOurBusinessLine);

        return "admin/what-we-do/our-business-line";
    }

    @GetMapping("/what-we-do/our-business-lines/edit")
    public String whatWeDoOurBusinessLineEdit(Model model, @RequestParam Long id) {
        try {
            WhatWeDoOurBusinessLine whatWeDoOurBusinessLine = whatWeDoOurBusinessLineService.getById(id);
            if (whatWeDoOurBusinessLine != null) {
                model.addAttribute("whatWeDoOurBusinessLine", whatWeDoOurBusinessLine);
            } else throw new Exception();
        } catch (Exception e) {
            return "redirect:/webadmin";
        }
        return "admin/what-we-do/our-business-line_edit";
    }

    @PostMapping("/what-we-do/our-business-lines/edit")
    public String saveWhatWeDoOurBusinessLine(RedirectAttributes redirectAttributes,
                                           @RequestParam String action,
                                           @Valid WhatWeDoOurBusinessLine whatWeDoOurBusinessLine,
                                           BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("ourBusiness_errors", errors);
                redirectAttributes.addFlashAttribute("ourBusiness_message", "Xãy ra lỗi");
            }else {
                whatWeDoOurBusinessLineService.update(whatWeDoOurBusinessLine);
                redirectAttributes.addFlashAttribute("ourBusiness_message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("ourBusiness_message", "Xãy ra lỗi");
            return "redirect:/webadmin/what-we-do/our-business-lines";
        }

        if(action.equals("save")) return "redirect:/webadmin/what-we-do/our-business-lines";
        return String.format("redirect:/webadmin/what-we-do/our-business-lines/edit?id=%s", whatWeDoOurBusinessLine.getId());
    }

    @GetMapping("/what-we-do/our-business-lines/service/create")
    public String whatWeDoOurBusinessLineServiceSave(Model model){
        model.addAttribute("whatWeDoService", new WhatWeDoService());
        return "admin/what-we-do/service_edit";
    }

    @GetMapping("/what-we-do/our-business-lines/service/edit")
    public String whatWeDoOurBusinessLineServiceEdit(Model model, @RequestParam Long id){
        try{
            WhatWeDoService whatWeDoService = whatWeDoServiceService.getById(id);
            if(whatWeDoService != null){
                model.addAttribute("whatWeDoService", whatWeDoService);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/what-we-do/service_edit";
    }

    @PostMapping("/what-we-do/our-business-lines/service/edit")
    public String saveWhatWeDoOurBusinessLineService(RedirectAttributes redirectAttributes,
                                           @RequestParam String action,
                                           @RequestParam(name = "image-delete", required = false) boolean image_delete,
                                           @RequestParam(name = "image-popup-delete", required = false) boolean image_popup_delete,
                                           @Valid WhatWeDoService whatWeDoService,
                                           BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("service_errors", errors);
                redirectAttributes.addFlashAttribute("service_message", "Xãy ra lỗi");
            }else {
                if(image_delete) whatWeDoService.setImage_url(null);
                if(image_popup_delete) whatWeDoService.setImage_popup_url(null);
                whatWeDoServiceService.update(whatWeDoService);
                redirectAttributes.addFlashAttribute("service_message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("service_message", "Xãy ra lỗi");
            return "redirect:/webadmin/what-we-do/our-business-lines";
        }

        if(action.equals("save")) return "redirect:/webadmin/what-we-do/our-business-lines";
        return String.format("redirect:/webadmin/what-we-do/our-business-lines/service/edit?id=%s", whatWeDoService.getId());
    }

    @GetMapping("/what-we-do/our-business-lines/service-items")
    public String whatWeDoOurBusinessLineServiceList(Model model, @RequestParam Long id){
        try{
            WhatWeDoService whatWeDoService = whatWeDoServiceService.getById(id);
            if(whatWeDoService != null){
                List<WhatWeDoServiceItems> whatWeDoServiceItems = whatWeDoServiceItemsService.getAllByWhatWeDoServiceId(id);

                model.addAttribute("whatWeDoService", whatWeDoService);
                model.addAttribute("whatWeDoServiceItems", whatWeDoServiceItems);

                return "admin/what-we-do/service-items";
            }
        }catch (Exception e){
            return "redirect:/webadmin";
        }

        return "redirect:/webadmin/what-we-do/our-business-lines";
    }

    @GetMapping("/what-we-do/our-business-lines/service-items/create")
    public String whatWeDoOurBusinessLineServiceItemSave(Model model, @RequestParam Long parentId){
        WhatWeDoService whatWeDoService = whatWeDoServiceService.getById(parentId);
        if(whatWeDoService != null){
            model.addAttribute("parentId", parentId);
            model.addAttribute("whatWeDoService", whatWeDoService);
            model.addAttribute("whatWeDoServiceItems", new WhatWeDoServiceItems());
            return "admin/what-we-do/service-items_edit";
        }
        return "redirect:/what-we-do/our-business-lines";
    }

    @PostMapping("/what-we-do/our-business-lines/service-items/edit")
    public String saveWhatWeDoServiceItem(RedirectAttributes redirectAttributes,
                                               @RequestParam String action,
                                               @Valid WhatWeDoServiceItems whatWeDoServiceItems,
                                               BindingResult result){

        try{
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
                });
                redirectAttributes.addFlashAttribute("errors", errors);
                redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
            }else {
                whatWeDoServiceItemsService.update(whatWeDoServiceItems);
                redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
            return "redirect:/webadmin/what-we-do/our-business-lines/service-items";
        }

        if(action.equals("save")) return String.format("redirect:/webadmin/what-we-do/our-business-lines/service-items?id=%s", whatWeDoServiceItems.getWhatWeDoService().getId());
        return String.format("redirect:/webadmin/what-we-do/our-business-lines/service-items/edit?parentId=%s&id=%s", whatWeDoServiceItems.getWhatWeDoService().getId(), whatWeDoServiceItems.getId());
    }

    @GetMapping("/what-we-do/our-business-lines/service-items/edit")
    public String WhatWeDoServiceItemEdit(Model model, @RequestParam Long id, @RequestParam Long parentId){
        try{
            WhatWeDoServiceItems whatWeDoServiceItems = whatWeDoServiceItemsService.getByIdAndParentId(id, parentId);
            if(whatWeDoServiceItems != null){
                model.addAttribute("whatWeDoService", whatWeDoServiceService.getById(parentId));
                model.addAttribute("whatWeDoServiceItems", whatWeDoServiceItems);
            }else throw new Exception();
        }catch(Exception e){
            return "redirect:/webadmin";
        }
        return "admin/what-we-do/service-items_edit";
    }


}
