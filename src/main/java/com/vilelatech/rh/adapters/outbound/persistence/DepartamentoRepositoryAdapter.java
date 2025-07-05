package com.vilelatech.rh.adapters.outbound.persistence;

import com.vilelatech.rh.adapters.outbound.persistence.repository.DepartamentoJpaRepository;
import com.vilelatech.rh.adapters.outbound.persistence.repository.RegistroPontoJpaRepository;
import com.vilelatech.rh.application.mapper.DepartamentoMapper;
import com.vilelatech.rh.application.mapper.RegistroPontoMapper;
import com.vilelatech.rh.domain.model.DepartamentoModel;
import com.vilelatech.rh.domain.model.RegistroPontoModel;
import com.vilelatech.rh.ports.DepartamentoRepository;
import com.vilelatech.rh.ports.RegistroPontoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DepartamentoRepositoryAdapter implements DepartamentoRepository {
    
    private final DepartamentoJpaRepository departamentoJpaRepository;
    private final DepartamentoMapper departamentoMapper;


    @Override
    public RegistroPontoModel save(DepartamentoModel departamentoModel) {
        return null;
    }

    @Override
    public Optional<DepartamentoModel> findById(Long id) {
        return Optional.empty();
    }
}