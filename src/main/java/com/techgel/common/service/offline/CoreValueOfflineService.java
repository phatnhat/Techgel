package com.techgel.common.service.offline;

import com.techgel.StaticData.CoreValueData;
import com.techgel.common.entity.adminSettings.CoreValue;
import com.techgel.common.service.CoreValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class CoreValueOfflineService implements CoreValueService {
    public List<CoreValue> getAll(){
        return CoreValueData.get();
    }

    public CoreValue getById(Long id){
        return this.getAll().stream().filter(coreValue -> coreValue.getId().equals(id)).findFirst().orElse(null);
    }

    public CoreValue update(CoreValue coreValue){
        return null;
    }

    public void deleteById(Long id){}
}
