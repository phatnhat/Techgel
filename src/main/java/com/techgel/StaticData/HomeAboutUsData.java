package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.HomeAboutUs;

import java.util.List;

public abstract class HomeAboutUsData {
    public static List<HomeAboutUs> get() {
        HomeAboutUs homeAboutUs1 = new HomeAboutUs(1L, "Về chúng tôi", "About us", "TECHGEL", "TECHGEL",
                "Công ty CP Kỹ thuật Công nghệ Sài Gòn (TECHGEL) là một trong những đơn vị hàng đầu tại Việt Nam trong lĩnh vực thiết kế, cung cấp và lắp đặt hệ thống điện, hàng không, công nghiệp, dân dụng, hạ tầng & công nghệ. Với hơn 25 năm kinh nghiệm, TECHGEL đã khẳng định được vị thế của mình trên thị trường và mang đến cho khách hàng những giải pháp toàn diện, tiên tiến, hiệu quả và bền vững, đạt tiêu chuẩn hàng đầu quốc tế & trong nước.",
                "Saigon Technology Engineering Joint Stock Company (TECHGEL) is one of Vietnam’s leading companies in the design, supply, and installation of electrical, aviation, industrial, civil, infrastructure, and technology systems. With over 25 years of experience, TECHGEL has established its position in the market, providing customers with comprehensive, advanced, efficient, and sustainable solutions that meet top international and domestic standards.",
                "/imgs/home/mer-adv.jpg", "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                "/imgs/news/tru-so-techgel/headquarter.webp");

        return List.of(homeAboutUs1);
    }
}
