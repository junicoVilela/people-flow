package com.vilelatech.rh.adapters.outbound.persistence;

import com.vilelatech.rh.application.mapper.ColaboradorMapper;
import com.vilelatech.rh.adapters.outbound.persistence.repository.ColaboradorJpaRepository;
import com.vilelatech.rh.domain.model.Colaborador;
import com.vilelatech.rh.domain.model.Status;
import com.vilelatech.rh.ports.ColaboradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ColaboradorRepositoryAdapter implements ColaboradorRepository {
    
    private final ColaboradorJpaRepository colaboradorJpaRepository;
    private final ColaboradorMapper colaboradorMapper;
    
    @Override
    public Colaborador save(Colaborador colaborador) {
        var entity = colaboradorMapper.toEntity(colaborador);
        entity = colaboradorJpaRepository.save(entity);
        return colaboradorMapper.toDomain(entity);
    }
    
    @Override
    public Optional<Colaborador> findById(Long id) {
        return colaboradorJpaRepository.findById(id)
                .map(colaboradorMapper::toDomain);
    }
    
    @Override
    public Optional<Colaborador> findByUsuarioId(Long usuarioId) {
        return colaboradorJpaRepository.findByUsuarioId(usuarioId)
                .map(colaboradorMapper::toDomain);
    }
    
    @Override
    public List<Colaborador> findAll() {
        return colaboradorJpaRepository.findAll().stream()
                .map(colaboradorMapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Page<Colaborador> findAll(Pageable pageable) {
        return colaboradorJpaRepository.findAll(pageable)
                .map(colaboradorMapper::toDomain);
    }
    
    @Override
    public List<Colaborador> findByStatus(Status status) {
        return colaboradorJpaRepository.findByStatus(status).stream()
                .map(colaboradorMapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public boolean existsByCpf(String cpf) {
        return colaboradorJpaRepository.existsByCpf(cpf);
    }
} 