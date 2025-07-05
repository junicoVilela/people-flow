package com.vilelatech.rh.ports;

import com.vilelatech.rh.domain.model.CargoModel;
import com.vilelatech.rh.domain.model.DepartamentoModel;
import com.vilelatech.rh.domain.model.RegistroPontoModel;

import java.util.Optional;

public interface CargoRepository {
    CargoModel save(CargoModel cargoModel);
    Optional<DepartamentoModel> findById(Long id);

} 