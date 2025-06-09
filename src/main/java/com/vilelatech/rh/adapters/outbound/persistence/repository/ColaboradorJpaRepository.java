package com.vilelatech.rh.adapters.outbound.persistence.repository;

import com.vilelatech.rh.adapters.outbound.persistence.entity.ColaboradorEntity;
import com.vilelatech.rh.domain.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColaboradorJpaRepository extends JpaRepository<ColaboradorEntity, Long> {
    Optional<ColaboradorEntity> findByUsuarioId(Long usuarioId);
    List<ColaboradorEntity> findByStatus(Status status);
    boolean existsByCpf(String cpf);
} 