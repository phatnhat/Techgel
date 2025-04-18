package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.WhatWeDoService;

import java.util.List;

public abstract class WhatWeDoServiceData {
    public static List<WhatWeDoService> get(){
        WhatWeDoService item1 = new WhatWeDoService(1L, "Năng lượng", "Energy", 1, "/imgs/solar_energy.jpg", "");
        WhatWeDoService item2 = new WhatWeDoService(2L, "Công trình nhà ga", "Aviation", 2, "https://hips.hearstapps.com/hmg-prod/images/gettyimages-637243664-1520356722.jpg?resize=640:*", "");
        WhatWeDoService item3 = new WhatWeDoService(3L, "Công nghiệp", "Industry", 3, "https://d2csxpduxe849s.cloudfront.net/media/E32629…4925E4/WebsiteJpg_XL-FIENG_Main%20Visual_Cyan.jpg", "");
        WhatWeDoService item4 = new WhatWeDoService(4L, "Dân dụng", "Civil", 4, "https://5.imimg.com/data5/SELLER/Default/2024/7/43…43654/building-construction-services-500x500.jpeg", "");
        WhatWeDoService item5 = new WhatWeDoService(5L, "Hạ tầng giao thông", "Infrastructure", 5, "https://www.letsbuild.com/wp-content/uploads/2023/07/types-of-infrastructure.jpeg", "");
        WhatWeDoService item6 = new WhatWeDoService(6L, "Công nghệ", "Technology", 6, "https://cdn.britannica.com/84/203584-131-357FBE7D/speed-internet-technology-background.jpg", "");

        return List.of(item1, item2, item3, item4, item5, item6);
    }
}
