package com.techgel.common.service.offline;

import com.techgel.StaticData.AboutUsClientPartnerData;
import com.techgel.StaticData.AboutUsClientPartnerListData;
import com.techgel.common.entity.adminSettings.AboutUsClientPartner;
import com.techgel.common.entity.adminSettings.AboutUsClientPartnerList;
import com.techgel.common.service.AboutUsClientPartnerListService;
import com.techgel.common.service.AboutUsClientPartnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("offline")
public class AboutUsClientPartnerListOfflineService implements AboutUsClientPartnerListService {

    public List<AboutUsClientPartnerList> getAll(){
        return AboutUsClientPartnerListData.get();
    }

    public AboutUsClientPartnerList getById(Long id){
        return this.getAll().stream().filter(aboutUsClientPartnerList -> aboutUsClientPartnerList.getId().equals(id)).findFirst().orElse(null);
    }

    public AboutUsClientPartnerList update(AboutUsClientPartnerList aboutUsClientPartnerList){
        return null;
    }

    public void deleteById(Long id){}
}
