package com.vilelatech.rh.adapters.outbound.persistence;

import com.vilelatech.rh.application.mapper.UsuarioMapper;
import com.vilelatech.rh.adapters.outbound.persistence.repository.UsuarioJpaRepository;
import com.vilelatech.rh.domain.model.Usuario;
import com.vilelatech.rh.ports.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepository {
    
    private final UsuarioJpaRepository usuarioJpaRepository;
    private final UsuarioMapper usuarioMapper;
    
    @Override
    public Usuario save(Usuario usuario) {
        var entity = usuarioMapper.toEntity(usuario);
        entity = usuarioJpaRepository.save(entity);
        return usuarioMapper.toDomain(entity);
    }
    
    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioJpaRepository.findById(id)
                .map(usuarioMapper::toDomain);
    }
    
    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioJpaRepository.findByEmail(email)
                .map(usuarioMapper::toDomain);
    }
    
    @Override
    public boolean existsByEmail(String email) {
        return usuarioJpaRepository.existsByEmail(email);
    }
} 