package com.techgel.client.controller;

import com.techgel.common.DTOs.SignatureProjectDTO;

import com.techgel.common.entity.adminSettings.AboutUsIntroduce;
import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificate;
import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChart;
import com.techgel.common.entity.adminSettings.AboutUsOrganizationalChartItems;
import com.techgel.common.entity.adminSettings.AboutUsTestimonial;
import com.techgel.common.entity.adminSettings.AboutUsTestimonialItems;
import com.techgel.common.entity.adminSettings.Carousel;
import com.techgel.common.entity.adminSettings.EProfile;
import com.techgel.common.entity.adminSettings.HomeAboutUs;
import com.techgel.common.entity.adminSettings.HomeOurBusinessLine;
import com.techgel.common.entity.adminSettings.HomeStatistic;
import com.techgel.common.entity.adminSettings.HomeStatisticItems;
import com.techgel.common.entity.adminSettings.WhatWeDoService;
import com.techgel.common.entity.enums.NewsType;
import com.techgel.common.service.AboutUsIntroduceService;
import com.techgel.common.service.AboutUsLicenseCertificateService;
import com.techgel.common.service.AboutUsOrganizationalChartItemsService;
import com.techgel.common.service.AboutUsOrganizationalService;
import com.techgel.common.service.AboutUsTestimonialItemsService;
import com.techgel.common.service.AboutUsTestimonialService;
import com.techgel.common.service.CarouselService;
import com.techgel.common.service.EProfileService;
import com.techgel.common.service.HomeAboutUsService;
import com.techgel.common.service.HomeOurBusinessLineService;
import com.techgel.common.service.HomeStatisticItemsService;
import com.techgel.common.service.HomeStatisticService;
import com.techgel.common.service.WhatWeDoServiceService;
import com.techgel.common.DTOs.LogoDTO;
import com.techgel.common.DTOs.NewsDTO;

