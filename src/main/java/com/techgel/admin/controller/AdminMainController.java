package com.techgel.admin.controller;

import com.techgel.common.dto.EProfileDTO;
import com.techgel.common.dto.HomeNavigationDTO;
import com.techgel.common.entity.adminSettings.EProfile;
import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.entity.adminSettings.SEO;
import com.techgel.common.service.EProfileService;
import com.techgel.common.service.HomeNavigationService;
import com.techgel.common.service.SEOService;
import com.techgel.common.utils.SlugUtils;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/webadmin")
public class AdminMainController {
    final HomeNavigationService homeNavigationService;
    final SEOService seoService;
    final EProfileService eProfileService;

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
        SEO seo = seoService.getById(homeNavigation.getSeo().getId());
        HomeNavigationDTO homeNavigationDTO = new HomeNavigationDTO(homeNavigation, seo);

        model.addAttribute("homeNavigationDTO", homeNavigationDTO);
        model.addAttribute("homeNavigation", homeNavigation);
        model.addAttribute("SEO", seo);
        return "admin/home/navigation_edit";
    }

    @PostMapping("/home/navigation/edit")
    public String saveHomeNavigationEdit(RedirectAttributes redirectAttributes, @RequestParam String action,
                                         @Valid HomeNavigationDTO homeNavigationDTO, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), error.getDefaultMessage());
            });
            System.out.println(result.getFieldErrors());

            redirectAttributes.addFlashAttribute("errors", errors);
            redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
        }else{
            homeNavigationService.update(homeNavigationDTO.getHomeNavigation());

            if(homeNavigationDTO.getSeo().getSeo_slug_vi().trim().equals("")){
                homeNavigationDTO.getSeo().setSeo_slug_vi(SlugUtils.toSlug(homeNavigationDTO.getHomeNavigation().getTitle_vi()));
            }
            if(homeNavigationDTO.getSeo().getSeo_slug_en().trim().equals("")){
                homeNavigationDTO.getSeo().setSeo_slug_en(SlugUtils.toSlug(homeNavigationDTO.getHomeNavigation().getTitle_en()));
            }
            seoService.update(homeNavigationDTO.getSeo());
            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
        }

        if(action.equals("save")) return "redirect:/webadmin/home/navigation";
        return String.format("redirect:/webadmin/home/navigation/edit?id=%s", homeNavigationDTO.getHomeNavigation().getId());
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
        SEO seo = seoService.getById(eProfile.getSeo().getId());
        EProfileDTO eProfileDTO = new EProfileDTO(eProfile, seo);

        model.addAttribute("eProfileDTO", eProfileDTO);
        model.addAttribute("eProfile", eProfile);
        model.addAttribute("SEO", seo);
        return "admin/home/eprofile_edit";
    }

    @PostMapping("/home/e-profile/edit")
    public String saveEProfileEdit(RedirectAttributes redirectAttributes, @RequestParam String action,
                                        @RequestParam(name = "image") MultipartFile image,
                                         @RequestParam(name = "file") MultipartFile file,
                                         @Valid EProfileDTO eProfileDTO, BindingResult result){

        if(result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), error.getDefaultMessage());
            });
            redirectAttributes.addFlashAttribute("errors", errors);
            redirectAttributes.addFlashAttribute("message", "Xãy ra lỗi");
        }else{
            eProfileService.update(eProfileDTO.getEProfile());

            if(eProfileDTO.getSeo().getSeo_slug_vi().trim().equals("")){
                eProfileDTO.getSeo().setSeo_slug_vi(SlugUtils.toSlug(eProfileDTO.getEProfile().getTitle_vi()));
            }
            if(eProfileDTO.getSeo().getSeo_slug_en().trim().equals("")){
                eProfileDTO.getSeo().setSeo_slug_en(SlugUtils.toSlug(eProfileDTO.getEProfile().getTitle_en()));
            }
            seoService.update(eProfileDTO.getSeo());
            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
        }

        if(action.equals("save")) return "redirect:/webadmin/home/e-profile";
        return String.format("redirect:/webadmin/home/e-profile/edit?id=%s", eProfileDTO.getEProfile().getId());
    }
}
