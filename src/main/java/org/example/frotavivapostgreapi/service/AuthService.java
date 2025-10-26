package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.dto.AuthResponseDTO;
import org.example.frotavivapostgreapi.dto.FirebaseAuthRequestDTO;

public interface AuthService {
    AuthResponseDTO authenticateWithFirebase(FirebaseAuthRequestDTO request);
}