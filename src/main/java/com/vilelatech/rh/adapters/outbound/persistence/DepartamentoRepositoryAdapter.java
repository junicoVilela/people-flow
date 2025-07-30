package com.vilelatech.rh.adapters.outbound.persistence;

import com.vilelatech.rh.adapters.outbound.persistence.repository.DepartamentoJpaRepository;
import com.vilelatech.rh.adapters.outbound.persistence.specification.DepartamentoSpecification;
import com.vilelatech.rh.application.dto.departamento.DepartamentoFilter;
import com.vilelatech.rh.application.mapper.DepartamentoMapper;
import com.vilelatech.rh.domain.model.DepartamentoModel;
import com.vilelatech.rh.ports.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DepartamentoRepositoryAdapter implements DepartamentoRepository {
    
    private final DepartamentoJpaRepository departamentoJpaRepository;
    private final DepartamentoMapper departamentoMapper;

    @Override
    public DepartamentoModel save(DepartamentoModel departamentoModel) {
        var departamentoEntity = departamentoMapper.toEntity(departamentoModel);
        var savedEntity = departamentoJpaRepository.save(departamentoEntity);
        return departamentoMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<DepartamentoModel> findById(Long id) {
        return departamentoJpaRepository.findById(id)
                .map(departamentoMapper::toDomain);
    }

    @Override
    public List<DepartamentoModel> findAll() {
        return departamentoJpaRepository.findByAtivoTrue()
                .stream()
                .map(departamentoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Page<DepartamentoModel> findAll(DepartamentoFilter filter, Pageable pageable) {
        return departamentoJpaRepository.findAll(DepartamentoSpecification.withFilters(filter), pageable)
                .map(departamentoMapper::toDomain);
    }

    @Override
    public boolean existsByNomeAndAtivoTrue(String nome) {
        return departamentoJpaRepository.existsByNomeAndAtivoTrue(nome);
    }

    @Override
    public boolean existsByNomeAndAtivoTrueAndIdNot(String nome, Long id) {
        return departamentoJpaRepository.existsByNomeAndAtivoTrueAndIdNot(nome, id);
    }

    @Override
    public void deleteById(Long id) {
        departamentoJpaRepository.deleteById(id);
    }

    @Override
    public int quantidadePorStatus(Boolean status) {
        return departamentoJpaRepository.countByStatus(status);
    }
}