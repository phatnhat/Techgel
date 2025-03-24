package com.techgel.client.settings;

import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.service.HomeNavigationService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SettingsFilter implements Filter {
    private static final Set<String> NOT_ALLOWED_EXTENSIONS =
            new HashSet<>(Arrays.asList(".html", ".jsp", ".js", ".css", ".jpg", ".png", ".ico"));

    @Autowired
    HomeNavigationService homeNavigationService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String url = servletRequest.getRequestURL().toString();

        List<HomeNavigation> homeNavigations = homeNavigationService.getParents();

        if(!hasNotAllowedExtension(url) && !hasNotAllowedPath(url)){
            request.setAttribute("homeNavigations", homeNavigations);
        }else{
            chain.doFilter(request, response);
            return;
        }

        chain.doFilter(request, response);
    }

    private boolean hasNotAllowedExtension(String url) {
        try{
            String extension = url.substring(url.lastIndexOf('.')).toLowerCase();
            return NOT_ALLOWED_EXTENSIONS.contains(extension);
        }catch (Exception e){
            return false;
        }
    }

    private boolean hasNotAllowedPath(String url) {
        try{
            return url.contains("/webadmin");
        }catch (Exception e){
            return false;
        }
    }
}
