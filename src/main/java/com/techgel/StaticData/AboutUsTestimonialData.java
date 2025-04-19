package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.AboutUsTestimonial;

import java.util.List;

public abstract class AboutUsTestimonialData {
    public static List<AboutUsTestimonial> get(){
        AboutUsTestimonial aboutUsTestimonial = new AboutUsTestimonial(1L, "Khách hàng đã nói gì về chúng tôi?", "What do our customers say about us?", "CẢM NHẬN KHÁCH HÀNG", "CUSTOMER FEEDBACK");
        return List.of(aboutUsTestimonial);
    }
}
