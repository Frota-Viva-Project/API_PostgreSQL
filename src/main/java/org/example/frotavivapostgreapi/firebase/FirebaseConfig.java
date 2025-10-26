package org.example.frotavivapostgreapi.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initialize() {
        try {
            InputStream serviceAccount;

            String firebaseConfigPath = System.getenv("FIREBASE_CONFIG");

            if (firebaseConfigPath != null && !firebaseConfigPath.isEmpty()) {
                serviceAccount = new FileInputStream(firebaseConfigPath);
            } else {
                serviceAccount = new ClassPathResource("frota-viva-project-firebase-adminsdk.json").getInputStream();
            }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("Firebase Admin SDK inicializado com sucesso!");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao inicializar o Firebase Admin SDK: " + e.getMessage());
        }
    }
}