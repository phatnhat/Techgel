package com.techgel.common.service.offline;

import com.techgel.StaticData.AboutUsIntroduceData;
import com.techgel.common.entity.adminSettings.AboutUsIntroduce;
import com.techgel.common.service.AboutUsIntroduceService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class AboutUsIntroduceOfflineService implements AboutUsIntroduceService {
    public List<AboutUsIntroduce> getAll(){
        return AboutUsIntroduceData.get();
    }

    public AboutUsIntroduce getById(Long id){
        return this.getAll().stream().filter(aboutUsIntroduce -> aboutUsIntroduce.getId().equals(id)).findFirst().orElse(null);
    }

    public AboutUsIntroduce update(AboutUsIntroduce aboutUsIntroduce){
        return null;
    }
}
