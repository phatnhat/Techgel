package com.techgel.admin;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class DriveProxyController {

    @GetMapping("/api/drive-proxy")
    public void getDriveFile(@RequestParam String id,
                             @RequestParam(name = "mediaType") String mediaType,
                             HttpServletResponse response) throws IOException {
        String driveUrl = "https://drive.usercontent.google.com/download?id=" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<byte[]> driveResponse = restTemplate.getForEntity(driveUrl, byte[].class);

        if(mediaType.equalsIgnoreCase("image")){
            response.setContentType(MediaType.IMAGE_PNG_VALUE);
        }else if(mediaType.equalsIgnoreCase("pdf")){
            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        }else{
            response.setContentType(MediaType.ALL_VALUE);
        }

        response.getOutputStream().write(driveResponse.getBody());
    }
}