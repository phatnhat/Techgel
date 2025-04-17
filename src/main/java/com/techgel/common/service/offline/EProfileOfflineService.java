package com.techgel.common.service.offline;

import com.techgel.common.entity.adminSettings.EProfile;
import com.techgel.common.repository.EProfileRepository;
import com.techgel.common.service.EProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class EProfileOfflineService implements EProfileService {
    public EProfile init(){
        return new EProfile("Hồ sơ năng lực", "E-Profile", "/imgs/HSNL.png", true, "/files/TECHGEL-COMPANY-PROFILE-2025-02.pdf");
    }
    public EProfile getById(Long id){
        return init();
    }

    public List<EProfile> getAll(){
        return new ArrayList<>(){{
            add(init());
        }};
    }

    public void update(EProfile eProfile){}
}
