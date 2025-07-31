package com.vilelatech.rh.application.usecase.cargo;

import com.vilelatech.rh.application.dto.cargo.CargoFilter;
import com.vilelatech.rh.application.dto.cargo.CargoRequest;
import com.vilelatech.rh.application.dto.cargo.CargoResponse;
import com.vilelatech.rh.application.exception.EntidadeNaoEncontradaException;
import com.vilelatech.rh.application.mapper.CargoDtoMapper;
import com.vilelatech.rh.domain.model.CargoModel;
import com.vilelatech.rh.ports.CargoRepository;
import com.vilelatech.rh.ports.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CargoUseCase {

    private final CargoRepository cargoRepository;
    private final DepartamentoRepository departamentoRepository;
    private final CargoDtoMapper cargoDtoMapper;

    @Transactional(readOnly = true)
    public Page<CargoResponse> listar(CargoFilter filter, Pageable pageable) {
        Page<CargoModel> cargos = cargoRepository.listar(filter, pageable);
        return cargos.map(cargoDtoMapper::modelToResponse);
    }

    @Transactional(readOnly = true)
    public CargoResponse buscarPorId(Long id) {
        CargoModel cargo = cargoRepository.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cargo não encontrado com ID: " + id));
        return cargoDtoMapper.modelToResponse(cargo);
    }

    @Transactional
    public void cadastrar(CargoRequest request) {
        departamentoRepository.buscarPorId(request.getDepartamentoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Departamento não encontrado com ID: " + request.getDepartamentoId()));
        
        if (cargoRepository.existePorNome(request.getNome())) {
            throw new IllegalArgumentException("Já existe um cargo com o nome: " + request.getNome());
        }
        
        CargoModel cargoModel = cargoDtoMapper.requestToModel(request);
        cargoModel.setAtivo(true);
        cargoRepository.salvar(cargoModel);
    }

    @Transactional
    public void atualizar(Long id, CargoRequest request) {
        CargoModel cargoExistente = cargoRepository.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cargo não encontrado com ID: " + id));
        
        departamentoRepository.buscarPorId(request.getDepartamentoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Departamento não encontrado com ID: " + request.getDepartamentoId()));
        
        if (cargoRepository.existePorNomeComIdDiferente(request.getNome(), id)) {
            throw new IllegalArgumentException("Já existe outro cargo ativo com o nome: " + request.getNome());
        }
        
        cargoDtoMapper.updateModelFromRequest(request, cargoExistente);
        
        cargoRepository.salvar(cargoExistente);
    }

    @Transactional
    public void inativar(Long id) {
        CargoModel cargo = cargoRepository.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cargo não encontrado com ID: " + id));
        
        cargo.setAtivo(false);
        cargoRepository.salvar(cargo);
    }

    @Transactional
    public int quantidadePorStatus(Boolean status) {
        return cargoRepository.quantidadePorStatus(status);
    }
} 