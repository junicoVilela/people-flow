package com.vilelatech.rh.ports;

import com.vilelatech.rh.domain.model.RegistroPontoModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RegistroPontoRepository {
    RegistroPontoModel save(RegistroPontoModel registroPonto);
    Optional<RegistroPontoModel> findById(Long id);
    List<RegistroPontoModel> findByColaboradorId(Long colaboradorId);
    List<RegistroPontoModel> findByColaboradorIdAndDataRegistroBetween(Long colaboradorId, LocalDate inicio, LocalDate fim);
} 