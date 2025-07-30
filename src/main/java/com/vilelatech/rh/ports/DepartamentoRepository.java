package com.vilelatech.rh.ports;

import com.vilelatech.rh.application.dto.departamento.DepartamentoFilter;
import com.vilelatech.rh.domain.model.DepartamentoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DepartamentoRepository {
    DepartamentoModel save(DepartamentoModel departamentoModel);
    Optional<DepartamentoModel> findById(Long id);
    List<DepartamentoModel> findAll();
    Page<DepartamentoModel> findAll(DepartamentoFilter filter, Pageable pageable);
    boolean existsByNomeAndAtivoTrue(String nome);
    boolean existsByNomeAndAtivoTrueAndIdNot(String nome, Long id);
    void deleteById(Long id);
    int quantidadePorStatus(Boolean status);
}