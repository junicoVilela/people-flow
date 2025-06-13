package com.vilelatech.rh.adapters.outbound.persistence;

import com.vilelatech.rh.application.mapper.RegistroPontoMapper;
import com.vilelatech.rh.adapters.outbound.persistence.repository.RegistroPontoJpaRepository;
import com.vilelatech.rh.domain.model.RegistroPontoModel;
import com.vilelatech.rh.ports.RegistroPontoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RegistroPontoRepositoryAdapter implements RegistroPontoRepository {
    
    private final RegistroPontoJpaRepository registroPontoJpaRepository;
    private final RegistroPontoMapper registroPontoMapper;
    
    @Override
    public RegistroPontoModel save(RegistroPontoModel registroPonto) {
        var entity = registroPontoMapper.toEntity(registroPonto);
        entity = registroPontoJpaRepository.save(entity);
        return registroPontoMapper.toDomain(entity);
    }
    
    @Override
    public Optional<RegistroPontoModel> findById(Long id) {
        return registroPontoJpaRepository.findById(id)
                .map(registroPontoMapper::toDomain);
    }
    
    @Override
    public List<RegistroPontoModel> findByColaboradorId(Long colaboradorId) {
        return registroPontoJpaRepository.findByColaboradorId(colaboradorId).stream()
                .map(registroPontoMapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<RegistroPontoModel> findByColaboradorIdAndDataRegistroBetween(Long colaboradorId, LocalDate inicio, LocalDate fim) {
        return registroPontoJpaRepository.findByColaboradorIdAndDataRegistroBetween(colaboradorId, inicio, fim).stream()
                .map(registroPontoMapper::toDomain)
                .collect(Collectors.toList());
    }
} 