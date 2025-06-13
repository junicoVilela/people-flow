package com.vilelatech.rh.domain.model;

import com.vilelatech.rh.domain.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {
    private Long id;
    private String nome;
    private String email;
    private String senhaHash;
    private Role role;
    private boolean ativo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
} 