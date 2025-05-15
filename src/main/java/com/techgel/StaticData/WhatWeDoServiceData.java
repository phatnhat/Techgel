package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.WhatWeDoService;
import com.techgel.common.entity.adminSettings.WhatWeDoServiceItems;

import java.util.List;

public abstract class WhatWeDoServiceData {
        public static List<WhatWeDoService> get() {
                WhatWeDoService item1 = new WhatWeDoService(1L, "Năng lượng", "Energy", 1,
                                "/imgs/field-of-activities/energy.jpg", "/imgs/field-of-activities/energy-popup.png",
                                "Ngành năng lượng của chúng tôi hướng đến mục tiêu phát triển bền vững, đa dạng hóa nguồn năng lượng và giảm thiểu tác động đến môi trường. Với chiến lược đầu tư bài bản vào các nguồn năng lượng tái tạo và giải pháp tiết kiệm năng lượng, chúng tôi cam kết đóng góp vào sự phát triển kinh tế - xã hội, đồng thời đảm bảo an ninh năng lượng quốc gia.",
                                "");
                WhatWeDoService item2 = new WhatWeDoService(2L, "Công trình nhà ga", "Airside", 2,
                                "/imgs/field-of-activities/airside.jpg",
                                "/imgs/field-of-activities/aviation-popup.png",
                                "Ngành Công trình Nhà ga là một trong những lĩnh vực trọng điểm của chúng tôi, tập trung vào thiết kế, xây dựng và vận hành các công trình phục vụ hoạt động hàng không và vận tải. Với kinh nghiệm và công nghệ hiện đại, chúng tôi cam kết mang đến những giải pháp tối ưu, đảm bảo tính an toàn, hiệu quả và đáp ứng các tiêu chuẩn quốc tế.",
                                "");
                WhatWeDoService item3 = new WhatWeDoService(3L, "Công nghiệp", "Industry", 3,
                                "/imgs/field-of-activities/industry.jfif",
                                "/imgs/field-of-activities/industry-popup.png",
                                "Ngành Công nghiệp tập trung vào các giải pháp bền vững nhằm đáp ứng nhu cầu phát triển hạ tầng, bảo vệ môi trường và nâng cao chất lượng cuộc sống. Với hệ thống công nghệ hiện đại và đội ngũ chuyên gia giàu kinh nghiệm, chúng tôi cam kết mang đến những dịch vụ và công trình công nghiệp chất lượng cao, đảm bảo hiệu quả kinh tế và thân thiện với môi trường.",
                                "");
                WhatWeDoService item4 = new WhatWeDoService(4L, "Dân dụng", "Civil", 4,
                                "/imgs/field-of-activities/civil.jpg", "/imgs/field-of-activities/civil-popup.png",
                                "Ngành Dân dụng chuyên thiết kế và thi công các công trình phục vụ nhu cầu đời sống, làm việc, giáo dục và chăm sóc sức khỏe của cộng đồng. Với phương châm \"Chất lượng - An toàn - Thẩm mỹ\", chúng tôi cam kết mang đến những công trình bền vững, hiện đại, đáp ứng tiêu chuẩn quốc tế và nâng cao chất lượng sống.",
                                "");
                WhatWeDoService item5 = new WhatWeDoService(5L, "Hạ tầng", "Infrastructure", 5,
                                "/imgs/field-of-activities/infrastructure.jpg", "",
                                "Ngành Hạ tầng đóng vai trò quan trọng trong chiến lược phát triển bền vững của chúng tôi, tập trung vào việc thiết kế, xây dựng và nâng cấp các hệ thống cơ sở hạ tầng phục vụ phát triển kinh tế - xã hội. Với kinh nghiệm và công nghệ hiện đại, chúng tôi cam kết mang đến những công trình chất lượng cao, đáp ứng nhu cầu hiện tại và tương lai.",
                                "");
                WhatWeDoService item6 = new WhatWeDoService(6L, "Công nghệ", "Technology", 6,
                                "/imgs/field-of-activities/technology.jpg",
                                "/imgs/field-of-activities/technology-popup.png",
                                "Ngành Công nghệ là lĩnh vực mũi nhọn đầy triển vọng của chúng tôi, tập trung vào nghiên cứu, phát triển và ứng dụng các giải pháp công nghệ tiên tiến để thúc đẩy chuyển đổi số và nâng cao hiệu quả trong nhiều lĩnh vực. Với đội ngũ chuyên gia giàu kinh nghiệm cùng chiến lược đầu tư bài bản, chúng tôi cam kết mang đến những sản phẩm và dịch vụ công nghệ đột phá, đáp ứng xu thế toàn cầu.",
                                "");

                item1.setWhatWeDoServiceItems(List.of(
                                new WhatWeDoServiceItems(1L, "Điện gió", "", 1,
                                                "Chúng tôi tập trung phát triển các dự án điện gió trên cả đất liền và ngoài khơi, tận dụng tiềm năng gió lớn tại nhiều khu vực. Các trang trại gió của chúng tôi được trang bị công nghệ tiên tiến, đảm bảo hiệu suất cao và giảm thiểu tác tác động đến môi trường.",
                                                ""),
                                new WhatWeDoServiceItems(2L, "Điện mặt trời", "", 2,
                                                "Với lợi thế về nắng và không gian rộng lớn, chúng tôi đầu tư mạnh vào điện mặt trời, bao gồm các dự án quy mô lớn (điện mặt trời tập trung) và hệ thống áp mái cho hộ gia đình, doanh nghiệp. Công nghệ pin mặt trời hiện đại giúp tối ưu hóa hiệu suất và kéo dài tuổi thọ hệ thống.",
                                                ""),
                                new WhatWeDoServiceItems(3L, "Nhà máy nhiệt điện", "", 3,
                                                "Bên cạnh năng lượng tái tạo, chúng tôi vận hành các nhà máy nhiệt điện với công nghệ tiên tiến, sử dụng nhiên liệu sạch hơn như khí thiên nhiên hóa lỏng (LNG) và than cải tiến, nhằm giảm phát thải CO₂ và đáp ứng nhu cầu điện ổn định cho hệ thống.",
                                                ""),
                                new WhatWeDoServiceItems(4L, "Năng lượng sinh khối", "", 4,
                                                "Chúng tôi khai thác nguồn năng lượng từ sinh khối (bã mía, trấu, gỗ, phế thải nông nghiệp…) để sản xuất điện và nhiệt năng. Giải pháp này không chỉ tạo ra năng lượng sạch mà còn góp phần xử lý chất thải, phát triển nông nghiệp bền vững.",
                                                ""),
                                new WhatWeDoServiceItems(5L, "Giải pháp tiết kiệm năng lượng", "", 5,
                                                "Ngoài sản xuất năng lượng, chúng tôi cung cấp các giải pháp tiết kiệm năng lượng như hệ thống quản lý năng lượng (EMS), đèn LED tiết kiệm điện, giải pháp cách nhiệt và tối ưu hóa hiệu suất cho doanh nghiệp. Với định hướng phát triển bền vững, chúng tôi không ngừng nghiên cứu, ứng dụng công nghệ mới nhằm nâng cao hiệu quả và giảm thiểu tác động môi trường, góp phần xây dựng một tương lai năng lượng xanh cho Việt Nam và khu vực.",
                                                "")));
                item2.setWhatWeDoServiceItems(List.of(
                                new WhatWeDoServiceItems(6L, "Nhà ga hành khách", "", 6,
                                                "Chúng tôi thiết kế và xây dựng các nhà ga hành khách với quy mô từ sân bay quốc tế đến sân bay nội địa, đảm bảo khả năng tiếp nhận lượng lớn hành khách một cách thuận tiện và an toàn. Các công trình được trang bị hệ thống check-in, an ninh, thông tin liên lạc hiện đại, cùng không gian thương mại và dịch vụ tiện ích.",
                                                ""),
                                new WhatWeDoServiceItems(7L, "Nhà ga hàng hóa", "", 7,
                                                "Nhà ga hàng hóa được xây dựng để đáp ứng nhu cầu vận chuyển hàng hóa bằng đường hàng không với công suất lớn. Chúng tôi tích hợp hệ thống kho bãi thông minh, thiết bị xếp dỡ tự động và công nghệ quản lý logistics để tối ưu hóa quy trình, giảm thời gian lưu kho và nâng cao hiệu quả vận hành.",
                                                ""),
                                new WhatWeDoServiceItems(8L, "Hangar bảo dưỡng tàu bay", "", 8,
                                                "Hangar bảo dưỡng là công trình chuyên dụng phục vụ cho việc kiểm tra, sửa chữa và bảo dưỡng máy bay. Chúng tôi thiết kế hangar với kết cấu khung thép lớn, hệ thống thiết bị nâng hạ chuyên dụng, cùng các phân khu chức năng như khu bảo trì động cơ, kiểm tra thân máy bay và khu vực lắp ráp phụ tùng.\n"
                                                                +
                                                                "\n" +
                                                                "Với đội ngũ kỹ sư giàu kinh nghiệm và công nghệ tiên tiến, chúng tôi tự hào là đơn vị tiên phong trong lĩnh vực xây dựng công trình nhà ga, góp phần phát triển hệ thống hạ tầng hàng không hiện đại, bền vững.",
                                                "")));
                item3.setWhatWeDoServiceItems(List.of(
                                new WhatWeDoServiceItems(9L, "Xử lý nước thải", "", 9,
                                                "Chúng tôi cung cấp các giải pháp xử lý nước thải công nghiệp và đô thị bằng công nghệ tiên tiến như MBR (Màng lọc sinh học), MBBR (Bể bùn hoạt tính dính bám), và hệ thống xử lý hóa lý. Các hệ thống được thiết kế tối ưu, đảm bảo nước thải đầu ra đạt tiêu chuẩn môi trường, góp phần bảo vệ nguồn nước và sức khỏe cộng đồng.",
                                                ""),
                                new WhatWeDoServiceItems(10L, "Cung cấp nước sạch", "", 10,
                                                "Chúng tôi đầu tư và vận hành các nhà máy cung cấp nước sạch với công suất lớn, sử dụng công nghệ lọc RO, UV, ozone và các phương pháp tiên tiến khác để đảm bảo nguồn nước an toàn, đạt chuẩn quốc gia và quốc tế. Hệ thống phân phối nước được quản lý thông minh, giảm thiểu thất thoát và nâng cao hiệu quả sử dụng.",
                                                ""),
                                new WhatWeDoServiceItems(11L, "Nhà xưởng khu công nghiệp", "", 11,
                                                "Chúng tôi thiết kế và xây dựng các nhà xưởng, khu công nghiệp đạt tiêu chuẩn, đáp ứng nhu cầu sản xuất của doanh nghiệp. Các công trình được trang bị hệ thống điện, thông gió, PCCC hiện đại, cùng Hạ tầng và logistics đồng bộ, tạo môi trường làm việc an toàn và hiệu quả.\n"
                                                                +
                                                                "\n" +
                                                                "Với định hướng phát triển bền vững, chúng tôi không ngừng nghiên cứu và ứng dụng công nghệ mới, góp phần thúc đẩy ngành công nghiệp trong nước, đồng thời bảo vệ môi trường và nâng cao chất lượng cuộc sống.",
                                                "")));
                item4.setWhatWeDoServiceItems(List.of(
                                new WhatWeDoServiceItems(12L, "Khách sạn & khu nghỉ dưỡng", "", 12,
                                                "Thiết kế và xây dựng các tổ hợp khách sạn 5 sao, resort cao cấp với kiến trúc độc đáo, hài hòa với thiên nhiên.Tích hợp hệ thống tiện ích đẳng cấp: hồ bơi, spa, nhà hàng, khu vui chơi giải trí.",
                                                ""),
                                new WhatWeDoServiceItems(13L, "Bệnh viện", "", 13,
                                                "Xây dựng bệnh viện đa khoa, chuyên khoa với hệ thống phòng mổ vô trùng, phòng ICU hiện đại. Áp dụng giải pháp kiến trúc xanh, đảm bảo môi trường chữa bệnh thân thiện, an toàn.",
                                                ""),
                                new WhatWeDoServiceItems(14L, "Siêu thị", "", 14,
                                                "Thi công siêu thị, trung tâm mua sắm quy mô lớn với hệ thống điện lạnh, chiếu sáng và an ninh tối ưu. Bố trí không gian mua sắm khoa học, trải nghiệm khách hàng là ưu tiên hàng đầu.",
                                                ""),
                                new WhatWeDoServiceItems(15L, "Chung cư cao tầng, văn phòng, trường học", "", 15,
                                                "Phát triển các dự án chung cư cao cấp, đô thị thông minh với tiêu chuẩn xanh (LEED, LOTUS). Chú trọng an ninh, tiện ích nội khu (công viên, phòng gym, khu vui chơi trẻ em).",
                                                "")));
                item5.setWhatWeDoServiceItems(List.of(
                                new WhatWeDoServiceItems(16L, "Hạ tầng khu công nghiệp, nhà máy", "", 16,
                                                "Thiết kế và xây dựng hệ thống hạ tầng đồng bộ cho các khu công nghiệp, bao gồm: đường giao thông nội bộ, hệ thống cấp thoát nước, điện, viễn thông. Áp dụng công nghệ thông minh (IoT, hệ thống giám sát tự động) để tối ưu hóa vận hành.",
                                                ""),
                                new WhatWeDoServiceItems(17L, "Hạ tầng giao thông", "", 17,
                                                "Thi công các công trình giao thông trọng điểm: đường cao tốc, cầu, hầm, cảng biển, sân bay. Ứng dụng vật liệu mới và công nghệ thi công tiên tiến (cầu dây văng, hầm chịu lực cao) để nâng cao tuổi thọ công trình. Phát triển hệ thống giao thông thông minh (ITS) để giảm ùn tắc và tăng tính kết nối.",
                                                "")));
                item6.setWhatWeDoServiceItems(List.of(
                                new WhatWeDoServiceItems(18L, "Công nghệ hàng không", "", 18,
                                                "Nghiên cứu và phát triển các giải pháp công nghệ cho ngành hàng không như hệ thống quản lý không lưu thông minh, giám sát drone, và phần mềm tối ưu hóa vận hành sân bay. Ứng dụng AI và IoT để nâng cao hiệu quả bảo trì, dự đoán lỗi thiết bị và cải thiện trải nghiệm hành khách.",
                                                ""),
                                new WhatWeDoServiceItems(19L, "Công nghệ Datacenter", "", 19,
                                                "Xây dựng và vận hành các trung tâm dữ liệu (datacenter) hiện đại, đạt tiêu chuẩn Tier 3/4, với hệ thống làm mát tiết kiệm năng lượng và bảo mật đa lớp. Cung cấp giải pháp điện toán đám mây (cloud), lưu trữ dữ liệu lớn (Big Data) và hạ tầng mạng tốc độ cao.",
                                                ""),
                                new WhatWeDoServiceItems(20L, "Công nghệ AI", "", 20,
                                                "Phát triển các ứng dụng AI trong nhiều lĩnh vực: xử lý ngôn ngữ tự nhiên (NLP), thị giác máy tính (Computer Vision), và hệ thống khuyến nghị (Recommendation Systems). Triển khai AI vào tự động hóa quy trình sản xuất, phân tích dữ liệu dự đoán và nâng cao hiệu quả kinh doanh.",
                                                "")));

                return List.of(item1, item2, item3, item4, item5, item6);
        }
}
