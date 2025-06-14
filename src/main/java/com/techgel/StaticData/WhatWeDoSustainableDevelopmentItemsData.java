package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.WhatWeDoSustainableDevelopment;
import com.techgel.common.entity.adminSettings.WhatWeDoSustainableDevelopmentItems;

import java.util.List;

public abstract class WhatWeDoSustainableDevelopmentItemsData {
        public static List<WhatWeDoSustainableDevelopmentItems> get() {
                return List.of(
                        new WhatWeDoSustainableDevelopmentItems(1L, "Cam kết với người lao động", "Commitment to Employees",
                                "/imgs/sustainable-development/emp.jpg",
                                "Cam kết xây dựng môi trường làm việc công bằng, nơi mỗi cá nhân tài năng được trao cơ hội để vươn xa trong sự nghiệp.",
                                "We are committed to creating a fair workplace where every talented individual is given the opportunity to grow and advance in their career."),

                        new WhatWeDoSustainableDevelopmentItems(2L, "Cam kết với Cổ đông", "Commitment to Shareholders",
                                "/imgs/sustainable-development/shareholder.jpg",
                                "Cam kết minh bạch, phản hồi kịp thời và tạo giá trị bền vững cho cổ đông.",
                                "We are committed to transparency, timely responsiveness, and creating long-term sustainable value for our shareholders."),

                        new WhatWeDoSustainableDevelopmentItems(3L, "Cam kết với Đối tác", "Commitment to Partners",
                                "/imgs/sustainable-development/partners.jpg",
                                "Cam kết xây dựng môi trường làm việc công bằng, nơi mỗi cá nhân tài năng được trao cơ hội để vươn xa trong sự nghiệp.",
                                "We are committed to creating a fair and inclusive working environment where every talented individual is given the opportunity to grow and thrive in their career."),

                        new WhatWeDoSustainableDevelopmentItems(4L, "Cam kết với Cộng đồng & Xã hội", "Commitment to Community & Society",
                                "/imgs/sustainable-development/esg.jpg",
                                "Cam kết trách nhiệm, gắn bó với ESG, lan toả giá trị nhân văn và cộng đồng.",
                                "We are committed to responsibility and long-term dedication to ESG principles, promoting humanistic values and fostering positive impact within the community.")
                );
        }
}
