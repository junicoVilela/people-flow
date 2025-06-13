package com.vilelatech.rh.adapters.outbound.persistence.repository;

import com.vilelatech.rh.adapters.outbound.persistence.entity.RegistroPonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RegistroPontoJpaRepository extends JpaRepository<RegistroPonto, Long> {
    List<RegistroPonto> findByColaboradorId(Long colaboradorId);
    List<RegistroPonto> findByColaboradorIdAndDataRegistroBetween(Long colaboradorId, LocalDate inicio, LocalDate fim);
} 