import com.techgel.common.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final CarouselService carouselService;
    private final HomeAboutUsService homeAboutUsService;
    private final HomeStatisticService homeStatisticService;
    private final HomeStatisticItemsService homeStatisticItemsService;
    private final HomeOurBusinessLineService homeOurBusinessLineService;
    private final WhatWeDoServiceService whatWeDoServiceService;
    private final AboutUsIntroduceService aboutUsIntroduceService;
    private final EProfileService eProfileService;
    private final AboutUsTestimonialService aboutUsTestimonialService;
    private final AboutUsTestimonialItemsService aboutUsTestimonialItemsService;
    private final AboutUsOrganizationalService aboutUsOrganizationalService;
    private final AboutUsOrganizationalChartItemsService aboutUsOrganizationalChartItemsService;
    private final AboutUsLicenseCertificateService aboutUsLicenseCertificateService;
    private final AboutUsClientPartnerService aboutUsClientPartnerService;
    private final ProjectCategoryService projectCategoryService;
    private final ProjectService projectService;

    List<NewsDTO> trainingNewsList = List.of(
            new NewsDTO(
                    "t001",
                    "Techgel khởi động chương trình đào tạo kỹ sư IT",
                    NewsType.TRAINING,
                    "Chương trình đào tạo được thiết kế nhằm trang bị kiến thức thực tiễn và kỹ năng chuyên sâu cho các kỹ sư IT trẻ chuẩn bị gia nhập đội ngũ Techgel.",
                    "/imgs/news/dao-tao/khoi-dong-dao-tao-it.jpg",
                    LocalDateTime.of(2024, 7, 1, 0, 0)),
            new NewsDTO(
                    "t002",
                    "Techgel chào đón tân sinh viên tới thực tập tại công ty",
                    NewsType.TRAINING,
                    "Đợt thực tập mùa hè 2024 đã chính thức bắt đầu với sự tham gia của gần 50 sinh viên từ các trường kỹ thuật hàng đầu cả nước.",
                    "/imgs/news/dao-tao/thuc-tap-tan-sinh-vien.jpg",
                    LocalDateTime.of(2024, 6, 10, 0, 0)),
            new NewsDTO(
                    "t003",
                    "Cố vấn BGĐ Nguyễn Thanh Phương tổ chức đào tạo chuyên đề 'Văn hóa giao tiếp nơi làm việc'",
                    NewsType.TRAINING,
                    "Buổi đào tạo giúp nhân sự Techgel hiểu rõ hơn về chuẩn mực giao tiếp trong môi trường doanh nghiệp, từ đó nâng cao hiệu quả cộng tác và hình ảnh chuyên nghiệp.",
                    "/imgs/news/dao-tao/giao-tiep-noi-lam-viec.jpg",
                    LocalDateTime.of(2024, 5, 20, 0, 0)),
            new NewsDTO(
                    "t004",
                    "Quản trị ISO Nguyễn Đình Hiếu tổ chức đào tạo chuyên đề 'Phổ biến công việc nhiệm vụ khối nội chính'",
                    NewsType.TRAINING,
                    "Khóa đào tạo chuyên sâu về cơ cấu, trách nhiệm và quy trình công tác hành chính dành cho toàn thể nhân sự khối nội chính.",
                    "/imgs/news/dao-tao/nhiem-vu-noi-chinh.jpg",
                    LocalDateTime.of(2024, 8, 5, 0, 0)),
            new NewsDTO(
                    "t005",
                    "Chương trình đào tạo Tân Thế Hệ chính thức đưa vào hoạt động",
                    NewsType.TRAINING,
                    "Đây là chương trình huấn luyện định hướng dành cho nhân sự mới, nhấn mạnh giá trị cốt lõi và môi trường phát triển nghề nghiệp tại Techgel.",
                    "/imgs/news/dao-tao/chuong-trinh-tan-the-he.jpg",
                    LocalDateTime.of(2024, 9, 1, 0, 0)),
            new NewsDTO(
                    "t006",
                    "Techgel tổ chức workshop 'Thiết kế tư duy đổi mới sáng tạo'",
                    NewsType.TRAINING,
                    "Workshop giúp nhân sự tiếp cận với phương pháp tư duy thiết kế và đổi mới sáng tạo, áp dụng vào công việc hàng ngày nhằm nâng cao hiệu suất và tạo giá trị.",
                    "/imgs/news/dao-tao/workshop-thiet-ke-sang-tao.jpg",
                    LocalDateTime.of(2024, 10, 15, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)),
            new NewsDTO(
                    "t007",
                    "Khóa đào tạo nâng cao kỹ năng quản lý dự án thành công tốt đẹp",
                    NewsType.TRAINING,
                    "Sau 2 tuần triển khai, khóa học quản lý dự án đã giúp gần 30 quản lý của Techgel cải thiện kỹ năng lập kế hoạch, giao tiếp nhóm và điều phối tiến độ.",
                    "/imgs/news/dao-tao-quan-ly-du-an/dao-tao-tan-ky-su.jpg",
                    LocalDateTime.of(2024, 11, 5, 0, 0)));

    List<NewsDTO> internalNewsList = List.of(
            new NewsDTO(
                    "i001",
                    "Quyết định thành lập và nhiệm vụ của khối Công Nghệ",
                    NewsType.INTERNAL,
                    "Ban lãnh đạo Techgel chính thức công bố quyết định thành lập khối Công Nghệ nhằm tập trung nguồn lực phát triển các giải pháp kỹ thuật và chuyển đổi số toàn diện.",
                    "/imgs/news/noi-bo/thanh-lap-khoi-cong-nghe.jpg",
                    LocalDateTime.of(2024, 5, 20, 0, 0)),
            new NewsDTO(
                    "i002",
                    "Techgel thông báo nghỉ lễ 30/4 - 1/5",
                    NewsType.INTERNAL,
                    "Thông báo đến toàn thể nhân sự Techgel về lịch nghỉ lễ Giải phóng miền Nam (30/4) và Quốc tế Lao động (1/5), thời gian làm việc trở lại bắt đầu từ ngày 2/5.",
                    "/imgs/news/noi-bo/thong-bao-nghi-le-30-4-1-5.jpg",
                    LocalDateTime.of(2024, 4, 25, 0, 0)),
            new NewsDTO(
                    "i003",
                    "Hội nghị liên hiệp thương mại khai thác thị trường Saudi Arabia",
                    NewsType.INTERNAL,
                    "Hội nghị được tổ chức nhằm thúc đẩy cơ hội hợp tác chiến lược với các doanh nghiệp tại thị trường Trung Đông, đặc biệt là Saudi Arabia.",
                    "/imgs/news/noi-bo/hoi-nghi-thuong-mai-saudi-arabia.jpg",
                    LocalDateTime.of(2024, 6, 14, 0, 0)),
            new NewsDTO(
                    "i004",
                    "Đón chào ngày lễ 8/3 cùng các nữ nhân viên tại Techgel",
                    NewsType.INTERNAL,
                    "Nhân ngày Quốc tế Phụ nữ 8/3, Techgel tổ chức chuỗi hoạt động tri ân và vinh danh những đóng góp quan trọng của các cán bộ nữ trong toàn hệ thống.",
                    "/imgs/news/noi-bo/quoc-te-phu-nu-8-3.jpg",
                    LocalDateTime.of(2024, 3, 8, 0, 0)),
            new NewsDTO(
                    "i005",
                    "Quyết định thành lập BCH Dự Án",
                    NewsType.INTERNAL,
                    "Techgel chính thức ra quyết định thành lập Ban Chỉ Huy Dự Án nhằm tăng cường năng lực điều phối và triển khai các dự án trọng điểm trong giai đoạn tới.",
                    "/imgs/news/noi-bo/thanh-lap-bch-du-an.jpg",
                    LocalDateTime.of(2024, 9, 3, 0, 0)),
            new NewsDTO(
                    "i006",
                    "Quy định chức năng và nhiệm vụ của khối nội chính",
                    NewsType.INTERNAL,
                    "Các chức năng và nhiệm vụ của khối Nội Chính đã được điều chỉnh nhằm tăng cường tính minh bạch, hiệu quả trong công tác hành chính nội bộ.",
                    "/imgs/news/noi-bo/nhiem-vu-khoi-noi-chinh.jpg",
                    LocalDateTime.of(2024, 7, 10, 0, 0)),
            new NewsDTO(
                    "i007",
                    "Hội nghị liên hiệp hợp tác giữa Techgel, PNP và PMI",
                    NewsType.INTERNAL,
                    "Hội nghị hợp tác chiến lược giữa ba đơn vị nhằm định hướng phát triển các dự án công nghệ trong và ngoài nước, với mục tiêu xây dựng hệ sinh thái kỹ thuật số đồng bộ.",
                    "/imgs/news/noi-bo/hoi-nghi-hop-tac-techgel-pnp-pmi.jpg",
                    LocalDateTime.of(2024, 8, 1, 0, 0)));

    List<NewsDTO> projectNewsList = List.of(
            new NewsDTO(
                    "p001",
                    "Techgel, PMI và Incheon trúng thầu dự án Sân bay Long Thành",
                    NewsType.PROJECT,
                    "Tập đoàn Techgel, PMI và Incheon vừa trúng gói thầu Cung cấp dịch vụ tư vấn công tác quản lý, khai thác sân bay Long Thành",
                    "/imgs/news/trung-thau-long-thanh/trung-thau-long-thanh.jpg",
                    LocalDateTime.of(2024, 8, 30, 0, 0)),
            new NewsDTO(
                    "p002",
                    "Techgel và PMI khởi động gói thầu dự án Sân bay Long Thành",
                    NewsType.PROJECT,
                    "ACV đã chủ động khởi động gói thầu vào ngày 10/10/2024. Đây là bước đi quan trọng để đảm bảo sân bay Long Thành vận hành thông suốt, an toàn ngay từ khi mở cửa, đồng thời nâng cao năng lực cạnh tranh và phát triển bền vững",
                    "/imgs/news/trung-thau-long-thanh/trung-thau-long-thanh.jpg",
                    LocalDateTime.of(2024, 10, 10, 0, 0)),
            new NewsDTO(
                    "p003",
                    "Khởi công nhà máy thông minh do Techgel làm tổng thầu",
                    NewsType.PROJECT,
                    "Techgel chính thức khởi công dự án nhà máy sản xuất tự động hóa tại Khu công nghệ cao Quận 9, TP.HCM",
                    "/imgs/news/nha-may-thong-minh/nha-may-thong-minh.jpg",
                    LocalDateTime.of(2024, 7, 5, 0, 0)),
            new NewsDTO(
                    "p004",
                    "Techgel bàn giao dự án năng lượng mặt trời tại Ninh Thuận",
                    NewsType.PROJECT,
                    "Dự án năng lượng mặt trời với công suất 100MW đã được hoàn thành và bàn giao đúng tiến độ bởi đội ngũ Techgel",
                    "/imgs/news/nang-luong-mat-troi/nang-luong-mat-troi.jpg",
                    LocalDateTime.of(2024, 9, 12, 0, 0)),
            new NewsDTO(
                    "p005",
                    "Lễ khởi công dự án Sân Bay Long Thành",
                    NewsType.PROJECT,
                    "Dự án có tổng vốn đầu tư 200 tỷ đồng nhằm cải thiện hệ thống xử lý nước thải đô thị khu vực phía Nam tỉnh Bình Dương",
                    "/imgs/news/nuoc-thai-binh-duong/nuoc-thai-binh-duong.jpg",
                    LocalDateTime.of(2024, 6, 18, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p006",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p007",
                    "Lễ khởi công dự án sân bay Long Thành",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)),
            new NewsDTO(
                    "p008",
                    "Techgel khánh thành nhà ga T3 Tân Sơn Nhất",
                    NewsType.PROJECT,
                    "Techgel chính thức khánh thành nhà ga T3 sân bay Tân Sơn Nhất, đánh dấu cột mốc quan trọng trong việc tham gia vào các dự án hạ tầng giao thông trọng điểm quốc gia. Công trình được hoàn thành đúng tiến độ với tiêu chuẩn kỹ thuật cao, góp phần nâng cao năng lực phục vụ hành khách và thúc đẩy phát triển kinh tế khu vực phía Nam.",
                    "/imgs/news/nha-ga-t3-tt/khanh-thanh-t3-2.png",
                    LocalDateTime.of(2025, 4, 30, 0, 0)));

    List<LogoDTO> partnershipLogoList = List.of(
            new LogoDTO("p38", "GB Industrial", "/imgs/logos/partnership-logos/gbindustrial-logo.png",
                    "GB Industrial Logo", 1),
            new LogoDTO("p39", "Incotec", "/imgs/logos/partnership-logos/incotec-logo.png", "Incotec Logo", 2),
            new LogoDTO("p40", "Viet Thai", "/imgs/logos/partnership-logos/vietthai-logo.png", "Viet Thai Logo",
                    3),
            new LogoDTO("p41", "DVT", "/imgs/logos/partnership-logos/dvt-logo.png", "DVT Logo", 4),
            new LogoDTO("p42", "PNP", "/imgs/logos/partnership-logos/pnp-logo.png", "PNP Logo", 5));

    @GetMapping("")
    public String viewHomagePage(Model model) {

        List<Carousel> banners = carouselService.getAll();
        HomeAboutUs homeAboutUs = homeAboutUsService.getById(1L);
        HomeStatistic homeStatistic = homeStatisticService.getById(1L);
        List<HomeStatisticItems> homeStatisticItems = homeStatisticItemsService.getAll();
        HomeOurBusinessLine homeOurBusinessLine = homeOurBusinessLineService.getById(1L);
        List<WhatWeDoService> whatWeDoServices = whatWeDoServiceService.getAll();

        // Signature Projects
        List<SignatureProjectDTO> signatureProjectsCarousel = List.of(
      new SignatureProjectDTO(
              "Nhà ga T3 Sân bay Tân Sơn Nhất",
              "https://lh3.googleusercontent.com/OGs3rJJO8ojjjYhRTIxKtgrseMDz_m5cgEYJOk74MeVZl3BGB58b7JCxOqPpZqKHXznUeBWpkm0sa4Tjf0JyU4_lA0VzkREBtXf8ZKCs1GMVETrr_gkDke74WeaoDEB6h2_dGMMALgSBT_FtW6oGFftVaYIhky4S38GxuY0ls8bzSC-MH_7l0PhUAPtIMuGh",
              "Cảng hàng không Việt Nam",
              "Quận Tân Bình",
              "Tổng thầu MEP",
              "/projects/t3-terminal"),
      new SignatureProjectDTO(
              "Dwight School",
              "/imgs/projects/dwight-school-1.jpg",
              "Dwight School Hanoi",
              "Hà Nội",
              "Tổng thầy MEPF",
              "/projects/solar-recycling"),
      new SignatureProjectDTO(
              "Điện gió Thái Hòa",
              "/imgs/projects/thai_hoa_power_wind_farm.jpg",
              "Tập đoàn Thái Bình Dương",
              "39C7, Hòa Thắng, Bắc Bình, Bình Thuận",
              "Trạm biến áp 220kV, trạm chuyển mạch, đường dây truyền tải cáp ngầm 22KV",
              "/projects/solar-recycling"),
      new SignatureProjectDTO(
              "TTI",
              "https://newtecons.vn/wp-content/uploads/2023/06/1.-Southwest-conrner-1536x864.png",
              "EVN",
              "Đường 27, khu công nghiệp Việt Nam, xã Vĩnh Tân, TP. Tân Uyên, tỉnh Bình Dương",
              "Tổng thầu MEP",
              "/projects/solar-recycling"),
      new SignatureProjectDTO(
              "Golden Hotel Đà Lạt",
              "/imgs/projects/golden-da-lat.webp",
              "Công ty Cổ phần Golden City",
              "Đà Lạt, Lâm Đồng",
              "Tổng thầu MEP",
              "/projects/solar-recycling"));


        model.addAttribute("banners", banners);
        model.addAttribute("homeAboutUs", homeAboutUs);
        model.addAttribute("homeStatistic", homeStatistic);
        model.addAttribute("homeStatisticItems", homeStatisticItems);
        model.addAttribute("homeOurBusinessLine", homeOurBusinessLine);
        model.addAttribute("whatWeDoServices", whatWeDoServices);
        model.addAttribute("signatureProjects", signatureProjectsCarousel);
        model.addAttribute("partnershipLogos", partnershipLogoList);

        return "clients/home/home";
    }
    
    @GetMapping("/profile")
    public String viewEProfile(){
        return "clients/profile";
    }

    @GetMapping({"/about-us", "/about-us/overview"})
    public String viewIntroduce(Model model){
        AboutUsIntroduce aboutUsIntroduce = aboutUsIntroduceService.getById(1L);
        EProfile eProfile = eProfileService.getById(1L);
        AboutUsTestimonial aboutUsTestimonial = aboutUsTestimonialService.getById(1L);
        List<AboutUsTestimonialItems> aboutUsTestimonialItems = aboutUsTestimonialItemsService.getAll();

        model.addAttribute("aboutUsIntroduce", aboutUsIntroduce);
        model.addAttribute("eProfile", eProfile);
        model.addAttribute("aboutUsTestimonial", aboutUsTestimonial);
        model.addAttribute("aboutUsTestimonialItems", aboutUsTestimonialItems);
        model.addAttribute("partnershipLogos", partnershipLogoList);

        return "clients/about-us/introduce";
    }

    @GetMapping("/about-us/organizational-chart")
    public String viewOrganizationalChart(Model model){
        AboutUsOrganizationalChart aboutUsOrganizationalChart = aboutUsOrganizationalService.getById(1L);
        List<AboutUsOrganizationalChartItems> aboutUsOrganizationalChartItems = aboutUsOrganizationalChartItemsService.getAll();
        model.addAttribute("aboutUsOrganizationalChart", aboutUsOrganizationalChart);
        model.addAttribute("aboutUsOrganizationalChartItems", aboutUsOrganizationalChartItems);

        return "clients/about-us/organizational-chart";
    }

    @GetMapping("/about-us/vision-mission-values")
    public String viewVisionMissionValues() {
        return "clients/about-us/vision-mission-values";
    }

    @GetMapping("/about-us/licenses-certificates")
    public String viewLicensesCertificates(Model model){
        List<AboutUsLicenseCertificate> aboutUsLicenseCertificates = aboutUsLicenseCertificateService.getAll();
        model.addAttribute("aboutUsLicenseCertificates", aboutUsLicenseCertificates);

        return "clients/about-us/licenses-certificates";
    }

    @GetMapping("/about-us/clients-partners")
    public String viewClientsPartners(Model model) {
        List<AboutUsClientPartner> aboutUsClientPartners = aboutUsClientPartnerService.getAll();
        model.addAttribute("aboutUsClientPartners", aboutUsClientPartners);

        return "clients/about-us/clients-partners";
    }

    @GetMapping("/about-us/shareholder")
    public String viewShareholder() {
        return "clients/shareholder/shareholder";
    }

    @GetMapping({ "/projects", "/projects/{slug}" })
    public String viewProjects(Model model, @PathVariable(required = false) String slug) {
        List<ProjectCategory> projectCategories = projectCategoryService.getAll();
        if(!slug.isBlank()){}

        model.addAttribute("projectCategories", projectCategories);
        return "clients/projects";
    }

    @GetMapping("/what-we-do/our-business-lines")
    public String viewOurBusinessLines() {
        return "clients/what-we-do/our-business-lines";
    }

    @GetMapping("/what-we-do/sustainable-development")
    public String viewSustainableDevelopment() {
        return "clients/what-we-do/sustainable-development";
    }

    @GetMapping("/what-we-do/gallery")
    public String viewConstructionGallery() {
        return "clients/what-we-do/construction-gallery";
    }

    @GetMapping("/contact-us")
    public String viewContactUs() {
        return "clients/contact-us";
    }

    private NewsType parseNewsType(String type) {
        try {
            return NewsType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            return NewsType.PROJECT;

        }

        @GetMapping("/profile")
        public String viewEProfile() {
                return "clients/profile";
        }

        @GetMapping({ "/about-us", "/about-us/overview" })
        public String viewIntroduce(Model model) {
                AboutUsIntroduce aboutUsIntroduce = aboutUsIntroduceService.getById(1L);
                EProfile eProfile = eProfileService.getById(1L);
                AboutUsTestimonial aboutUsTestimonial = aboutUsTestimonialService.getById(1L);
                List<AboutUsTestimonialItems> aboutUsTestimonialItems = aboutUsTestimonialItemsService.getAll();

                model.addAttribute("aboutUsIntroduce", aboutUsIntroduce);
                model.addAttribute("eProfile", eProfile);
                model.addAttribute("aboutUsTestimonial", aboutUsTestimonial);
                model.addAttribute("aboutUsTestimonialItems", aboutUsTestimonialItems);
                model.addAttribute("partnershipLogos", partnershipLogoList);

                return "clients/about-us/introduce";
        }

        @GetMapping("/about-us/organizational-chart")
        public String viewOrganizationalChart(Model model) {
                AboutUsOrganizationalChart aboutUsOrganizationalChart = aboutUsOrganizationalService.getById(1L);
                List<AboutUsOrganizationalChartItems> aboutUsOrganizationalChartItems = aboutUsOrganizationalChartItemsService
                                .getAll();
                model.addAttribute("aboutUsOrganizationalChart", aboutUsOrganizationalChart);
                model.addAttribute("aboutUsOrganizationalChartItems", aboutUsOrganizationalChartItems);

                return "clients/about-us/organizational-chart";
        }

        @GetMapping("/about-us/vision-mission-values")
        public String viewVisionMissionValues() {
                return "clients/about-us/vision-mission-values";
        }

        @GetMapping("/about-us/licenses-certificates")
        public String viewLicensesCertificates(Model model) {
                List<AboutUsLicenseCertificate> aboutUsLicenseCertificates = aboutUsLicenseCertificateService.getAll();
                model.addAttribute("aboutUsLicenseCertificates", aboutUsLicenseCertificates);

                return "clients/about-us/licenses-certificates";
        }

        @GetMapping("/about-us/clients-partners")
        public String viewClientsPartners(Model model) {
                // Logos
                List<LogoDTO> clientLogoList = List.of(
                                new LogoDTO("p01", "Lotte Mart", "/imgs/logos/partnership-logos/lottemart-logo.png",
                                                "Lotte Mart Logo",
                                                1),
                                new LogoDTO("p02", "Bộ Ngoại Giao",
                                                "/imgs/logos/partnership-logos/bongoaigiao-logo.png",
                                                "Bộ Ngoại Giao Logo", 2),
                                new LogoDTO("p03", "Dwight School Hanoi",
                                                "/imgs/logos/partnership-logos/dwight-logo.png",
                                                "Dwight School Ha Noi Logo", 3),
                                new LogoDTO("p04", "AEFE", "/imgs/logos/partnership-logos/aefe-logo.png", "AEFE Logo",
                                                4),
                                new LogoDTO("p05", "The Sun Avenue",
                                                "/imgs/logos/partnership-logos/thesunavenue-logo.png",
                                                "The Sun Avenue Logo", 5),
                                new LogoDTO("p06", "Hoa Phat", "/imgs/logos/partnership-logos/hoaphat-logo.png",
                                                "Hoa Phat Logo", 6),
                                new LogoDTO("p07", "Kim Long Nam", "/imgs/logos/partnership-logos/kimlongnam-logo.png",
                                                "Kim Long Nam Logo", 7),
                                new LogoDTO("p08", "Hateco", "/imgs/logos/partnership-logos/hateco-logo.png",
                                                "Hateco Logo", 8),
                                new LogoDTO("p09", "BRG Group", "/imgs/logos/partnership-logos/brggroup-logo.png",
                                                "BRG Group Logo", 9),
                                new LogoDTO("p10", "Gamuda", "/imgs/logos/partnership-logos/gamuda-logo.png",
                                                "Gamuda Logo", 10),
                                new LogoDTO("p11", "Masterise Homes",
                                                "/imgs/logos/partnership-logos/masterisehomes-logo.png",
                                                "Masterise Homes Logo", 11),
                                new LogoDTO("p12", "Hoa Lam", "/imgs/logos/partnership-logos/hoalam-logo.png",
                                                "Hoa Lam Logo", 12),
                                new LogoDTO("p13", "Becamex", "/imgs/logos/partnership-logos/becamex-logo.png",
                                                "Becamex Logo", 13),
                                new LogoDTO("p14", "Crowne Plaza", "/imgs/logos/partnership-logos/crowne-logo.png",
                                                "Crowne Plaza Logo",
                                                14),
                                new LogoDTO("p15", "Constrexim", "/imgs/logos/partnership-logos/constrexim.png",
                                                "Constrexim Logo", 15),
                                new LogoDTO("p16", "Kenton Node", "/imgs/logos/partnership-logos/kentonnode-logo.png",
                                                "Kenton Node Logo", 16),
                                new LogoDTO("p17", "Pearl", "/imgs/logos/partnership-logos/pearl-logo.png",
                                                "Pearl Logo", 17),
                                new LogoDTO("p18", "Novaland", "/imgs/logos/partnership-logos/novaland-logo.png",
                                                "Novaland Logo", 18),
                                new LogoDTO("p19", "Sojo", "/imgs/logos/partnership-logos/sojo-logo.png", "Sojo Logo",
                                                19),
                                new LogoDTO("p20", "JW Marriott", "/imgs/logos/partnership-logos/jwmarriot-logo.png",
                                                "JW Marriott Logo", 20),
                                new LogoDTO("p21", "BB Group", "/imgs/logos/partnership-logos/bbgroup-logo.png",
                                                "BB Group Logo", 21),
                                new LogoDTO("p22", "APEC Mandala Vietnam",
                                                "/imgs/logos/partnership-logos/apecmandalavietnam-logo.png",
                                                "APEC Mandala Vietnam Logo", 22),
                                new LogoDTO("p23", "Palm Garden Resort",
                                                "/imgs/logos/partnership-logos/palmgardenresort-logo.png",
                                                "Palm Garden Resort Logo", 23),
                                new LogoDTO("p24", "Flamingo", "/imgs/logos/partnership-logos/flamingo-logo.png",
                                                "Flamingo Logo", 24),
                                new LogoDTO("p25", "SSSG", "/imgs/logos/partnership-logos/sssg-logo.png", "SSSG Logo",
                                                25),
                                new LogoDTO("p26", "Vinataba", "/imgs/logos/partnership-logos/vinataba-logo.png",
                                                "Vinataba Logo", 26),
                                new LogoDTO("p27", "Deltech", "/imgs/logos/partnership-logos/deltech-logo.png",
                                                "Deltech Logo", 27),
                                new LogoDTO("p28", "Schneider", "/imgs/logos/partnership-logos/schneider-logo.png",
                                                "Schneider Logo",
                                                28),
                                new LogoDTO("p29", "TTI", "/imgs/logos/partnership-logos/tti-logo.png", "TTI Logo", 29),
                                new LogoDTO("p30", "Metawater", "/imgs/logos/partnership-logos/metawater-logo.png",
                                                "Metawater Logo",
                                                30),
                                new LogoDTO("p31", "Black & Veatch",
                                                "/imgs/logos/partnership-logos/black&veatch-logo.png",
                                                "Black & Veatch Logo", 31),
                                new LogoDTO("p32", "EVN", "/imgs/logos/partnership-logos/evn-logo.png", "EVN Logo", 32),
                                new LogoDTO("p33", "Nexif", "/imgs/logos/partnership-logos/nexif-logo.png",
                                                "Nexif Logo", 33),
                                new LogoDTO("p34", "Pacific", "/imgs/logos/partnership-logos/pacific-logo.png",
                                                "Pacific Logo", 34),
                                new LogoDTO("p35", "VATM", "/imgs/logos/partnership-logos/vatm-logo.png", "VATM Logo",
                                                35),
                                new LogoDTO("p36", "AHT", "/imgs/logos/partnership-logos/aht-logo.png", "AHT Logo", 36),
                                new LogoDTO("p37", "Vingroup", "/imgs/logos/partnership-logos/vingroup-logo.png",
                                                "Vingroup Logo", 37));

                model.addAttribute("partnershipLogos", partnershipLogoList);
                model.addAttribute("clientLogos", clientLogoList);
                return "clients/about-us/clients-partners";
        }

        @GetMapping("/about-us/shareholder")
        public String viewShareholder() {
                return "clients/shareholder/shareholder";
        }

        @GetMapping({ "/projects", "/projects/{slug}" })
        public String viewProjects(@PathVariable(required = false) String slug) {
                return "clients/projects";
        }

        @GetMapping("/what-we-do/our-business-lines")
        public String viewOurBusinessLines() {
                return "clients/what-we-do/our-business-lines";
        }

        @GetMapping("/what-we-do/sustainable-development")
        public String viewSustainableDevelopment() {
                return "clients/what-we-do/sustainable-development";
        }

        @GetMapping("/what-we-do/gallery")
        public String viewConstructionGallery() {
                return "clients/what-we-do/construction-gallery";
        }

        @GetMapping("/contact-us")
        public String viewContactUs() {
                return "clients/contact-us";
        }

        private NewsType parseNewsType(String type) {
                try {
                        return NewsType.valueOf(type.toUpperCase());
                } catch (IllegalArgumentException e) {
                        return NewsType.PROJECT;
                }
        }

        @GetMapping("/news")
        public String getNewsPage(
                        @RequestParam(name = "type", defaultValue = "project") String type,
                        @RequestParam(name = "page", defaultValue = "1") int page,
                        Model model) {

                NewsType selectedType = parseNewsType(type);

                List<NewsDTO> allNews = Stream.of(projectNewsList, internalNewsList, trainingNewsList)
                                .flatMap(List::stream)
                                .filter(news -> news.getType() == selectedType)
                                .sorted(Comparator.comparing(NewsDTO::getPublishedAt).reversed())
                                .collect(Collectors.toList());

                model.addAttribute("newsList", allNews);
                model.addAttribute("type", type);

                // sidebar news
                List<NewsDTO> sidebarNews = allNews.size() > 4
                                ? allNews.subList(1, Math.min(4, allNews.size()))
                                : (allNews.size() > 1 ? allNews.subList(1, allNews.size()) : List.of());
                model.addAttribute("sidebarNews", sidebarNews);
                System.out.println("===== Project News List =====");
                for (NewsDTO news : allNews) {
                        System.out.println(news.getTitle());
                }

                // Pagination logic
                List<NewsDTO> usableNews = allNews.size() > 4 ? allNews.subList(4, allNews.size()) : List.of();

                int pageSize = 9;
                int totalPages = (int) Math.ceil((double) usableNews.size() / pageSize);

                // Avoid divide-by-zero and out-of-bounds
                if (totalPages == 0) {
                        page = 1;
                } else {
                        page = Math.max(1, Math.min(page, totalPages));
                }

                int fromIndex = (page - 1) * pageSize;
                int toIndex = Math.min(fromIndex + pageSize, usableNews.size());

                List<NewsDTO> paginatedNews = (fromIndex < toIndex)
                                ? usableNews.subList(fromIndex, toIndex)
                                : List.of(); // fallback empty

                model.addAttribute("newsListPaged", paginatedNews);
                model.addAttribute("currentPage", page);
                model.addAttribute("totalPages", totalPages);

                return "clients/news/news";
        }

        @GetMapping("/news-details")
        public String viewNewsDetails() {
                return "clients/news/news-details";
        }

        @GetMapping("/careers/job-opportunities")
        public String viewJobOpportunities() {
                return "clients/careers/job-opportunities";
        }

        @GetMapping("/careers/hr-policies")
        public String viewHrPolicies() {
                return "clients/careers/hr-policies";
        }

        @GetMapping("/careers/cultural-techgel")
        public String viewCulturalTechgel() {
                return "clients/careers/cultural-techgel";
        }
}
