package org.example.frotavivapostgreapi.service;

import com.google.firebase.auth.FirebaseToken;

public interface FirebaseAuthService {
    FirebaseToken verifyIdToken(String idToken);
    String extractUserEmail(FirebaseToken decodedToken);
    String extractUserUid(FirebaseToken decodedToken);
}