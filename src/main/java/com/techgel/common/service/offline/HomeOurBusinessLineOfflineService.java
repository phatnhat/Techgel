package com.techgel.common.service.offline;

import com.techgel.StaticData.HomeOurBusinessLineData;
import com.techgel.common.entity.adminSettings.HomeOurBusinessLine;
import com.techgel.common.service.HomeOurBusinessLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class HomeOurBusinessLineOfflineService implements HomeOurBusinessLineService {
    public List<HomeOurBusinessLine> getAll(){
        return HomeOurBusinessLineData.get();
    }

    public HomeOurBusinessLine getById(Long id){
        return this.getAll().stream().filter(homeOurBusinessLine -> homeOurBusinessLine.getId().equals(id)).findFirst().orElse(null);
    }

    public HomeOurBusinessLine update(HomeOurBusinessLine homeOurBusinessLine){
        return null;
    }
}
