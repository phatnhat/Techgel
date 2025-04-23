package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.AboutUsTestimonialItems;

import java.util.List;

public abstract class AboutUsTestimonialItemData {
    public static List<AboutUsTestimonialItems> get(){
        AboutUsTestimonialItems aboutUsTestimonialItems1 = new AboutUsTestimonialItems(1L,
                "Techgel sau khi triển khai gói thầu BP07B - Gói thầu điện đã thực hiện công việc một cách nhanh chóng và chuyên nghiệp. Chúng tôi đã có nhiều kinh nghiệm bổ ích sau khi làm việc với Techgel và mong muốn được hợp tác trong các dự án tiếp theo.",
                "After executing the BP07B – Electrical Package, Techgel carried out the work swiftly and professionally. Through this collaboration, we have gained valuable experience and look forward to working together on future projects.",
                "Peter Armstrong", "Peter Armstrong", "Giám đốc | TURNER", "General Director | TURNER",
                "/imgs/recommendations/peter-armstrong.jfif",
                1);

        AboutUsTestimonialItems aboutUsTestimonialItems2 = new AboutUsTestimonialItems(1L,
                "Tôi cho rằng điều quan trọng hơn cả là hiểu cách mà Techgel vận hành và triển khai công việc. Qua những gì tôi đã quan sát cho đến nay, tôi nhận thấy Techgel làm việc một cách rất chuyên nghiệp. Thực tế, tôi phải nói rằng mức độ chuyên nghiệp của Techgel còn vượt trội hơn một số nhà thầu mà tôi từng hợp tác tại Hoa Kỳ. Dù đây chỉ là một dự án quy mô nhỏ, Techgel đã thể hiện được tinh thần nghiêm túc và thái độ làm việc chuyên nghiệp, không ngừng hoàn thiện và điều chỉnh linh hoạt để đảm bảo quy trình quản lý thi công được vận hành trơn tru và hiệu quả.",
                "I think it is more of knowing how Techgel does business and from what I have seen to date Techgel is very professional. I would have to say even more professional then some of the contractors that I have dealt with in the USA. For such a small project as we have Techgel has demonstrated a very serious and professional approach with continued growth towards making minor adjustments for maintaining a smooth construction operating management.",
                "Steven R. Macomber", "Steven R. Macomber", "Quản lý hiện trường dự án | BV", "Project Field Manager | BV",
                "/imgs/recommendations/stevenRmacomber.jfif",
                2);

        AboutUsTestimonialItems aboutUsTestimonialItems3 = new AboutUsTestimonialItems(1L,
                "Quy trình quản lý tổng thể của Techgel được triển khai rất tốt. Bên cạnh đó, với tư cách là một doanh nghiệp, Techgel phản hồi email rất nhanh chóng — thật sự là một điều đáng ghi nhận khi nhận được phản hồi trong vòng chưa đến ba ngày. Chúng tôi cũng đánh giá cao năng lực thiết kế phần mềm của Techgel và quy trình liên tục cải thiện dự án. Với những ấn tượng tích cực đó, chúng tôi hoàn toàn sẵn sàng xây dựng mối quan hệ hợp tác bền vững với Techgel trong các dự án tương lai.",
                "The overall process management is very good. Moreover, as a company, the reply to email is fast. It is a great pleasure to receive a response in less than three days. We also have regard about high software design capabilities and repeated revisions are also good for the projects, and we are willing to have a strong partnership with Techgel in future projects.",
                "Yutaka Eto", "Yutaka Eto", "Quản Lý Dự Án | Metawater", "Project Manager | Metawater",
                "/imgs/recommendations/yutaka-eto.jfif",
                3);

        return List.of(aboutUsTestimonialItems1, aboutUsTestimonialItems2, aboutUsTestimonialItems3);
    }
}
