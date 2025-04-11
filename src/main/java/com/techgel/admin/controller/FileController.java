package com.techgel.admin.controller;

import com.techgel.admin.DriveFile;
import com.techgel.admin.GoogleDriveService;
import com.techgel.common.entity.adminSettings.Carousel;
import com.techgel.common.entity.adminSettings.EProfile;
import com.techgel.common.service.CarouselService;
import com.techgel.common.service.EProfileService;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private final Path uploadDir = Paths.get("uploads");

    private GoogleDriveService googleDriveService;

    public FileController(GoogleDriveService googleDriveService) {
        this.googleDriveService = googleDriveService;
    }

//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(
//            @RequestParam(name = "id") String id,
//            @RequestParam(name = "type") String type,
//            @RequestParam(name = "filepond") MultipartFile file) {
//        try {
//            String fileUrl = null;
//            Pattern pattern = Pattern.compile("/d/([a-zA-Z0-9_-]+)");
//
//            if(type.equalsIgnoreCase("eprofile-image")){
//                fileUrl = googleDriveService.uploadFile(file);
//                Matcher matcher = pattern.matcher(fileUrl);
//                if (matcher.find()) {
//                    EProfile eProfile = eProfileService.getById(Long.valueOf(id));
//                    eProfile.setImage_url(matcher.group(1));
//                    eProfileService.update(eProfile);
//                    return ResponseEntity.ok(matcher.group(1));
//                }else throw new Exception("Something wrong");
//            }else if(type.equalsIgnoreCase("eprofile-file")) {
//                fileUrl = googleDriveService.uploadFile(file);
//                Matcher matcher = pattern.matcher(fileUrl);
//                if (matcher.find()) {
//                    EProfile eProfile = eProfileService.getById(Long.valueOf(id));
//                    eProfile.setFile_url(matcher.group(1));
//                    eProfileService.update(eProfile);
//                    return ResponseEntity.ok(matcher.group(1));
//                } else throw new Exception("Something Wrong");
//            }else if(type.equalsIgnoreCase("carousel-image")){
//                fileUrl = googleDriveService.uploadFile(file);
//                Matcher matcher = pattern.matcher(fileUrl);
//                if (matcher.find()) {
//                    return ResponseEntity.ok(matcher.group(1));
//                }else throw new Exception("Something Wrong");
//            }else{
//                return ResponseEntity.internalServerError()
//                        .body("Failed to upload file");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError()
//                    .body("Failed to upload file: " + e.getMessage());
//        }
//    }
//
//    @DeleteMapping("/{filename}")
//    public ResponseEntity<String> deleteFile(@PathVariable String filename,
//                                             @RequestParam(name = "type") String type,
//                                             @RequestParam(name = "id") String id) {
//        try {
//            if(type.equalsIgnoreCase("eprofile-image")){
//                googleDriveService.deleteFile(filename);
//                EProfile eProfile = eProfileService.getById(Long.valueOf(id));
//                eProfile.setImage_url(null);
//                eProfileService.update(eProfile);
//            }else if(type.equalsIgnoreCase("eprofile-file")){
//                googleDriveService.deleteFile(filename);
//                EProfile eProfile = eProfileService.getById(Long.valueOf(id));
//                eProfile.setFile_url(null);
//                eProfileService.update(eProfile);
//            }else{
//                return ResponseEntity.internalServerError()
//                        .body("Lỗi khi xóa file");
//            }
//
//            return ResponseEntity.ok("Đã xóa file thành công");
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError()
//                    .body("Lỗi khi xóa file: " + e.getMessage());
//        }
//    }
//
//    @GetMapping("/files")
//    public ResponseEntity<List<DriveFile>> listFiles() {
//        try {
//            List<DriveFile> files = googleDriveService.listFiles();
//            return ResponseEntity.ok(files);
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
//        }
//    }


    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(
            @RequestParam("filepond") MultipartFile file,
            @RequestParam(name = "type") String type,
            @RequestParam(name = "id") String id) {
        try {
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("File không được để trống");
            }

            String originalFilename = file.getOriginalFilename();
            String newFilename = System.currentTimeMillis() + "_" + originalFilename;
            Path destination = uploadDir.resolve(newFilename);

            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

            return ResponseEntity.ok().body(newFilename);
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi upload: " + e.getMessage());
        }
    }

    @DeleteMapping("/{filename}")
    public ResponseEntity<String> deleteFile(@PathVariable String filename) {
        try {
            Path filePath = uploadDir.resolve(filename).normalize();

            if (!filePath.startsWith(uploadDir.normalize())) {
                return ResponseEntity.badRequest().body("Invalid file path");
            }

            if (Files.exists(filePath)) {
                Files.delete(filePath);

                return ResponseEntity.ok("File deleted successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("Could not delete file: " + e.getMessage());
        }
    }

    @GetMapping("/test")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("test ok");
    }

    @GetMapping("/auth")
    public Map<String, String> getAuthParams() {
        String privateKey = "private_kIkQXu7ysEJT/beBZA0P4FEETbs=";
        long expire = System.currentTimeMillis() / 1000 + 3600; // 1 giờ sau

        String signature = null;
        try {
            signature = HmacUtils.hmacSha1Hex(
                    privateKey,
                    expire + "public_ASvR2wFcF7VvLB6epCFVNodU38o="
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Map.of(
                "token", UUID.randomUUID().toString(),
                "expire", String.valueOf(expire),
                "signature", signature
        );
    }
}
