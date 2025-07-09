package com.vilelatech.rh.domain.model;

import com.vilelatech.rh.domain.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel extends BaseModel {
    private Long id;
    private String nome;
    private String email;
    private String senhaHash;
    private Role role;
    private boolean ativo;
} 