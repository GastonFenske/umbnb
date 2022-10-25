package com.um;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

public class FirebaseAppInitialization {

    public static FirebaseApp main(String[] args) throws IOException {
        FileInputStream refreshToken = new FileInputStream("src/main/resources/serviceAccountKey.json");

        FirebaseOptions.Builder builder = FirebaseOptions.builder();
        builder.setProjectId("umbnb-demo");
        builder.setCredentials(GoogleCredentials.fromStream(refreshToken));
        FirebaseOptions options = builder
//            .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
                .build();

        return FirebaseApp.initializeApp(options);
    }

//    public Object download(String fileName) throws IOException {
//        String destFileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));
//        String destFilePath = "/home/ollyxs/repos/umbnb/src/main/resources/downloads/" + destFileName;
//    }

}
