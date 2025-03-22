package com.techgel.admin.controller;

import com.techgel.admin.security.TechgelUserDetails;
import com.techgel.common.entity.Role;
import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.service.HomeNavigationService;
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
@RequestMapping("/webadmin")
public class AdminMainController {
    @Autowired
    HomeNavigationService homeNavigationService;

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
        List<HomeNavigation> homeNavigations = homeNavigationService.getParents();
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
    public String saveHomeNavigationEdit(HomeNavigation homeNavigation){
        homeNavigationService.update(homeNavigation);
        return "admin/home/navigation";
    }
}
