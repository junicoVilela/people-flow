package com.vilelatech.rh.adapters.outbound.persistence.repository;

import com.vilelatech.rh.adapters.outbound.persistence.entity.Colaborador;
import com.vilelatech.rh.domain.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColaboradorJpaRepository extends JpaRepository<Colaborador, Long> {
    Optional<Colaborador> findByUsuarioId(Long usuarioId);
    List<Colaborador> findByStatus(Status status);
    boolean existsByCpf(String cpf);
} 