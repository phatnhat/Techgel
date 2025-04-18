package com.techgel.common.service.offline;

import com.techgel.StaticData.HomeStatisticData;
import com.techgel.common.entity.adminSettings.HomeStatistic;
import com.techgel.common.service.HomeStatisticService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
public class HomeStatisticOfflineService implements HomeStatisticService {
    public List<HomeStatistic> getAll(){
        return HomeStatisticData.get();
    }

    public HomeStatistic getById(Long id){
        return this.getAll().stream().filter(homeStatistic -> homeStatistic.getId().equals(id)).findFirst().orElse(null);
    }

    public HomeStatistic update(HomeStatistic homeStatistic){
        return null;
    }
}
