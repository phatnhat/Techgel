package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.VisionMission;

import java.util.List;

public abstract class VisionMissionData {
    public static List<VisionMission> get() {
        VisionMission VisionMission1 = new VisionMission(1L, "Tầm nhìn", "Vision", "KỸ THUẬT KIẾN TẠO TƯƠNG LAI\nTechgel kết hợp kỹ thuật cơ điện và công nghệ để xây dựng nhuững công trình thông minh cho một tương lai số hiện đại bậc nhất Đông Nam Á.", "WE ENGINEERING THE FUTURE\nTechgel combines MEP engineering and innovation to shape the smartest, most advanced future of Southeast Asia.", "", 1);
        VisionMission VisionMission2 = new VisionMission(2L, "Sứ mệnh", "Mission", "Chúng ta đang sống trong một thời đại nơi kỹ thuật và công nghệ hội tụ, tái định hình cách các thành phố vận hành, cách ngành công nghiệp phát triển và cách con người sống và làm việc. Tại thời điểm bước ngoặt của quá trình hiện đại hóa Đông Nam Á, Techgel đứng ở tuyến đầu – nơi nhu cầu về những công trình và thiết bị thông minh, hiện đại hóa cực kì to lớn." + "\n" + "Đây không chỉ là cơ hội, mà còn là một sứ mệnh sâu sắc", "We are living in an era where engineering and technology converge, reshaping how cities operate, how industries evolve, and how people live and work. At this pivotal moment in Southeast Asia’s modernization, Techgel stands at the forefront—where the demand for intelligent infrastructure and advanced systems is greater than ever.\nThis is not just an opportunity, but a profound mission." + "\n", "", 2);

        return List.of(VisionMission1, VisionMission2);
    }
}