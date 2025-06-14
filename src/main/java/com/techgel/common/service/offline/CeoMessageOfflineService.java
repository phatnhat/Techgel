package com.techgel.common.service.offline;

import com.techgel.StaticData.AboutUsClientPartnerData;
import com.techgel.StaticData.CeoMessageData;
import com.techgel.common.entity.adminSettings.AboutUsClientPartner;
import com.techgel.common.entity.adminSettings.CeoMessage;
import com.techgel.common.service.AboutUsClientPartnerService;
import com.techgel.common.service.CeoMessageService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
public class CeoMessageOfflineService implements CeoMessageService {

    public List<CeoMessage> getAll(){
        return CeoMessageData.get();
    }

    public CeoMessage getById(Long id){
        return this.getAll().stream().filter(ceoMessage -> ceoMessage.getId().equals(id)).findFirst().orElse(null);
    }

    public CeoMessage update(CeoMessage ceoMessage){
        return null;
    }

    public void deleteById(Long id){}
}
