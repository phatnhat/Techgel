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

        static String stringFour = "<div><h3>TOP 500 DOANH NGHIỆP LỚN NHẤT VIỆT NAM</h3><span class=\"hide-on-mobile\">TECHGEL đã trải qua hành trình phát triển mạnh mẽ, trở thành một công ty đa ngành nghề uy tín. Không chỉ chinh phục thị trường Việt Nam, chúng tôi còn mở rộng hoạt động sang các nước Đông Nam Á và châu Đại Dương, khẳng định năng lực và vị thế trên trường quốc tế.</span><br class=\"hide-on-mobile\"><span class=\"hide-on-mobile\">Sau một thời gian ngắn vắng bóng trên thị trường và đối diện với nhiều thông tin tiêu cực (Do biến động kinh tế - xã hội, suy thoái kinh tế sau covid - 19, các vấn đề nội bộ), hiện nay, TECHGEL đang từng bước trở lại và khắc phục dần những khó khăn trong vài năm qua với sự tham gia của các Cổ đông lớn mới trong lĩnh vực Hàng Không, Thương mại và Công nghiệp cùng với một số cổ đông lâu năm trong lĩnh vực Ngân hàng và Chứng khoán với sứ mệnh \"MAKE TECHGEL GREAT AGAIN\".</span></div>";
        static String stringFourEn = "<div><h3>TOP 500 LARGEST ENTERPRISES IN VIETNAM</h3><span class=\"hide-on-mobile\">TECHGEL has undergone a strong development journey, becoming a reputable multi-industry company. Not only conquering the Vietnamese market, we have also expanded operations to Southeast Asian countries and Oceania, affirming our capabilities and position on the international stage.</span><br class=\"hide-on-mobile\"><span class=\"hide-on-mobile\">After a short period of absence from the market and facing much negative publicity (due to socio-economic fluctuations, post-COVID-19 recession, internal issues), TECHGEL is now gradually returning and overcoming the difficulties of recent years with the participation of new major shareholders in the fields of Aviation, Commerce, and Industry, along with several long-time shareholders in Banking and Securities, under the mission \"MAKE TECHGEL GREAT AGAIN\".</span></div>";

        public static List<Carousel> get() {
                Carousel carousel1 = new Carousel(1L, 2, "/imgs/home/headquarter.jpg",
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

                return List.of(carousel1);
        }
}
