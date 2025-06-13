package com.vilelatech.rh.application.dto.auth;

import com.vilelatech.rh.domain.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private Long usuarioId;
    private String nome;
    private String email;
    private Role role;
} 