package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.dto.AuthRequestDTO;
import org.example.frotavivapostgreapi.dto.AuthResponseDTO;
import org.example.frotavivapostgreapi.dto.FirebaseAuthRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface AuthController {
    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody AuthRequestDTO authRequestDTO);
    
    @PostMapping("/firebase")
    ResponseEntity<AuthResponseDTO> authenticateWithFirebase(@RequestBody FirebaseAuthRequestDTO request);
}