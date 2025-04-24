package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.CareerRecruitment;
import com.techgel.common.entity.adminSettings.News;
import com.techgel.common.entity.enums.NewsType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public abstract class CareerRecruitmentData {
    public static List<CareerRecruitment> get() {
        return List.of(
                new CareerRecruitment(1L, "Nhân viên kiểm soát chi phí", "",
                        1, "Thỏa thuận thuận theo năng lực", "",
                        "Tốt nghiệp Đại học/Cao đẳng chuyên ngành Kế toán, Tài chính, Kinh tế Xây dựng.", "",
                        "Có ít nhất 2 năm kinh nghiệm trong vị trí kiểm soát chi phí, ưu tiên trong ngành xây dựng M&E.",
                        "",
                        "30 Phan Chu Trinh, phường 02, quận Bình Thạnh, Thành phố Hồ Chí Minh.", "",
                        new Date(),
                        "<p style= font-size: medium;\"><b>Quyền lợi:</b></p><p style= font-size: medium; margin-left: 1.5625rem;\">- Môi trường làm việc:</p><p style= font-size: medium; margin-left: 3.125rem;\">+ Cơ hội làm việc trong môi trường trẻ - năng động – thân thiện, chuyên nghiệp, hệ thống quy trình tác nghiệp rõ ràng, nhiều cơ hội thăng tiến theo năng lực.</p><p style= font-size: medium; margin-left: 3.125rem;\">+ Làm việc hoàn toàn dân chủ với những ý kiến đóng góp được trao đổi trực tiếp với ban lãnh đạo công ty.</p><p style= font-size: medium; margin-left: 1.5625rem;\">- Chế độ:</p><p style= font-size: medium; margin-left: 3.125rem;\">+ Lễ tết, Hiếu hỉ, sinh nhật, ốm đau, thai sản,…</p><p style= font-size: medium; margin-left: 3.125rem;\">+ Được hưởng đầy đủ quyền lợi theo quy định của Luật lao động: BHXH, BHYT,BHTN</p><p style=font-size: medium; margin-left: 3.125rem;\">+ Giờ làm việc : Theo giờ hành chính từ Thứ 2 – Sáng Thứ Bảy.</p><p style= font-size: medium;\"><b>Nội dung công việc:</b></p><p style= font-size: medium; margin-left: 1.5625rem;\">- Theo dõi và kiểm soát chi phí của các dự án M&amp;E, đảm bảo tuân thủ ngân sách đã duyệt.</p><p style= font-size: medium; margin-left: 1.5625rem;\">- Kiểm tra và xác minh tính hợp lệ của các hồ sơ thanh toán, hợp đồng với nhà thầu phụ, nhà cung cấp.</p><p style=font-size: medium; margin-left: 1.5625rem;\">- Phân tích, đánh giá các yếu tố tác động đến chi phí dự án, đề xuất phương án tối ưu hóa chi phí.</p><p style= font-size: medium; margin-left: 1.5625rem;\">- Theo dõi dòng tiền, công nợ phải trả, tiến độ thanh toán cho nhà cung cấp và thầu phụ.</p><p style= font-size: medium; margin-left: 1.5625rem;\">- Lập báo cáo chi phí định kỳ, so sánh chi phí thực tế với kế hoạch để cảnh báo rủi ro.</p><p style= font-size: medium; margin-left: 1.5625rem;\">- Phối hợp với phòng kế toán, phòng đấu thầu để kiểm tra và rà soát đơn giá, khối lượng nghiệm thu.</p><p style=\"font-size: medium; margin-left: 1.5625rem;\"> <br><div style=\"text-align: center;\" bis_skin_checked=\"1\"><span style=\"color: var(--black);\">Liên hệ : Email: </span><u style=\"\"><font color=\"#9c00ff\">thuy.ntt@techgel.com</font></u><span style=\"color: var(--black);\"> SĐT/Zalo: </span><font color=\"#ff0000\">0963 205 687</font></div></p>",
                        "",
                        "/imgs/hr/career_avatar.png"),
                new CareerRecruitment(2L, "Kế toán Dự án", "",
                        1, "Thỏa thuận thuận theo năng lực", "",
                        "Tốt nghiệp Đại học/Cao đẳng chuyên ngành Kế toán, Tài chính, Kiểm toán.", "",
                        "Kinh nghiệm từ 2-3 năm trong lĩnh vực kế toán xây dựng, ưu tiên ứng viên có kinh nghiệm trong ngành M&E.",
                        "",
                        "30 Phan Chu Trinh, phường 02, quận Bình Thạnh, Thành phố Hồ Chí Minh.", "",
                        new Date(),
                        "<p style= font-size: medium;\"><b>Quyền lợi:</b></p><p style= font-size: medium; margin-left: 1.5625rem;\">- Môi trường làm việc:</p><p style= font-size: medium; margin-left: 3.125rem;\">+ Cơ hội làm việc trong môi trường trẻ - năng động – thân thiện, chuyên nghiệp, hệ thống quy trình tác nghiệp rõ ràng, nhiều cơ hội thăng tiến theo năng lực.</p><p style= font-size: medium; margin-left: 3.125rem;\">+ Làm việc hoàn toàn dân chủ với những ý kiến đóng góp được trao đổi trực tiếp với ban lãnh đạo công ty.</p><p style= font-size: medium; margin-left: 1.5625rem;\">- Chế độ:</p><p style= font-size: medium; margin-left: 3.125rem;\">+ Lễ tết, Hiếu hỉ, sinh nhật, ốm đau, thai sản,…</p><p style= font-size: medium; margin-left: 3.125rem;\">+ Được hưởng đầy đủ quyền lợi theo quy định của Luật lao động: BHXH, BHYT,BHTN</p><p style=font-size: medium; margin-left: 3.125rem;\">+ Giờ làm việc : Theo giờ hành chính từ Thứ 2 – Sáng Thứ Bảy.</p><p style= font-size: medium;\"><b>Nội dung công việc:</b></p><p style= font-size: medium; margin-left: 1.5625rem;\">- Theo dõi và kiểm soát chi phí của các dự án M&amp;E, đảm bảo tuân thủ ngân sách đã duyệt.</p><p style= font-size: medium; margin-left: 1.5625rem;\">- Kiểm tra và xác minh tính hợp lệ của các hồ sơ thanh toán, hợp đồng với nhà thầu phụ, nhà cung cấp.</p><p style=font-size: medium; margin-left: 1.5625rem;\">- Phân tích, đánh giá các yếu tố tác động đến chi phí dự án, đề xuất phương án tối ưu hóa chi phí.</p><p style= font-size: medium; margin-left: 1.5625rem;\">- Theo dõi dòng tiền, công nợ phải trả, tiến độ thanh toán cho nhà cung cấp và thầu phụ.</p><p style= font-size: medium; margin-left: 1.5625rem;\">- Lập báo cáo chi phí định kỳ, so sánh chi phí thực tế với kế hoạch để cảnh báo rủi ro.</p><p style= font-size: medium; margin-left: 1.5625rem;\">- Phối hợp với phòng kế toán, phòng đấu thầu để kiểm tra và rà soát đơn giá, khối lượng nghiệm thu.</p><p style=\"font-size: medium; margin-left: 1.5625rem;\"> <br><div style=\"text-align: center;\" bis_skin_checked=\"1\"><span style=\"color: var(--black);\">Liên hệ : Email: </span><u style=\"\"><font color=\"#9c00ff\">thuy.ntt@techgel.com</font></u><span style=\"color: var(--black);\"> SĐT/Zalo: </span><font color=\"#ff0000\">0963 205 687</font></div></p>",
                        "",
                        "/imgs/hr/career_avatar.png"));
    }
}
