package com.techgel.admin.controller;

import com.techgel.admin.GoogleDriveService;
import com.techgel.common.entity.adminSettings.*;
import com.techgel.common.service.*;
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
    private final AboutUsTestimonialItemsService aboutUsTestimonialItemsService;
    private final AboutUsOrganizationalChartItemsService aboutUsOrganizationalChartItemsService;
    private final AboutUsLicenseCertificateService aboutUsLicenseCertificateService;
    private final AboutUsLicenseCertificateItemsService aboutUsLicenseCertificateItemsService;
    private final AboutUsClientPartnerService aboutUsClientPartnerService;
    private final AboutUsClientPartnerItemsService aboutUsClientPartnerItemsService;
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

    @DeleteMapping("/about-us/overview/testimonial-items/delete/{id}")
    public ResponseEntity<String> deleteTestimonialItems(@PathVariable Long id){
        try{
            AboutUsTestimonialItems aboutUsTestimonialItems = aboutUsTestimonialItemsService.getById(id);
            if(aboutUsTestimonialItems != null){
                aboutUsTestimonialItemsService.deleteById(id);
            }else throw new Exception();
        }catch (Exception e){
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi xóa");
        }

        return ResponseEntity.ok("Delete successfully!");
    }

    @DeleteMapping("/about-us/organizational-chart-items/delete/{id}")
    public ResponseEntity<String> deleteOrganizationalChartItems(@PathVariable Long id){
        try{
            AboutUsOrganizationalChartItems aboutUsOrganizationalChartItems = aboutUsOrganizationalChartItemsService.getById(id);
            if(aboutUsOrganizationalChartItems != null){
                aboutUsOrganizationalChartItemsService.deleteById(id);
            }else throw new Exception();
        }catch (Exception e){
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi xóa");
        }

        return ResponseEntity.ok("Delete successfully!");
    }

    @DeleteMapping("/about-us/licenses-certificates/delete/{id}")
    public ResponseEntity<String> deleteLicenseCertificate(@PathVariable Long id){
        try{
            AboutUsLicenseCertificate aboutUsLicenseCertificate = aboutUsLicenseCertificateService.getById(id);
            if(aboutUsLicenseCertificate != null){
                aboutUsLicenseCertificateService.deleteById(id);
            }else throw new Exception();
        }catch (Exception e){
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi xóa");
        }

        return ResponseEntity.ok("Delete successfully!");
    }

    @DeleteMapping("/about-us/licenses-certificates-items/delete/{id}")
    public ResponseEntity<String> deleteLicenseCertificateItems(@PathVariable Long id){
        try{
            AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems = aboutUsLicenseCertificateItemsService.getById(id);
            if(aboutUsLicenseCertificateItems != null){
                aboutUsLicenseCertificateItemsService.deleteById(id);
            }else throw new Exception();
        }catch (Exception e){
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi xóa");
        }

        return ResponseEntity.ok("Delete successfully!");
    }

    @DeleteMapping("/about-us/clients-partners/delete/{id}")
    public ResponseEntity<String> deleteClientPartner(@PathVariable Long id){
        try{
            AboutUsClientPartner aboutUsClientPartner = aboutUsClientPartnerService.getById(id);
            if(aboutUsClientPartner != null){
                aboutUsClientPartnerService.deleteById(id);
            }else throw new Exception();
        }catch (Exception e){
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi xóa");
        }

        return ResponseEntity.ok("Delete successfully!");
    }

    @DeleteMapping("/about-us/clients-partners-items/delete/{id}")
    public ResponseEntity<String> deleteClientPartnerItems(@PathVariable Long id){
        try{
            AboutUsClientPartnerItems aboutUsClientPartnerItems = aboutUsClientPartnerItemsService.getById(id);
            if(aboutUsClientPartnerItems != null){
                aboutUsClientPartnerItemsService.deleteById(id);
            }else throw new Exception();
        }catch (Exception e){
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi xóa");
        }

        return ResponseEntity.ok("Delete successfully!");
    }
}
