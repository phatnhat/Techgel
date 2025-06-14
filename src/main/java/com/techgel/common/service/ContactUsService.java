package com.techgel.common.service;

import com.techgel.common.entity.adminSettings.ContactUs;
import com.techgel.common.entity.adminSettings.News;

import java.util.List;

public interface ContactUsService {
    ContactUs getById(Long id);
    List<ContactUs> getAll();
    ContactUs update(ContactUs contactUs);
}
