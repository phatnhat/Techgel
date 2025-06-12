package com.techgel.common.service.offline;

import com.techgel.StaticData.ContactUsData;
import com.techgel.StaticData.NewsData;
import com.techgel.common.entity.adminSettings.ContactUs;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.service.ContactUsService;
import com.techgel.common.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Profile("offline")
@RequiredArgsConstructor
public class ContactUsOfflineService implements ContactUsService {

    public ContactUs getById(Long id){
        return this.getAll().stream().filter(contactUs -> contactUs.getId()
                .equals(id)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Contact us not found"));
    }

    public List<ContactUs> getAll(){
        return ContactUsData.get();
    }

    public ContactUs update(ContactUs contactUs){
        return null;
    }
}
