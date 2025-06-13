package com.vilelatech.rh.application.usecase.auth;

import com.vilelatech.rh.application.dto.auth.LoginRequest;
import com.vilelatech.rh.application.dto.auth.LoginResponse;
import com.vilelatech.rh.domain.model.UsuarioModel;
import com.vilelatech.rh.ports.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUseCase {
    private final UsuarioRepository usuarioRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request) {
        UsuarioModel usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Credenciais inválidas"));

        // Usando PasswordEncoder (que agora faz comparação direta sem criptografia)
        if (!passwordEncoder.matches(request.getSenha(), usuario.getSenhaHash())) {
            throw new BadCredentialsException("Credenciais inválidas");
        }

        if (!usuario.isAtivo()) {
            throw new BadCredentialsException("Usuário inativo");
        }

        String token = jwtProvider.generateToken(usuario);

        return LoginResponse.builder()
                .token(token)
                .usuarioId(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .role(usuario.getRole())
                .build();
    }
} 