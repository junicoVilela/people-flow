package com.vilelatech.rh.ports;

import com.vilelatech.rh.application.dto.colaborador.ColaboradorFilter;
import com.vilelatech.rh.domain.model.ColaboradorModel;
import com.vilelatech.rh.domain.model.enums.StatusColaborador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ColaboradorRepository {
    void salvar(ColaboradorModel colaboradorModel);
    Optional<ColaboradorModel> buscarPorId(Long id);
    boolean existePorCpf(String cpf);
    Page<ColaboradorModel> findAll(ColaboradorFilter filter, Pageable pageable);
    void excluir(ColaboradorModel colaboradorModel);
    Long quantidadePorStatus(StatusColaborador statusColaborador);
}