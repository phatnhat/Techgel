package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.CeoMessage;

import com.techgel.common.entity.adminSettings.VisionMission;

import java.util.List;

public class VisionMissionData {
    public static List<VisionMission> get(){
        return List.of(
                new VisionMission(1L, "Tầm nhìn", "Vision",
                        "Định hình hạ tầng cơ điện và năng lượng tái tạo của tương lai, mang đến các giải pháp công nghệ tiên tiến giúp tối ưu hóa hiệu suất, giảm thiểu tác động môi trường và nâng cao chất lượng cuộc sống.",
                        "Shaping the future of MEP and renewable energy infrastructure with advanced technology solutions that optimize performance, reduce environmental impact, and enhance quality of life.",
                        "/imgs/about/inaugurate.jpg"),

                new VisionMission(2L, "Sứ mệnh", "Mission",
                        "Nâng cao hiệu quả hoạt động của những công trình thông qua việc tích hợp các hệ thống cơ điện thông minh và triển khai đồng bộ các giải pháp công nghệ tiên tiến, năng lượng tái tạo xanh, tạo ra nhiều giá trị bền vững và môi trường sống, làm việc tối ưu.",
                        "Enhancing project performance by integrating smart MEP systems and deploying advanced technologies and green renewable energy solutions to deliver sustainable value and optimize living and working environments.",
                        "/imgs/about/quality-handshake.png")
        );
    }
}

