package com.vilelatech.rh.ports;

import com.vilelatech.rh.domain.model.CargoModel;

import java.util.List;
import java.util.Optional;

public interface CargoRepository {
    CargoModel save(CargoModel cargoModel);
    Optional<CargoModel> findById(Long id);
    List<CargoModel> findByAtivoTrue();
    boolean existsByNomeAndAtivoTrue(String nome);
    boolean existsByNomeAndAtivoTrueAndIdNot(String nome, Long id);
} 