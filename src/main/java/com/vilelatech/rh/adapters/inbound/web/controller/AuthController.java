package com.vilelatech.rh.adapters.inbound.web.controller;

import com.vilelatech.rh.application.dto.auth.LoginRequest;
import com.vilelatech.rh.application.dto.auth.LoginResponse;
import com.vilelatech.rh.application.usecase.auth.AuthUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final AuthUseCase authUseCase;
    
    public AuthController(AuthUseCase authUseCase) {
        this.authUseCase = authUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = authUseCase.login(loginRequest);
        return ResponseEntity.ok(response);
    }
    

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // Implementar lógica de logout se necessário
        return ResponseEntity.ok("Logout realizado com sucesso");
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyToken() {
        return ResponseEntity.ok("Token válido");
    }
} 