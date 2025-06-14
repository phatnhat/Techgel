package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.CoreValue;
import com.techgel.common.entity.adminSettings.CoreValueItems;

import java.util.List;

public class CoreValueItemsData {
    public static List<CoreValueItems> get(){
        return List.of(
                new CoreValueItems(1L, "Chất lượng hàng đầu", "Top quality", 1,
                        "Techgel luôn đặt chất lượng sản phẩm và dịch vụ lên hàng đầu, cam kết cung cấp các sản phẩm chính hãng, chất lượng cao, có nguồn gốc xuất xứ rõ ràng và dịch vụ tận tình, chu đáo.",
                        "Techgel always prioritizes product and service quality, committing to provide genuine, high-quality products with clear origin and attentive, dedicated customer service.", "/imgs/badge.png"),

                new CoreValueItems(2L, "Uy tín và trách nhiệm", "Reputation and Responsibility", 2,
                        "Techgel xây dựng uy tín dựa trên sự trung thực, minh bạch và trách nhiệm trong mọi hoạt động kinh doanh.",
                        "Techgel builds its reputation on honesty, transparency, and responsibility in all business activities.", "/imgs/responsibility.png"),

                new CoreValueItems(3L, "Sáng tạo và đổi mới", "Creativity and Innovation", 3,
                        "Techgel không ngừng tìm kiếm, nghiên cứu và áp dụng những công nghệ mới nhất để mang đến cho khách hàng những giải pháp tối ưu và hiệu quả nhất.",
                        "Techgel continuously seeks, researches, and applies the latest technologies to deliver the most optimal and effective solutions to its customers.", "/imgs/creativity.png"),

                new CoreValueItems(4L, "Phát triển bền vững", "Sustainable Development", 4,
                        "Techgel luôn hướng đến sự phát triển bền vững, không chỉ cho doanh nghiệp mà còn cho cả cộng đồng và xã hội.",
                        "Techgel continuously seeks, researches, and applies the latest technologies to deliver the most optimal and efficient solutions to its customers.", "/imgs/sustainable-development.png"),

                new CoreValueItems(5L, "Tôn trọng và hợp tác", "Respect and Cooperation", 5,
                        "Techgel xây dựng mối quan hệ tốt đẹp với đối tác, khách hàng và đồng nghiệp dựa trên sự tôn trọng, tin cậy và hợp tác.",
                        "Techgel fosters strong relationships with partners, customers, and colleagues based on respect, trust, and cooperation.", "/imgs/trust.png")
        );
    }
}
