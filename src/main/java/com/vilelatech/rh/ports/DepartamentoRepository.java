package com.vilelatech.rh.ports;

import com.vilelatech.rh.application.dto.departamento.DepartamentoFilter;
import com.vilelatech.rh.domain.model.DepartamentoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DepartamentoRepository {
    DepartamentoModel salvar(DepartamentoModel departamentoModel);
    Optional<DepartamentoModel> buscarPorId(Long id);
    Page<DepartamentoModel> listar(DepartamentoFilter filter, Pageable pageable);
    boolean existePorNome(String nome);
    boolean existePorNomeComIdDiferente(String nome, Long id);
    void deletar(Long id);
    int quantidadePorStatus(Boolean status);
}