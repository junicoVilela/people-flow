package com.vilelatech.rh.ports;

import com.vilelatech.rh.application.dto.cargo.CargoFilter;
import com.vilelatech.rh.domain.model.CargoModel;
import com.vilelatech.rh.domain.model.enums.StatusColaborador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CargoRepository {
    CargoModel save(CargoModel cargoModel);
    Optional<CargoModel> findById(Long id);
    Page<CargoModel> findAll(CargoFilter filter, Pageable pageable);
    boolean existsByNomeAndAtivoTrue(String nome);
    boolean existsByNomeAndAtivoTrueAndIdNot(String nome, Long id);
    int countByDepartamentoId(Long departamentoId);
    int quantidadePorStatus(Boolean status);
} 