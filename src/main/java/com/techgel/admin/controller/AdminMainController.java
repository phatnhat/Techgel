package com.techgel.admin.controller;

import com.techgel.admin.security.TechgelUserDetails;
import com.techgel.common.dto.HomeNavigationDTO;
import com.techgel.common.entity.Role;
import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.entity.adminSettings.SEO;
import com.techgel.common.service.HomeNavigationService;
import com.techgel.common.service.SEOService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/webadmin")
public class AdminMainController {
    final HomeNavigationService homeNavigationService;
    final SEOService seoService;

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
        SEO seo = seoService.getSEOByEntityType(homeNavigation.getSeo_keyword()) == null ? new SEO() : seoService.getSEOByEntityType(homeNavigation.getSeo_keyword());
        HomeNavigationDTO homeNavigationDTO = new HomeNavigationDTO(homeNavigation, seo);

        model.addAttribute("homeNavigationDTO", homeNavigationDTO);
//        model.addAttribute("homeNavigation", homeNavigation);
        model.addAttribute("SEO", seo);
        return "admin/home/navigation_edit";
    }

    @PostMapping("/home/navigation/edit")
    public String saveHomeNavigationEdit(HomeNavigation homeNavigation, SEO seo, @RequestParam String action){
        homeNavigationService.update(homeNavigation);
//        if(seoService.getSEOByEntityType(homeNavigation.getSeo_keyword()){}

        if(action.equals("save")){
            return "redirect:/webadmin/home/navigation";
        }
        return String.format("redirect:/webadmin/home/navigation/edit?id=%s", homeNavigation.getId());
    }
}
