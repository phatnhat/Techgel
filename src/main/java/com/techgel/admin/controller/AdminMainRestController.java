package com.techgel.admin.controller;

import com.techgel.admin.GoogleDriveService;
import com.techgel.common.entity.adminSettings.Carousel;
import com.techgel.common.entity.adminSettings.HomeStatisticItems;
import com.techgel.common.service.CarouselService;
import com.techgel.common.service.HomeStatisticItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequiredArgsConstructor
@RequestMapping("/webadmin")
public class AdminMainRestController {
    private final CarouselService carouselService;
    private final HomeStatisticItemsService homeStatisticItemsService;
    private final GoogleDriveService googleDriveService;

    @DeleteMapping("/home/carousel/delete/{id}")
    public ResponseEntity<String> deleteCarousel(@PathVariable Long id,
                                                 @RequestParam String image_url){
        try{
            Carousel carousel = carouselService.getById(id);
            if(carousel != null){
                carouselService.deleteById(id);
            }else throw new Exception();
        }catch (Exception e){
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi xóa");
        }

        return ResponseEntity.ok("Delete successfully!");
    }

    @DeleteMapping("/home/statistic-items/delete/{id}")
    public ResponseEntity<String> deleteStatisticItems(@PathVariable Long id){
        try{
            HomeStatisticItems homeStatisticItems = homeStatisticItemsService.getById(id);
            if(homeStatisticItems != null){
                homeStatisticItemsService.deleteById(id);
            }else throw new Exception();
        }catch (Exception e){
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi xóa");
        }

        return ResponseEntity.ok("Delete successfully!");
    }
}
