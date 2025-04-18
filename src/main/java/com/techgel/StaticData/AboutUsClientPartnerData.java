package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.AboutUsClientPartner;
import com.techgel.common.entity.adminSettings.AboutUsClientPartnerItems;

import java.util.List;

public abstract class AboutUsClientPartnerData {
    public static List<AboutUsClientPartner> get(){
        AboutUsClientPartner aboutUsClientPartner1 = new AboutUsClientPartner(1L, "Khách hàng", "Clients", 1);
        AboutUsClientPartner aboutUsClientPartner2 = new AboutUsClientPartner(2L, "Đối tác", "Partners", 2);

        List<AboutUsClientPartnerItems> aboutUsClientPartnerItems1 = List.of(
                new AboutUsClientPartnerItems(1L, "Lotte Mart", "Lotte Mart", "", "/imgs/logos/partnership-logos/lottemart-logo.png", 1, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(2L, "Bộ Ngoại Giao", "", "", "/imgs/logos/partnership-logos/bongoaigiao-logo.png", 2, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(3L, "Dwight School Hanoi", "", "", "/imgs/logos/partnership-logos/dwight-logo.png",
                        3, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(4L, "AEFE", "", "", "/imgs/logos/partnership-logos/aefe-logo.png", 4, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(5L, "The Sun Avenue", "", "", "/imgs/logos/partnership-logos/thesunavenue-logo.png", 5, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(6L, "Hoa Phat",  "", "", "/imgs/logos/partnership-logos/hoaphat-logo.png", 6, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(7L, "Kim Long Nam", "", "", "/imgs/logos/partnership-logos/kimlongnam-logo.png",
                        7, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(8L, "Hateco", "", "", "/imgs/logos/partnership-logos/hateco-logo.png", 8, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(9L, "BRG Group", "", "", "/imgs/logos/partnership-logos/brggroup-logo.png", 9, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(10L, "Gamuda", "", "", "/imgs/logos/partnership-logos/gamuda-logo.png",  10, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(11L, "Masterise Homes", "", "", "/imgs/logos/partnership-logos/masterisehomes-logo.png", 11, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(12L, "Hoa Lam", "", "", "/imgs/logos/partnership-logos/hoalam-logo.png", 12, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(13L, "Becamex", "", "", "/imgs/logos/partnership-logos/becamex-logo.png", 13, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(14L, "Crowne Plaza", "", "", "/imgs/logos/partnership-logos/crowne-logo.png", 14, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(15L, "Constrexim", "", "", "/imgs/logos/partnership-logos/constrexim.png", 15, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(16L, "Kenton Node", "", "", "/imgs/logos/partnership-logos/kentonnode-logo.png", 16, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(17L, "Pearl", "", "", "/imgs/logos/partnership-logos/pearl-logo.png", 17, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(18L, "Novaland", "", "", "/imgs/logos/partnership-logos/novaland-logo.png", 18, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(19L, "Sojo", "", "", "/imgs/logos/partnership-logos/sojo-logo.png", 19, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(20L, "JW Marriott", "", "", "/imgs/logos/partnership-logos/jwmarriot-logo.png", 20, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(21L, "BB Group", "", "", "/imgs/logos/partnership-logos/bbgroup-logo.png", 21, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(22L, "APEC Mandala Vietnam", "", "", "/imgs/logos/partnership-logos/apecmandalavietnam-logo.png", 22, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(23L, "Palm Garden Resort", "", "", "/imgs/logos/partnership-logos/palmgardenresort-logo.png", 23, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(24L, "Flamingo", "", "", "/imgs/logos/partnership-logos/flamingo-logo.png", 24, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(25L, "SSSG", "", "", "/imgs/logos/partnership-logos/sssg-logo.png", 25, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(26L, "Vinataba", "", "", "/imgs/logos/partnership-logos/vinataba-logo.png", 26, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(27L, "Deltech", "", "", "/imgs/logos/partnership-logos/deltech-logo.png", 27, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(28L, "Schneider", "", "", "/imgs/logos/partnership-logos/schneider-logo.png", 28, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(29L, "TTI", "", "", "/imgs/logos/partnership-logos/tti-logo.png", 29, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(30L, "Metawater", "","", "/imgs/logos/partnership-logos/metawater-logo.png",30, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(31L, "Black & Veatch", "", "", "/imgs/logos/partnership-logos/black&veatch-logo.png", 31, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(32L, "EVN", "", "", "/imgs/logos/partnership-logos/evn-logo.png", 32, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(33L, "Nexif", "", "", "/imgs/logos/partnership-logos/nexif-logo.png", 33, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(34L, "Pacific", "", "", "/imgs/logos/partnership-logos/pacific-logo.png", 34, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(35L, "VATM", "", "", "/imgs/logos/partnership-logos/vatm-logo.png", 35, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(36L, "AHT", "", "", "/imgs/logos/partnership-logos/aht-logo.png", 36, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(37L, "Vingroup", "", "", "/imgs/logos/partnership-logos/vingroup-logo.png", 37, aboutUsClientPartner1),
                new AboutUsClientPartnerItems(38L, "Coca-Cola", "", "", "/imgs/logos/partnership-logos/cocacola-logo.webp",43, aboutUsClientPartner1)
        );

        List<AboutUsClientPartnerItems> aboutUsClientPartnerItems2 = List.of(
                new AboutUsClientPartnerItems(1L, "GB Industrial", "", "", "/imgs/logos/partnership-logos/gbindustrial-logo.png",
                        1, aboutUsClientPartner2),
                new AboutUsClientPartnerItems(2L, "Incotec", "", "", "/imgs/logos/partnership-logos/incotec-logo.png",
                        2, aboutUsClientPartner2),
                new AboutUsClientPartnerItems(3L, "Viet Thai", "", "", "/imgs/logos/partnership-logos/vietthai-logo.png",
                        3, aboutUsClientPartner2),
                new AboutUsClientPartnerItems(4L, "DVT", "", "", "/imgs/logos/partnership-logos/dvt-logo.png",
                        4, aboutUsClientPartner2),
                new AboutUsClientPartnerItems(5L, "PNP", "", "", "/imgs/logos/partnership-logos/pnp-logo.png", 5, aboutUsClientPartner2));

        aboutUsClientPartner1.setAboutUsClientPartnerItems(aboutUsClientPartnerItems1);
        aboutUsClientPartner2.setAboutUsClientPartnerItems(aboutUsClientPartnerItems2);

        return List.of(aboutUsClientPartner1, aboutUsClientPartner2);
    }
}
