package com.vilelatech.rh.ports;

import com.vilelatech.rh.domain.model.DepartamentoModel;
import com.vilelatech.rh.domain.model.RegistroPontoModel;

import java.util.Optional;

public interface DepartamentoRepository {
    RegistroPontoModel save(DepartamentoModel departamentoModel);
    Optional<DepartamentoModel> findById(Long id);

} 