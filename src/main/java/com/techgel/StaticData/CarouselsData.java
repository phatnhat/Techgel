package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.Carousel;
import org.apache.commons.text.StringEscapeUtils;

import java.util.List;

public abstract class CarouselsData {

        static String stringOne = "<div><h3>NHÀ GA HÀNH KHÁCH T3 TÂN SƠN NHẤT</h3><span>Khánh thành: Ngày 30/04/2025.</span><br /><span>Dịch vụ: MEP và Quầy làm thủ tục.</span></br /><span>Hình: Hình ảnh thi công kết cấu phần thô.</span></div>";
        static String stringOneEn = "<div><h3>TAN SON NHAT TERMINAL T3</h3><span>Inauguration: April 30, 2025.</span><br /><span>Services: MEP and Check-in Counters.</span><br /><span>Image: Structural work under construction.</span></div>";

        static String stringTwo = "<div><h3>NHÀ GA HÀNH KHÁCH T3 TÂN SƠN NHẤT</h3><span>Khánh thành: Ngày 30/04/2025.</span><br /><span>Dịch vụ: MEP và Quầy làm thủ tục.</span></br /><span>Hình: Nhà ga đón lượt khách đầu tiên.</span></div>";
        static String stringTwoEn = "<div><h3>TAN SON NHAT TERMINAL T3</h3><span>Inauguration: April 30, 2025.</span><br /><span>Services: MEP and Check-in Counters.</span><br /><span>Image: The terminal welcomes its first passengers.</span></div>";

        static String stringThree = "<div><h3>NHÀ GA HÀNH KHÁCH T3 TÂN SƠN NHẤT</h3><span>Khánh thành: Ngày 30/04/2025.</span><br /><span>Dịch vụ: MEP và Quầy làm thủ tục.</span></br /><span>Hình: Mô hình phác thảo kiến trúc 3D nhà ga.</span></div>";
        static String stringThreeEn = "<div><h3>TAN SON NHAT TERMINAL T3</h3><span>Inauguration: April 30, 2025.</span><br /><span>Services: MEP and Check-in Counters.</span><br /><span>D architectural visualization of the completed Tan Son Nhat Terminal T3.</span></div>";

        public static List<Carousel> get() {
                Carousel carousel1 = new Carousel(1L, 1, "/imgs/news/nha-ga-t3-tt/thi-cong-t3.jpg",
                                StringEscapeUtils.unescapeHtml4(
                                                "<div><h3>NHÀ GA HÀNH KHÁCH T3 TÂN SƠN NHẤT</h3><span>Khánh thành: Ngày 30/04/2025.</span><br /><span>Phạm vi Công việc: MEP và Quầy làm thủ tục.</span><br /><span>Hình: Nhà ga hành khách trong quá trình thi công.</span></div>"),
                                StringEscapeUtils.unescapeHtml4(
                                                "<div><h3>TAN SON NHAT TERMINAL T3</h3><span>Inauguration: April 30, 2025.</span><br /><span>Scope of Work: MEP and Check-in Counters.</span><br /><span>Image: Passenger terminal during construction.</span></div>"));
                Carousel carousel2 = new Carousel(2L, 2, "/imgs/news/nha-ga-t3-tt/cong-truong-nha-ga.webp",
                                StringEscapeUtils.unescapeHtml4(stringOne),
                                StringEscapeUtils.unescapeHtml4(stringOneEn));

                Carousel carousel3 = new Carousel(3L, 3, "/imgs/news/nha-ga-t3-tt/thuong-mai-dau-tien.jpg",
                                StringEscapeUtils.unescapeHtml4(stringTwo),
                                StringEscapeUtils.unescapeHtml4(stringTwoEn));

                Carousel carousel4 = new Carousel(4L, 4, "/imgs/news/nha-ga-t3-tt/mo-hinh-nha-ga.jpg",
                                StringEscapeUtils.unescapeHtml4(stringThree),
                                StringEscapeUtils.unescapeHtml4(stringThreeEn));

                return List.of(carousel1, carousel2, carousel3, carousel4);
        }
}
