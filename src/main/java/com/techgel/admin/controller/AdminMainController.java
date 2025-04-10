package com.techgel.admin.controller;

import com.techgel.common.entity.adminSettings.Carousel;
import com.techgel.common.entity.adminSettings.EProfile;
import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.service.CarouselService;
import com.techgel.common.service.EProfileService;
import com.techgel.common.service.HomeNavigationService;
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
}
