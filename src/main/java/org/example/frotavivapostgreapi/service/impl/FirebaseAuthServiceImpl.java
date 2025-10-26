package org.example.frotavivapostgreapi.service.impl;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.example.frotavivapostgreapi.exception.AuthenticationException;
import org.example.frotavivapostgreapi.service.FirebaseAuthService;
import org.springframework.stereotype.Service;

@Service
public class FirebaseAuthServiceImpl implements FirebaseAuthService {

    @Override
    public FirebaseToken verifyIdToken(String idToken) {
        try {
            return FirebaseAuth.getInstance().verifyIdToken(idToken);
        } catch (FirebaseAuthException e) {
            System.err.println("Erro ao verificar Firebase ID Token: " + e.getMessage());
            throw new AuthenticationException("Token Firebase inválido", e);
        }
    }

    @Override
    public String extractUserEmail(FirebaseToken decodedToken) {
        return decodedToken.getEmail();
    }

    @Override
    public String extractUserUid(FirebaseToken decodedToken) {
        return decodedToken.getUid();
    }
}