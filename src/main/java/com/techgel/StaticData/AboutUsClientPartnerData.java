package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.AboutUsClientPartner;
import com.techgel.common.entity.adminSettings.AboutUsClientPartnerItems;

import java.util.List;

public abstract class AboutUsClientPartnerData {
        public static List<AboutUsClientPartner> get() {
                return List.of(
                        new AboutUsClientPartner(1L, "Khách hàng & Đối tác", "Clients & Partners", "/imgs/banners/handshake.jpg")
                );
        }
}
