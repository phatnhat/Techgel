package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.CeoMessage;

import java.util.List;

public class CeoMessageData {
    public static List<CeoMessage> get(){
        return List.of(
                new CeoMessage(1L, "Thông điệp tổng giám", "Message from the general director",
                        "Kiến tạo giá trị", "Value creation and", "bền vững", "sustainable development",
                        "Chúng tôi cam kết xây dựng một doanh nghiệp phát triển bền vững, không chỉ vì lợi ích kinh tế mà còn vì trách nhiệm với cộng đồng và môi trường. Mỗi thành viên là một hạt nhân, cùng tạo nên sức mạnh tập thể không ngừng vươn xa.",
                        "We are committed to building a sustainable business — not only for economic gain, but also out of responsibility to the community and the environment. Each member is a vital nucleus, contributing to a collective strength that continues to reach further.",
                        "/imgs/signature.png", "Nguyễn Quốc Dũng", "Nguyen Quoc Dung", "Tổng giám đốc", "General Director")
        );
    }
}
