package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.HumanResourceDevelopment;
import com.techgel.common.entity.adminSettings.News;

import java.util.List;

public abstract class HumanResourceDevelopmentData {
    public static List<HumanResourceDevelopment> get() {
        return List.of(
                new HumanResourceDevelopment(1L, "Phát triển nguồn nhân lực", "Human resource development",
                        "Chúng tôi sử dụng nguồn lực theo nguyên tắc: “Đúng người – Đúng việc – Đúng thời điểm”. Phải biết chắc chắn rằng công việc và con người phải phù hợp với nhau, từ đó thúc đẩy sự phát triển tốt nhất của mỗi cá nhân gắn liền với sự phát triển của tổ chức. Vì vậy, đào tạo nội bộ là quy trình bắt buộc, không chỉ dành riêng cho các nhân sự mới. Trong quá trình làm việc, tất cả các nhân viên đều có cơ hội bồi dưỡng kiến thức chuyên môn với các Chuyên gia được mời đến tận nơi hoặc được tài trợ học bổng toàn phần cho các khóa học khác tại các trung tâm đào tạo uy tín trong và ngoài nước.",
                        "We utilize resources based on the principle: “The right person – The right job – The right timing.” It is essential to ensure that the job and the individual are well-matched, thereby promoting the best development of each person alongside the growth of the organization. Therefore, internal training is a mandatory process, not only for new employees. Throughout their tenure, all staff have the opportunity to enhance their professional knowledge through experts invited onsite or receive full scholarships for other courses at reputable training centers both domestically and internationally.",
                        "Phát triển nguồn nhân lực là điều kiện quyết định để doanh nghiệp có thể tồn tại và phát triển trong nền kinh tế thị trường cùng với sự bùng nổ công nghệ như hiện nay. Chính sách phát triển nguồn nhân lực ưu việt sẽ giúp người lao động tự tin cống hiến và trưởng thành, tạo cho họ cảm giác yên tâm làm việc, gắn bó với Công ty, đem hết khả năng của mình phục vụ cho tổ chức, coi sự phát triển lớn mạnh của Công ty là sự phát triển của bản thân mỗi người.",
                        "Human resource development is a decisive factor for businesses to survive and grow in the current market economy alongside the rapid technological boom. An excellent human resource development policy helps employees confidently contribute and grow, giving them a sense of security at work, loyalty to the company, and encouraging them to fully dedicate their abilities to the organization—viewing the company’s growth and success as their own personal development.",
                        "<p></p><div style=\"text-align: center;\" bis_skin_checked=\"1\"><span style=\"color: rgb(12, 77, 162); font-size: 20px; font-weight: 700;\">Việc đào tạo giúp cho các cán bộ, nhân viên tiềm năng được đào tạo không chỉ vận dụng kiến thức vào thực tế một cách hiệu quả mà còn xác định được lộ trình phát triển phù hợp với mục tiêu phát triển của Công ty.</span></div><p></p>",
                        "<p></p><div style=\"text-align: center;\"><span style=\"color: rgb(12, 77, 162); font-size: 20px; font-weight: 700;\">Training helps potential staff and employees not only effectively apply knowledge in practice but also identify a suitable development pathway aligned with the Company’s growth objectives.</span></div><p></p>")
        );
    }
}
