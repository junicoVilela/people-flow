package com.vilelatech.rh.ports;

import com.vilelatech.rh.domain.model.DepartamentoModel;

import java.util.List;
import java.util.Optional;

public interface DepartamentoRepository {
    DepartamentoModel save(DepartamentoModel departamentoModel);
    Optional<DepartamentoModel> findById(Long id);
    List<DepartamentoModel> findAll();
    List<DepartamentoModel> findByAtivoTrue();
    boolean existsByNomeAndAtivoTrue(String nome);
    boolean existsByNomeAndAtivoTrueAndIdNot(String nome, Long id);
    void deleteById(Long id);
} 