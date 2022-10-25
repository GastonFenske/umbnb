package com.um.services;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class FileService {
    private static String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("umbnb-demo.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/png").build();
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("src/main/resources/serviceAccountKey.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        return String.format("https://firebasestorage.googleapis.com/v0/b/umbnb-demo.appspot.com/o/%s?alt=media",
                URLEncoder.encode(fileName, StandardCharsets.UTF_8));
    }

    private static File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
        }
        return tempFile;
    }

    private static String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static Object upload(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();
            assert fileName != null;
            fileName = UUID.randomUUID().toString().concat(getExtension(fileName));

            File file = convertToFile(multipartFile, fileName);
            String TEMP_URL = uploadFile(file, fileName);
            file.delete();
            return (TEMP_URL);
        } catch (Exception e) {
            e.printStackTrace();
            return ("Unsuccessful Uploaded!");
        }
    }

    public static Object download(String fileName) throws IOException {
        String destFileName = UUID.randomUUID().toString().concat(getExtension(fileName));
        String destFilePath = "/home/ollyxs/Imágenes/" + destFileName;

        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("src/main/resources/serviceAccountKey.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        Blob blob = storage.get(BlobId.of("umbnb-demo.appspot.com", fileName));
        blob.downloadTo(Paths.get(destFilePath));
        return ("Successfully Downloaded!");
    }
}
