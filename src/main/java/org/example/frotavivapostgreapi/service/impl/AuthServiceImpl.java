package org.example.frotavivapostgreapi.service.impl;

import com.google.firebase.auth.FirebaseToken;
import org.example.frotavivapostgreapi.dto.AuthResponseDTO;
import org.example.frotavivapostgreapi.dto.FirebaseAuthRequestDTO;
import org.example.frotavivapostgreapi.exception.AuthenticationException;
import org.example.frotavivapostgreapi.model.Motorista;
import org.example.frotavivapostgreapi.repository.MotoristaRepository;
import org.example.frotavivapostgreapi.security.JwtUtil;
import org.example.frotavivapostgreapi.service.AuthService;
import org.example.frotavivapostgreapi.service.FirebaseAuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Value("${spring.security.user.name}")
    private String username;

    private final FirebaseAuthService firebaseAuthService;
    private final MotoristaRepository motoristaRepository;
    private final JwtUtil jwtUtil;
    
    public AuthServiceImpl(FirebaseAuthService firebaseAuthService, 
                          MotoristaRepository motoristaRepository, 
                          JwtUtil jwtUtil) {
        this.firebaseAuthService = firebaseAuthService;
        this.motoristaRepository = motoristaRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthResponseDTO authenticateWithFirebase(FirebaseAuthRequestDTO request) {
        try {
            FirebaseToken decodedToken = firebaseAuthService.verifyIdToken(request.getFirebaseIdToken());
            
            String firebaseUid = firebaseAuthService.extractUserUid(decodedToken);
            String email = firebaseAuthService.extractUserEmail(decodedToken);
            
            System.out.println("Usuário autenticado no Firebase: " + email + " (UID: " + firebaseUid + ")");

            String jwtToken = jwtUtil.generateToken(username);

            return new AuthResponseDTO(jwtToken, jwtUtil.getExpirationTime());
            
        } catch (AuthenticationException e) {
            throw e;
        } catch (Exception e) {
            System.err.println("Erro na autenticação Firebase: " + e.getMessage());
            throw new AuthenticationException("Falha na autenticação", e);
        }
    }
}