package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.Carousel;
import org.apache.commons.text.StringEscapeUtils;

import java.util.List;

public abstract class CarouselsData {
    public static List<Carousel> get(){
        Carousel carousel1 = new Carousel(1L, 1, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-1.jpg", StringEscapeUtils.unescapeHtml4("<div style=\"\"><pre style=\"font-size: 9.8pt;\"><font color=\"#ffffff\">&lt;h3&gt;NHÀ CHỜ T3 TÂN SƠN NHẤT&lt;/h3&gt;&lt;span&gt;Khánh thành: Ngày 30/04/2025.&lt;/span&gt;&lt;span&gt;Dịch vụ: MEP và Kiot checkin.&lt;/span&gt;</font></pre></div>"));
        Carousel carousel2 = new Carousel(2L, 2, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-soha.jpg", StringEscapeUtils.unescapeHtml4("<div style=\"\"><pre style=\"font-size: 9.8pt;\"><font color=\"#ffffff\">&lt;h3&gt;NHÀ CHỜ T3 TÂN SƠN NHẤT&lt;/h3&gt;&lt;span&gt;Khánh thành: Ngày 30/04/2025.&lt;/span&gt;&lt;span&gt;Dịch vụ: MEP và Kiot checkin.&lt;/span&gt;</font></pre></div>"));
        Carousel carousel3 = new Carousel(3L, 3, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-3.jpg", StringEscapeUtils.unescapeHtml4("<div style=\"\"><pre style=\"font-size: 9.8pt;\"><font color=\"#ffffff\">&lt;h3&gt;NHÀ CHỜ T3 TÂN SƠN NHẤT&lt;/h3&gt;&lt;span&gt;Khánh thành: Ngày 30/04/2025.&lt;/span&gt;&lt;span&gt;Dịch vụ: MEP và Kiot checkin.&lt;/span&gt;</font></pre></div>"));
        Carousel carousel4 = new Carousel(4L, 4, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-4.jpg", StringEscapeUtils.unescapeHtml4("<div style=\"\"><pre style=\"font-size: 9.8pt;\"><font color=\"#ffffff\">&lt;h3&gt;NHÀ CHỜ T3 TÂN SƠN NHẤT&lt;/h3&gt;&lt;span&gt;Khánh thành: Ngày 30/04/2025.&lt;/span&gt;&lt;span&gt;Dịch vụ: MEP và Kiot checkin.&lt;/span&gt;</font></pre></div>"));
        Carousel carousel5 = new Carousel(5L, 5, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-5.jpg", StringEscapeUtils.unescapeHtml4("<div style=\"\"><pre style=\"font-size: 9.8pt;\"><font color=\"#ffffff\">&lt;h3&gt;NHÀ CHỜ T3 TÂN SƠN NHẤT&lt;/h3&gt;&lt;span&gt;Khánh thành: Ngày 30/04/2025.&lt;/span&gt;&lt;span&gt;Dịch vụ: MEP và Kiot checkin.&lt;/span&gt;</font></pre></div>"));
        Carousel carousel6 = new Carousel(6L, 6, "/imgs/news/nha-ga-t3-tt/nha-ga-t3-tt-6.jpg", StringEscapeUtils.unescapeHtml4("<div style=\"\"><pre style=\"font-size: 9.8pt;\"><font color=\"#ffffff\">&lt;h3&gt;NHÀ CHỜ T3 TÂN SƠN NHẤT&lt;/h3&gt;&lt;span&gt;Khánh thành: Ngày 30/04/2025.&lt;/span&gt;&lt;span&gt;Dịch vụ: MEP và Kiot checkin.&lt;/span&gt;</font></pre></div>"));

        return List.of(carousel1, carousel2, carousel3, carousel4, carousel5, carousel6);
    }
}
