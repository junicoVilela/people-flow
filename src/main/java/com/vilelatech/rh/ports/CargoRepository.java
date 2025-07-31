package com.vilelatech.rh.ports;

import com.vilelatech.rh.application.dto.cargo.CargoFilter;
import com.vilelatech.rh.domain.model.CargoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CargoRepository {
    CargoModel salvar(CargoModel cargoModel);
    Optional<CargoModel> buscarPorId(Long id);
    Page<CargoModel> listar(CargoFilter filter, Pageable pageable);
    boolean existePorNome(String nome);
    boolean existePorNomeComIdDiferente(String nome, Long id);
    int quantidadePorDepartamentoId(Long departamentoId);
    int quantidadePorStatus(Boolean status);
} 