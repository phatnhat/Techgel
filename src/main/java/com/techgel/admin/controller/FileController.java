package com.techgel.admin.controller;

import com.techgel.common.entity.adminSettings.EProfile;
import com.techgel.common.service.EProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private final Path uploadDir = Paths.get("uploads");

    @Autowired
    private EProfileService eProfileService;

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(
            @RequestParam("filepond") MultipartFile file,
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

            EProfile eProfile = eProfileService.getById(Long.valueOf(id));
            eProfile.setImage_url(destination.toString());
            eProfileService.update(eProfile);

            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

            return ResponseEntity.ok().body(newFilename);
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi upload: " + e.getMessage());
        }
    }

    @DeleteMapping("/{filename}")
    public ResponseEntity<String> deleteFile(@PathVariable String filename,
                                             @RequestParam(name = "id") String id) {
        System.out.println("***************************");
        System.out.println(id);
        try {
            Path filePath = uploadDir.resolve(filename).normalize();

            if (!filePath.startsWith(uploadDir.normalize())) {
                return ResponseEntity.badRequest().body("Invalid file path");
            }

            if (Files.exists(filePath)) {
                Files.delete(filePath);

                EProfile eProfile = eProfileService.getById(Long.valueOf(id));
                eProfile.setImage_url(null);
                eProfileService.update(eProfile);

                return ResponseEntity.ok("File deleted successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("Could not delete file: " + e.getMessage());
        }
    }
}
