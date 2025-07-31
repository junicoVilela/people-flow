package com.vilelatech.rh.ports;

import com.vilelatech.rh.domain.model.UsuarioModel;

import java.util.Optional;

public interface UsuarioRepository {
    UsuarioModel salvar(UsuarioModel usuario);
    Optional<UsuarioModel> buscarPorId(Long id);
    Optional<UsuarioModel> buscarPorEmail(String email);
    boolean existePorEmail(String email);
    void excluirPorId(Long id);
} 