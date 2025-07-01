package com.vilelatech.rh.ports;

import com.vilelatech.rh.domain.model.ColaboradorModel;
import com.vilelatech.rh.domain.model.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ColaboradorRepository {
    ColaboradorModel save(ColaboradorModel colaboradorModel);
    Optional<ColaboradorModel> findById(Long id);
    Optional<ColaboradorModel> findByUsuarioId(Long usuarioId);
    List<ColaboradorModel> findAll();
    Page<ColaboradorModel> findAll(Pageable pageable);
    List<ColaboradorModel> findByStatus(Status status);
    boolean existsByCpf(String cpf);
    
    // Métodos otimizados com JOIN FETCH
    Page<ColaboradorModel> findAllWithUsuario(Pageable pageable);
    Optional<ColaboradorModel> findByIdWithUsuario(Long id);
} 