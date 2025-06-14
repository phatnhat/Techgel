package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.AttractTalent;
import com.techgel.common.entity.adminSettings.AttractTalentItems;

import java.util.List;

public abstract class AttractTalentItemsData {
    public static List<AttractTalentItems> get() {
        return List.of(
                new AttractTalentItems(1L, "Chính sách thăng tiến và luân chuyển nhân sự", "Promotion and job rotation policy",
                        "/imgs/small-icons/promotion.png",
                        "Cơ hội phát triển nghề nghiệp rõ ràng, luân chuyển linh hoạt theo năng lực và định hướng cá nhân.",
                        "Clear career development opportunities with flexible rotation based on individual competence and career orientation."),

                new AttractTalentItems(2L, "Chính sách đào tạo", "training policy",
                        "/imgs/small-icons/training.png",
                        "Đào tạo chuyên môn, kỹ năng mềm và công nghệ mới nhằm nâng cao năng lực toàn diện cho nhân viên.",
                        "Professional training, soft skills development, and new technology training to enhance employees’ comprehensive capabilities."),

                new AttractTalentItems(3L, "Chính sách lương - thưởng", "Salary and bonus policy",
                        "/imgs/small-icons/employee-benefit.png",
                        "Thu nhập hấp dẫn, thưởng theo hiệu suất và kết quả kinh doanh, đảm bảo công bằng và minh bạch.",
                        "Attractive income with performance-based and business results bonuses, ensuring fairness and transparency."),

                new AttractTalentItems(4L, "Hệ thống lương thưởng cạnh tranh", "Competitive salary and bonus system",
                        "/imgs/small-icons/income.png",
                        "Áp dụng khung lương thị trường, đánh giá định kỳ, khuyến khích cống hiến và phát triển lâu dài.",
                        "Apply market-based salary scales, conduct regular evaluations, and encourage long-term dedication and development."),

                new AttractTalentItems(5L, "Chính sách phúc lợi, đãi ngộ", "Welfare and benefits policy",
                        "/imgs/small-icons/incentive.png",
                        "Chế độ phúc lợi toàn diện: nghỉ lễ, du lịch, hiếu hỷ, sinh nhật, hỗ trợ học tập và gắn kết nội bộ.",
                        "Comprehensive benefits package: holidays, company trips, condolences and celebrations, birthdays, educational support, and team-building activities."),

                new AttractTalentItems(6L, "Chính sách bảo hiểm, sức khỏe", "Insurance and healthcare policy",
                        "/imgs/small-icons/life-insurance.png",
                        "Đầy đủ BHXH, BHYT, BHTN và bảo hiểm sức khỏe mở rộng, khám định kỳ, hỗ trợ chi phí y tế.",
                        "Full social insurance, health insurance, unemployment insurance, plus extended health insurance, regular health check-ups, and medical expense support.")
        );
    }
}
