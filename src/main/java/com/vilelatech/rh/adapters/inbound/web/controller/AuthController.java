package com.vilelatech.rh.adapters.inbound.web.controller;

import com.vilelatech.rh.application.dto.auth.LoginRequest;
import com.vilelatech.rh.application.dto.auth.LoginResponse;
import com.vilelatech.rh.application.usecase.auth.AuthUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller REST para operações de autenticação.
 * Adapter de entrada para casos de uso de autenticação.
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    
    private final AuthUseCase authUseCase;
    
    public AuthController(AuthUseCase authUseCase) {
        this.authUseCase = authUseCase;
    }
    
    /**
     * Endpoint para login de usuários.
     * 
     * @param loginRequest dados de login
     * @return token JWT se autenticação for bem-sucedida
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = authUseCase.login(loginRequest);
        return ResponseEntity.ok(response);
    }
    
    /**
     * Endpoint para logout de usuários.
     * 
     * @return confirmação de logout
     */
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // Implementar lógica de logout se necessário
        return ResponseEntity.ok("Logout realizado com sucesso");
    }
    
    /**
     * Endpoint para verificar se o token é válido.
     * 
     * @return status do token
     */
    @GetMapping("/verify")
    public ResponseEntity<String> verifyToken() {
        return ResponseEntity.ok("Token válido");
    }
} 