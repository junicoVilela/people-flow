package com.vilelatech.rh.ports;

import com.vilelatech.rh.application.dto.colaborador.ColaboradorFilter;
import com.vilelatech.rh.domain.model.ColaboradorModel;
import com.vilelatech.rh.domain.model.enums.StatusColaborador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ColaboradorRepository {
    void save(ColaboradorModel colaboradorModel);
    Optional<ColaboradorModel> findById(Long id);
    boolean existsByCpf(String cpf);
    Page<ColaboradorModel> findAll(ColaboradorFilter filter, Pageable pageable);
    void delete(ColaboradorModel colaboradorModel);
}