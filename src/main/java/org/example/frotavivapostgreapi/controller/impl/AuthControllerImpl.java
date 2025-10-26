package org.example.frotavivapostgreapi.controller.impl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.frotavivapostgreapi.controller.AuthController;
import org.example.frotavivapostgreapi.dto.AuthRequestDTO;
import org.example.frotavivapostgreapi.dto.AuthResponseDTO;
import org.example.frotavivapostgreapi.dto.FirebaseAuthRequestDTO;
import org.example.frotavivapostgreapi.security.JwtUtil;
import org.example.frotavivapostgreapi.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("v1/api/auth")
@Tag(name = "Autenticação", description = "Endpoints para autenticação de usuários")
public class AuthControllerImpl implements AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final AuthService authService;
    
    public AuthControllerImpl(AuthenticationManager authenticationManager, 
                             JwtUtil jwtUtil, 
                             AuthService authService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.authService = authService;
    }

    @Override
    @Operation(summary = "Login tradicional", description = "Autenticação com usuário e senha")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO authRequestDTO) {
        String username = authRequestDTO.getUsername();
        String password = authRequestDTO.getPassword();

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(authentication);

        String token = jwtUtil.generateToken(username);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @Override
    @Operation(summary = "Autenticação Firebase", description = "Troca Firebase ID Token por JWT da API")
    public ResponseEntity<AuthResponseDTO> authenticateWithFirebase(@Valid @RequestBody FirebaseAuthRequestDTO request) {
        AuthResponseDTO response = authService.authenticateWithFirebase(request);
        return ResponseEntity.ok(response);
    }
}