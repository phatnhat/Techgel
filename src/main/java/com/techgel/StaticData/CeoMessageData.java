package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.CeoMessage;

import java.util.List;

public class CeoMessageData {

    static String msg_vi = "<div>\"Make TECHGEL great again”</div><br>"
            + "<div>Là thế hệ thứ hai của TECHGEL sau 25 năm hình thành và phát triển. Chúng tôi, thế hệ thứ hai của Công ty tiếp tục sứ mệnh hội nhập, ứng dụng và phát triển công nghệ trong lĩnh vực Cơ Điện, Công nghệ thông tin, AI, Big Data và năng lượng tái tạo.</div><br>"
            + "<div>Sau thời gian thị trường và nội bộ khủng hoảng, chúng tôi đã hoàn thành tái cấu trúc toàn vẹn Công ty. Trong đó con người và đội ngũ nhân sự nhiều kinh nghiệm, nhiệt huyết là trung tâm để mang TECHGEL trở lại thị trường với tên tuổi và uy tín như trước đây.</div><br>"
            + "<div>Chúng tôi cam kết mang đến giá trị cao, chất lượng, tiến độ cho Chủ đầu tư. Là đối tác tin cậy với các nhà cung cấp và đối tác. Là một doanh nghiệp phát triển bền vững, không chỉ vì lợi ích kinh tế mà còn vì trách nhiệm với cộng đồng, môi trường và xã hội.</div>";

    static String msg_en = "<div>\"Make TECHGEL great again\"</div><br>"
            + "<div>As the second-generation leadership of TECHGEL, following 25 years of establishment and growth, we continue the mission of integration, application, and advancement of technology in the fields of MEP Engineering, Information Technology, Artificial Intelligence, Big Data, and Renewable Energy.</div><br>"
            + "<div>After a period of internal and market-driven challenges, we have successfully completed a comprehensive corporate restructuring. At the heart of this transformation is a highly experienced and dedicated workforce, which positions TECHGEL to re-enter the market with the same reputation and credibility it once held.</div><br>"
            + "<div>We are committed to delivering high value, quality, and schedule compliance to project owners; to being a reliable partner to suppliers and strategic collaborators; and to building a sustainable enterprise that prioritizes not only economic performance but also its responsibility to the community, the environment, and society at large.</div>";

    public static List<CeoMessage> get() {
        return List.of(
                new CeoMessage(1L, "Thông điệp tổng giám", "Message from the general director",
                        "Kiến tạo giá trị", "Value creation and", "bền vững", "sustainable development",
                        msg_vi,
                        msg_en,
                        "/imgs/signature.png", "Nguyễn Quốc Dũng", "Nguyen Quoc Dung", "Tổng giám đốc", "General Director")
        );
    }
}
