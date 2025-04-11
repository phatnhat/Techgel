package com.techgel.admin;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoogleDriveService {

    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String APPLICATION_NAME = "Techgel Demo";
    private static final String FOLDER_ID = "1GC7jIz6H70NrHnChrFwoWbClQR9reZYW";

    private Drive createDriveService() throws GeneralSecurityException, IOException {
        GoogleCredential credential = GoogleCredential.fromStream(
                        getClass().getResourceAsStream("/credentials.json"))
                .createScoped(Collections.singleton(DriveScopes.DRIVE_FILE));

        return new Drive.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public String uploadFile(MultipartFile multipartFile) throws IOException, GeneralSecurityException {
        Drive driveService = createDriveService();

        // Tạo metadata file
        File fileMetadata = new File();
        fileMetadata.setName(multipartFile.getOriginalFilename());
        fileMetadata.setParents(Collections.singletonList(FOLDER_ID));

        // Upload content
        InputStreamContent mediaContent = new InputStreamContent(
                multipartFile.getContentType(),
                new ByteArrayInputStream(multipartFile.getBytes()));

        // Sử dụng resumable upload cho file lớn
        Drive.Files.Create create = driveService.files().create(fileMetadata, mediaContent);
        create.getMediaHttpUploader().setDirectUploadEnabled(false); // Bật chế độ resumable
        create.getMediaHttpUploader().setChunkSize(256 * 1024); // 256KB mỗi chunk

        File file = driveService.files().create(fileMetadata, mediaContent)
                .setFields("id, webViewLink")
                .execute();

        return file.getWebViewLink();
    }

    public void deleteFile(String fileId) throws GeneralSecurityException, IOException {
        Drive driveService = createDriveService();
        driveService.files().delete(fileId).execute();
    }

    public List<DriveFile> listFiles() throws GeneralSecurityException, IOException {
        Drive driveService = createDriveService();

        String query = "'" + FOLDER_ID + "' in parents";
        FileList result = driveService.files().list()
                .setQ(query)
                .setFields("files(id, name, webViewLink)")
                .execute();

        return result.getFiles().stream()
                .map(file -> new DriveFile(file.getId(), file.getName(), file.getWebViewLink()))
                .collect(Collectors.toList());
    }

}