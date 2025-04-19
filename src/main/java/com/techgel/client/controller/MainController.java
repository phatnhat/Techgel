package com.techgel.client.controller;

import com.techgel.common.DTOs.SignatureProjectDTO;
import com.techgel.common.entity.adminSettings.*;
import com.techgel.common.entity.enums.NewsType;
import com.techgel.common.DTOs.LogoDTO;
import com.techgel.common.DTOs.NewsDTO;

import com.techgel.common.entity.enums.ProjectRegions;
import com.techgel.common.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.Year;
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
    private final NewsService newsService;

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

        model.addAttribute("banners", banners);
        model.addAttribute("homeAboutUs", homeAboutUs);
        model.addAttribute("homeStatistic", homeStatistic);
        model.addAttribute("homeStatisticItems", homeStatisticItems);
        model.addAttribute("homeOurBusinessLine", homeOurBusinessLine);
        model.addAttribute("whatWeDoServices", whatWeDoServices);
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
    public String viewProjects(Model model, @PathVariable(required = false) String slug,
                               @RequestParam(name = "years[]", required = false) List<Integer> years,
                               @RequestParam(name = "regions[]", required = false) List<String> regions) {
        List<ProjectCategory> projectCategories = projectCategoryService.getAll();

        List<Project> projects = null;

        if(slug == null) {
            projects = projectService.getAll();
        }else if(slug.equals("featured")){
            projects = projectService.getAllByFeaturedIsTrue();
        }else{
            projects = projectService.getAllByProjectCategorySlug(slug);
        }

        if(years != null){
            projects = projects.stream().filter(project ->
                    project != null &&
                    years.contains(project.getYear()))
                    .collect(Collectors.toList());
        }
        if(regions != null){
            projects = projects.stream().filter(project ->
                            project != null &&
                            project.getRegion() != null &
                            regions.contains(project.getRegion()))
                    .collect(Collectors.toList());
        }

        model.addAttribute("slug", slug);
        model.addAttribute("years_checked", years);
        model.addAttribute("regions_checked", regions);
        model.addAttribute("currentYear", Year.now().getValue());
        model.addAttribute("regions", ProjectRegions.values());
        model.addAttribute("projects", projects);
        model.addAttribute("projectCategories", projectCategories);

        return "clients/projects/projects";
    }

    @GetMapping("/project_details/{projectId}")
    public String viewProjectDetails(Model model, @PathVariable Long projectId){
        Project project = projectService.getById(projectId);

        model.addAttribute("project", project);

        return "clients/projects/project_details";
    }

    @GetMapping({"/what-we-do","/what-we-do/our-business-lines"})
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

    @GetMapping("/news")
    public String getNewsPage(
            @RequestParam(name = "type", defaultValue = "PROJECT") NewsType type,
            @RequestParam(name = "page", defaultValue = "1") int page,
            Model model) {

        int pageSize = 3;
        Pageable pageable = PageRequest.of(page - 1, pageSize);

        Page<News> allNews = newsService.getAllByType(type, pageable);

        model.addAttribute("newsList", allNews);
        model.addAttribute("currentType", type.name());

        model.addAttribute("newsListPaged", allNews);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", allNews.getTotalPages());
        model.addAttribute("newsTypeList", NewsType.values());

        return "clients/news/news";
    }

    @GetMapping("/news-details/{newsId}")
    public String viewNewsDetails(Model model, @PathVariable long newsId) {
        News news = newsService.getById(newsId);

        List<News> relatedNews = newsService.getAllByType(news.getType(), PageRequest.of(0, 2)).stream().toList();

        model.addAttribute("news", news);
        model.addAttribute("relatedNews", relatedNews);
        model.addAttribute("newsType", NewsType.values());

        return "clients/news/news-details";
    }

    @GetMapping({"/careers", "/careers/job-opportunities"})
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
