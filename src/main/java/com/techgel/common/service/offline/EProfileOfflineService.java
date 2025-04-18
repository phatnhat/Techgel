package com.techgel.common.service.offline;

import com.techgel.StaticData.EProfileData;
import com.techgel.common.entity.adminSettings.EProfile;
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

    public EProfile getById(Long id){
        return EProfileData.get();
    }

    public List<EProfile> getAll(){
        return new ArrayList<>(){{
            add(EProfileData.get());
        }};
    }

    public void update(EProfile eProfile){}
}
