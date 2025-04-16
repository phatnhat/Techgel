package com.techgel.client.settings;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class SettingsFilter implements Filter {
    private static final Set<String> NOT_ALLOWED_EXTENSIONS =
            new HashSet<>(Arrays.asList(".html", ".jsp", ".js", ".css", ".jpg", ".png", ".ico"));

//    private final HomeNavigationService homeNavigationService;
//    private final EProfileService eProfileService;

//    @Autowired(required = false)
//    public SettingsFilter(HomeNavigationService homeNavigationService, EProfileService eProfileService) {
//        this.homeNavigationService = homeNavigationService;
//        this.eProfileService = eProfileService;
//    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String url = servletRequest.getRequestURL().toString();

//        List<HomeNavigation> homeNavigations = homeNavigationService.getParents();
//        EProfile eProfile = eProfileService.getById(1L);
//
//        if(!hasNotAllowedExtension(url) && !hasNotAllowedPath(url)){
//            request.setAttribute("homeNavigations", homeNavigations);
//            request.setAttribute("eProfile", eProfile);
//        }else{
//            chain.doFilter(request, response);
//            return;
//        }

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
