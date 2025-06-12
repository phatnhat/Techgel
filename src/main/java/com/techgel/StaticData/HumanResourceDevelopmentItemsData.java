package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.HumanResourceDevelopment;
import com.techgel.common.entity.adminSettings.HumanResourceDevelopmentItems;

import java.util.List;

public abstract class HumanResourceDevelopmentItemsData {
    public static List<HumanResourceDevelopmentItems> get() {
        return List.of(
                new HumanResourceDevelopmentItems(1L, "/imgs/small-icons/rulers.png", 1,
                        "Hoạt động đào tạo vừa giúp CBNV đã được đào tạo áp dụng hiệu quả vào công việc thực tế, vừa giúp CBNV có thể xác định được lộ trình phát triển của bản thân phù hợp với mục tiêu phát triển của Công ty.",
                        "Training activities not only help trained staff effectively apply their knowledge to practical work but also enable employees to identify their personal development path aligned with the Company’s growth objectives."),

                new HumanResourceDevelopmentItems(2L, "/imgs/small-icons/good-feedback.png", 2,
                        "TECHGEL xây dựng một hệ thống đánh giá công việc công tâm, khách quan nhằm tạo điều kiện tối đa cho việc nâng cao hiệu suất làm việc và phát triển tài năng, nhân cách đối với các cá nhân được quy hoạch lên Quản lý cấp trung; Lãnh đạo kế thừa. Qua đó, nhằm tạo điều kiện để tất cả CBNV đều có cơ hội thăng tiến và phát triển sự nghiệp một cách bình đẳng tại Công ty.",
                        "TECHGEL has established a fair and objective performance evaluation system designed to maximize opportunities for improving work efficiency and developing both talent and character for individuals groomed for middle management and leadership succession. Through this system, all employees are provided equal opportunities for career advancement and professional growth within the Company."),

                new HumanResourceDevelopmentItems(3L, "/imgs/small-icons/labor.png", 3,
                        "Tất cả CBNV sau khi ký hợp đồng lao động có thời hạn với Công ty sẽ được tham dự các lớp đào tạo nghiệp vụ ngắn hạn, trung hạn theo kế hoạch đào tạo hàng năm hoặc đào tạo đột xuất theo yêu cầu cấp thiết của mỗi đơn vị.",
                        "All employees, after signing a fixed-term labor contract with the Company, will participate in short-term and medium-term professional training courses according to the annual training plan or urgent training as required by each department.")

        );
    }
}
