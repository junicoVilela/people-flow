package com.vilelatech.rh.ports;

import com.vilelatech.rh.domain.model.Colaborador;
import com.vilelatech.rh.domain.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ColaboradorRepository {
    Colaborador save(Colaborador colaborador);
    Optional<Colaborador> findById(Long id);
    Optional<Colaborador> findByUsuarioId(Long usuarioId);
    List<Colaborador> findAll();
    Page<Colaborador> findAll(Pageable pageable);
    List<Colaborador> findByStatus(Status status);
    boolean existsByCpf(String cpf);
} 