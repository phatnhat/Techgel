package com.techgel.admin.controller;

import com.techgel.common.entity.adminSettings.*;
import com.techgel.common.service.*;
import com.techgel.common.utils.SlugUtils;
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

    @GetMapping("/clients-partners")
    public String viewClientsPartners(Model model){
        List<Carousel> carousels = carouselService.getAll();
        model.addAttribute("carousels", carousels);
        return "admin/clients-partners";
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

    @GetMapping("/about-us/introduce")
    public String aboutUsIntroduce(Model model){
        AboutUsIntroduce aboutUsIntroduce;
        if(aboutUsIntroduceService.getAll().isEmpty())
            aboutUsIntroduce = aboutUsIntroduceService.update(new AboutUsIntroduce("Về chúng tôi", "TECHGEL", "About Us", "TECHGEL"));
        else aboutUsIntroduce = aboutUsIntroduceService.getAll().get(0);

        model.addAttribute("aboutUsIntroduce", aboutUsIntroduce);

        return "admin/about-us/introduce";
    }
}
