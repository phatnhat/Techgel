package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.AboutUsTestimonialItems;

import java.util.List;

public abstract class AboutUsTestimonialItemData {
    public static List<AboutUsTestimonialItems> get(){
        AboutUsTestimonialItems aboutUsTestimonialItems1 = new AboutUsTestimonialItems(1L,
                "Với mục đích để giảm bớt chi phí tiền điện cho doanh nghiệp, tự chủ được nguồn điện sử dụng. Tôi đã liên hệ hợp tác với Công ty  để triển khai dự án lắp đặt hệ thống điện mặt trời cho doanh nghiệp của tôi. Tôi rất hài lòng về sản phẩm và sự chuyên nghiệp trong cách làm việc của Techgel.",
                "We are very proud of Techgel on this project. During this difficult period, we all have great confidence in Coteccons’ ability to complete the project on time and meet our quality expectations. First of all, Techgel is the most prestigious contractor in Vietnam. We are very proud to have a partnership with Techgel on the Ho Tram project. This is a relationship that we have developed in the past and look forward to continuing in the future.",
                "Ông John", "Mr.John", "Giám đốc", "General Director",
                "/imgs/recommendations/mrtruyen.png",
                1);

        AboutUsTestimonialItems aboutUsTestimonialItems2 = new AboutUsTestimonialItems(1L,
                "Hệ thống ngay sau khi lắp đặt đã đi vào hoạt động ổn định. Dòng điện tổng hợp được từ ánh sáng mặt trời đã hòa vào lưới phục vụ nhu cầu sử dụng của gia đình tôi. Có những tấm pin, tôi cảm thấy nhà mát mẻ hơn do tác dụng chống nóng rất đặc biệt của nó.",
                "We are very proud of Techgel on this project. During this difficult period, we all have great confidence in Coteccons’ ability to complete the project on time and meet our quality expectations. First of all, Techgel is the most prestigious contractor in Vietnam. We are very proud to have a partnership with Techgel on the Ho Tram project. This is a relationship that we have developed in the past and look forward to continuing in the future.",
                "Ông Thế", "Mr.Thế", "Chủ tịch", "CEO",
                "/imgs/recommendations/mrthe.png",
                2);

        AboutUsTestimonialItems aboutUsTestimonialItems3 = new AboutUsTestimonialItems(1L,
                "Tôi có nhờ bên TECHGEL lắp đặt hệ thống cơ điện lạnh cho terminal T3 và tôi cảm thấy rất chất lượng. Đội ngũ làm việc cực kì năng động, chuyên nghiệp với quy trình rõ ràng và hiệu quả khiến cho việc khánh thành ngày 30/4 thuận lợi hơn bao giờ hết.",
                "We are very proud of Techgel on this project. During this difficult period, we all have great confidence in Coteccons’ ability to complete the project on time and meet our quality expectations. First of all, Techgel is the most prestigious contractor in Vietnam. We are very proud to have a partnership with Techgel on the Ho Tram project. This is a relationship that we have developed in the past and look forward to continuing in the future.",
                "Lê Mạnh Hùng", "Mr.Hùng", "Chủ tịch", "CEO",
                "/imgs/recommendations/lemanhhung.jpg",
                3);

        return List.of(aboutUsTestimonialItems1, aboutUsTestimonialItems2, aboutUsTestimonialItems3);
    }
}
