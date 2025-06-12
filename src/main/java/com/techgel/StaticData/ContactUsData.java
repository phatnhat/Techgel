package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.ContactUs;

import java.util.List;

public abstract class ContactUsData {
    public static List<ContactUs> get() {
        return List.of(
                new ContactUs(1L, "Liên hệ", "Contact us", "/imgs/banners/contact-us.jpg")
        );
    }
}
