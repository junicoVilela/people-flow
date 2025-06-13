package com.vilelatech.rh.ports;

import com.vilelatech.rh.domain.model.UsuarioModel;

import java.util.Optional;

public interface UsuarioRepository {
    UsuarioModel save(UsuarioModel usuario);
    Optional<UsuarioModel> findById(Long id);
    Optional<UsuarioModel> findByEmail(String email);
    boolean existsByEmail(String email);
} 