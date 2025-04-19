package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.WhatWeDoService;

import java.util.List;

public abstract class WhatWeDoServiceData {
    public static List<WhatWeDoService> get() {
        WhatWeDoService item1 = new WhatWeDoService(1L, "Năng lượng", "Energy", 1, "/imgs/home/solar_energy.jpg", "");
        WhatWeDoService item2 = new WhatWeDoService(2L, "Công trình nhà ga", "Aviation", 2,
                "/imgs/home/airport_terminal.jpg", "");
        WhatWeDoService item3 = new WhatWeDoService(3L, "Công nghiệp", "Industry", 3, "/imgs/home/cong-nghiep.webp",
                "");
        WhatWeDoService item4 = new WhatWeDoService(4L, "Dân dụng", "Civil", 4, "imgs/home/construction.jpg", "");
        WhatWeDoService item5 = new WhatWeDoService(5L, "Hạ tầng giao thông", "Infrastructure", 5,
                "https://www.letsbuild.com/wp-content/uploads/2023/07/types-of-infrastructure.jpeg", "");
        WhatWeDoService item6 = new WhatWeDoService(6L, "Công nghệ", "Technology", 6,
                "https://cdn.britannica.com/84/203584-131-357FBE7D/speed-internet-technology-background.jpg", "");

        return List.of(item1, item2, item3, item4, item5, item6);
    }
}
