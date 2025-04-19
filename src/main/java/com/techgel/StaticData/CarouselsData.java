package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.Carousel;
import org.apache.commons.text.StringEscapeUtils;

import java.util.List;

public abstract class CarouselsData {
    public static List<Carousel> get() {
        Carousel carousel1 = new Carousel(1L, 1, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-1.jpg",
                StringEscapeUtils.unescapeHtml4(
                        "<div><h3>NHÀ CHỜ T3 TÂN SƠN NHẤT</h3><span>Khánh thành: Ngày 30/04/2025.</span><span>Dịch vụ: MEP và Kiot checkin.</span></div>"));
        Carousel carousel2 = new Carousel(2L, 2, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-soha.jpg",
                StringEscapeUtils.unescapeHtml4(
                        "<div><h3>NHÀ CHỜ T3 TÂN SƠN NHẤT</h3><span>Khánh thành: Ngày 30/04/2025.</span><span>Dịch vụ: MEP và Kiot checkin.</span></div>"));

        Carousel carousel3 = new Carousel(3L, 3, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-3.jpg",
                StringEscapeUtils.unescapeHtml4(
                        "<div><h3>NHÀ CHỜ T3 TÂN SƠN NHẤT</h3><span>Khánh thành: Ngày 30/04/2025.</span><span>Dịch vụ: MEP và Kiot checkin.</span></div>"));

        Carousel carousel4 = new Carousel(4L, 4, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-4.jpg",
                StringEscapeUtils.unescapeHtml4(
                        "<div><h3>NHÀ CHỜ T3 TÂN SƠN NHẤT</h3><span>Khánh thành: Ngày 30/04/2025.</span><span>Dịch vụ: MEP và Kiot checkin.</span></div>"));

        Carousel carousel5 = new Carousel(5L, 5, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-5.jpg",
                StringEscapeUtils.unescapeHtml4(
                        "<div><h3>NHÀ CHỜ T3 TÂN SƠN NHẤT</h3><span>Khánh thành: Ngày 30/04/2025.</span><span>Dịch vụ: MEP và Kiot checkin.</span></div>"));

        Carousel carousel6 = new Carousel(6L, 6, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-6.jpg",
                StringEscapeUtils.unescapeHtml4(
                        "<div><h3>NHÀ CHỜ T3 TÂN SƠN NHẤT</h3><span>Khánh thành: Ngày 30/04/2025.</span><span>Dịch vụ: MEP và Kiot checkin.</span></div>"));

        return List.of(carousel1, carousel2, carousel3, carousel4, carousel5, carousel6);
    }
}
