package com.vilelatech.rh.ports;

import com.vilelatech.rh.domain.model.RegistroPonto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RegistroPontoRepository {
    RegistroPonto save(RegistroPonto registroPonto);
    Optional<RegistroPonto> findById(Long id);
    List<RegistroPonto> findByColaboradorId(Long colaboradorId);
    List<RegistroPonto> findByColaboradorIdAndDataRegistroBetween(Long colaboradorId, LocalDate inicio, LocalDate fim);
} 