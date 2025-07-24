package com.vilelatech.rh.adapters.outbound.persistence;

import com.vilelatech.rh.application.dto.colaborador.ColaboradorFilter;
import com.vilelatech.rh.application.mapper.ColaboradorMapper;
import com.vilelatech.rh.adapters.outbound.persistence.repository.ColaboradorJpaRepository;
import com.vilelatech.rh.adapters.outbound.persistence.specification.ColaboradorSpecification;
import com.vilelatech.rh.domain.model.ColaboradorModel;
import com.vilelatech.rh.domain.model.enums.StatusColaborador;
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
    public ColaboradorModel save(ColaboradorModel colaboradorModel) {
        var entity = colaboradorMapper.toEntity(colaboradorModel);
        entity = colaboradorJpaRepository.save(entity);
        return colaboradorMapper.toDomain(entity);
    }
    
    @Override
    public Optional<ColaboradorModel> findById(Long id) {
        return colaboradorJpaRepository.findById(id)
                .map(colaboradorMapper::toDomain);
    }
    
    @Override
    public List<ColaboradorModel> findByStatusWithUsuarioAndCargoAndDepartamento(StatusColaborador status) {
        return colaboradorJpaRepository.findByStatusWithUsuarioAndCargoAndDepartamento(status).stream()
                .map(colaboradorMapper::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public boolean existsByCpf(String cpf) {
        return colaboradorJpaRepository.existsByCpf(cpf);
    }

    @Override
    public Page<ColaboradorModel> findAllWithFilters(ColaboradorFilter filter, Pageable pageable) {
        return colaboradorJpaRepository.findAll(ColaboradorSpecification.withFilters(filter), pageable)
                .map(colaboradorMapper::toDomain);
    }
    
    @Override
    public void delete(ColaboradorModel colaboradorModel) {
        colaboradorJpaRepository.delete(colaboradorMapper.toEntity(colaboradorModel));
    }
} 