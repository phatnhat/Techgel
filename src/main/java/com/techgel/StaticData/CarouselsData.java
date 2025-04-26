package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.Carousel;
import org.apache.commons.text.StringEscapeUtils;

import java.util.List;

public abstract class CarouselsData {

        static String stringOne = "<div><h3>DỰ ÁN HỆ THỐNG CƠ ĐIỆN.</h3><span class=\"hide-on-mobile\">Khánh thành: 30/04/2025.</span><br class=\"hide-on-mobile\"><span class=\"hide-on-mobile\">Phạm vi công việc: MEP, Quầy làm thủ tục và các dịch vụ khác.</span><br class=\"hide-on-mobile\"><span class=\"hide-on-mobile\">Hình: Hình ảnh trong quá trình thi công.</span></div>";
        static String stringOneEn = "<div><h3>MEP System Project for Passenger Terminal T3.</h3><span class=\"hide-on-mobile\">Inauguration: 30/04/2025.</span><br class=\"hide-on-mobile\"><span class=\"hide-on-mobile\">Scope of Work: MEP, Check-in Counters, and other services.</span><br class=\"hide-on-mobile\"><span class=\"hide-on-mobile\">Image: Construction progress photos.</span></div>";

        static String stringTwo = "<div><h3>NHÀ GA HÀNH KHÁCH T3 TÂN SƠN NHẤT</h3><span class=\"hide-on-mobile\">Khánh thành: Ngày 30/04/2025.</span><br class=\"hide-on-mobile\"><span class=\"hide-on-mobile\">Dịch vụ: MEP và Quầy làm thủ tục.</span><span class=\"hide-on-mobile\">Hình: Nhà ga đón lượt khách đầu tiên.</span></div>";
        static String stringTwoEn = "<div><h3>TAN SON NHAT TERMINAL T3</h3><span class=\"hide-on-mobile\">Inauguration: April 30, 2025.</span><br class=\"hide-on-mobile\"><span class=\"hide-on-mobile\">Services: MEP and Check-in Counters.</span><br class=\"hide-on-mobile\"><span class=\"hide-on-mobile\">Image: The terminal welcomes its first passengers.</span></div>";

        static String stringThree = "<div><h3>NHÀ GA HÀNH KHÁCH T3 TÂN SƠN NHẤT</h3><span class=\"hide-on-mobile\">Khánh thành: Ngày 30/04/2025.</span><br class=\"hide-on-mobile\"><span class=\"hide-on-mobile\">Dịch vụ: MEP và Quầy làm thủ tục.</span><span class=\"hide-on-mobile\">Hình: Mô hình phác thảo kiến trúc 3D nhà ga.</span></div>";
        static String stringThreeEn = "<div><h3>TAN SON NHAT TERMINAL T3</h3><span class=\"hide-on-mobile\">Inauguration: April 30, 2025.</span><br class=\"hide-on-mobile\"><span class=\"hide-on-mobile\">Services: MEP and Check-in Counters.</span><br class=\"hide-on-mobile\"><span class=\"hide-on-mobile\">D architectural visualization of the completed Tan Son Nhat Terminal T3.</span></div>";

        static String stringFour = "<div><h3>SỰ TRỞ LẠI CỦA MỘT TECHGEL HOÀN TOÀN MỚI.</h3><span class=\"hide-on-mobile\">Sau nhiều biến cố, Techgel đang dần hồi phục với sự tham gia của các Cổ đông lớn trong lĩnh vực Hàng Không, Thương Mại, Công Nghiệp, Ngân Hàng và Chứng Khoán.</span class=\"hide-on-mobile\"><br class=\"hide-on-mobile\"><span class=\"hide-on-mobile\">Hình: Ảnh tòa nhà chính công ty.</span></div>";
        static String stringFourEn = "<div><h3>The Return of a Completely New Techgel.</h3><span class=\"hide-on-mobile\">After many challenges, Techgel is gradually recovering with the participation of major shareholders in Aviation, Commerce, Industry, Banking, and Securities sectors.</span class=\"hide-on-mobile\"><br class=\"hide-on-mobile\"><span class=\"hide-on-mobile\">Image: Photo of the company's main building.</span></div>";

        public static List<Carousel> get() {
                Carousel carousel1 = new Carousel(1L, 2, "/imgs/news/tru-so-techgel/headquarter.webp",
                                StringEscapeUtils.unescapeHtml4(stringFour),
                                StringEscapeUtils.unescapeHtml4(stringFourEn));
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
