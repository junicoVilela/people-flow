package com.vilelatech.rh.adapters.outbound.persistence;

import com.vilelatech.rh.adapters.outbound.persistence.repository.ColaboradorJpaRepository;
import com.vilelatech.rh.adapters.outbound.persistence.specification.ColaboradorSpecification;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorFilter;
import com.vilelatech.rh.application.mapper.ColaboradorMapper;
import com.vilelatech.rh.domain.model.ColaboradorModel;
import com.vilelatech.rh.domain.model.enums.StatusColaborador;
import com.vilelatech.rh.ports.ColaboradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ColaboradorRepositoryAdapter implements ColaboradorRepository {
    
    private final ColaboradorJpaRepository colaboradorJpaRepository;
    private final ColaboradorMapper colaboradorMapper;
    
    @Override
    public void salvar(ColaboradorModel colaboradorModel) {
        var entity = colaboradorMapper.toEntity(colaboradorModel);
        colaboradorJpaRepository.save(entity);
    }
    
    @Override
    public Optional<ColaboradorModel> buscarPorId(Long id) {
        return colaboradorJpaRepository.findById(id)
                .map(colaboradorMapper::toDomain);
    }
    
    @Override
    public boolean existePorCpf(String cpf) {
        return colaboradorJpaRepository.existsByCpf(cpf);
    }

    @Override
    public Page<ColaboradorModel> findAll(ColaboradorFilter filter, Pageable pageable) {
        return colaboradorJpaRepository.findAll(ColaboradorSpecification.withFilters(filter), pageable)
                .map(colaboradorMapper::toDomain);
    }
    
    @Override
    public void excluir(ColaboradorModel colaboradorModel) {
        colaboradorJpaRepository.delete(colaboradorMapper.toEntity(colaboradorModel));
    }

    @Override
    public Long quantidadePorStatus(StatusColaborador statusColaborador) {
        return colaboradorJpaRepository.quantidadePorStatus(statusColaborador);
    }
} 