package com.techgel.common.service.offline;

import com.techgel.client.StaticData;
import com.techgel.common.entity.adminSettings.HomeStatisticItems;
import com.techgel.common.repository.HomeStatisticItemsRepository;
import com.techgel.common.service.HomeStatisticItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
public class HomeStatisticItemsOfflineService implements HomeStatisticItemsService {
    public List<HomeStatisticItems> getAll(){
        return StaticData.homeStatisticItemsData();
    }

    public HomeStatisticItems getById(Long id){
        return this.getAll().stream().filter(homeStatisticItems -> homeStatisticItems.getId().equals(id)).findFirst().orElse(null);
    }

    public HomeStatisticItems update(HomeStatisticItems homeStatisticItems){
        return null;
    }

    public void deleteById(Long id){}
}
