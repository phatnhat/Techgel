package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.HomeStatisticItems;

import java.util.List;

public abstract class HomeStatisticItemsData {
    public static List<HomeStatisticItems> get(){
        HomeStatisticItems homeStatisticItem1 = new HomeStatisticItems(1L, "DỰ ÁN THI CÔNG", "CONSTRUCTION PROJECT", 100, 1, "+", "+");
        HomeStatisticItems homeStatisticItem2 = new HomeStatisticItems(2L, "TỔNG TÀI SẢN", "TOTAL ASSETS", 1.754, 2, "tỷ", "billion");
        HomeStatisticItems homeStatisticItem3 = new HomeStatisticItems(3L, "TỔNG SỐ NHÂN VIÊN", "TOTAL NUMBER OF EMPLOYEES", 450, 3, "+", "+");
        HomeStatisticItems homeStatisticItem4 = new HomeStatisticItems(4L, "LỰC LƯỢNG THI CÔNG", "CONSTRUCTION FORCE", 1000, 4, "+", "+");

        return List.of(homeStatisticItem1, homeStatisticItem2, homeStatisticItem3, homeStatisticItem4);
    }
}
