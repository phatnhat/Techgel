package com.techgel.common.service.offline;

import com.techgel.StaticData.CoreValueItemsData;
import com.techgel.common.entity.adminSettings.CoreValueItems;
import com.techgel.common.service.CoreValueItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class CoreValueItemsOfflineService implements CoreValueItemsService {
    public List<CoreValueItems> getAll(){
        return CoreValueItemsData.get();
    }

    public CoreValueItems getById(Long id){
        return this.getAll().stream().filter(coreValueItem -> coreValueItem.getId().equals(id)).findFirst().orElse(null);
    }

    public CoreValueItems update(CoreValueItems coreValueItem){
        return null;
    }

    public void deleteById(Long id){}
}
