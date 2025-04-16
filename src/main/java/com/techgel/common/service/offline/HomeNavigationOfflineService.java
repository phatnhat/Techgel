package com.techgel.common.service.offline;

import com.techgel.common.entity.adminSettings.HomeNavigation;
import com.techgel.common.service.HomeNavigationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeNavigationOfflineService implements HomeNavigationService {
    @Override
    public List<HomeNavigation> getAll() {
        List<Map<String, String>> navigations = new ArrayList<>();
        navigations.add(new HashMap<>(){{
            put("Trang chủ", "/");
        }});
        navigations.add(new HashMap<>(){{
            put("Về Techgel", "/about-us/overview");
        }});
        navigations.add(new HashMap<>(){{
            put("Năng lực thi công", "/what-we-do/our-business-lines");
        }});
        navigations.add(new HashMap<>(){{
            put("Dự án", "/projects");
        }});
        navigations.add(new HashMap<>(){{
            put("Tin tức", "/news");
        }});
        navigations.add(new HashMap<>(){{
            put("Tuyển dụng", "/careers/job-opportunities");
        }});
        navigations.add(new HashMap<>(){{
            put("Liên hệ", "/contact-us");
        }});

        return null;
    }

    @Override
    public List<HomeNavigation> getParents() {
        return null;
    }

    @Override
    public List<HomeNavigation> getAllParents() {
        return null;
    }

    @Override
    public HomeNavigation getById(Long id) {
        return null;
    }

    @Override
    public void update(HomeNavigation homeNavigation) {

    }
}
