package com.vilelatech.rh.application.usecase.cargo;

import com.vilelatech.rh.application.dto.cargo.CargoRequest;
import com.vilelatech.rh.application.dto.cargo.CargoResponse;
import com.vilelatech.rh.application.exception.EntidadeNaoEncontradaException;
import com.vilelatech.rh.application.mapper.CargoDtoMapper;
import com.vilelatech.rh.domain.model.CargoModel;
import com.vilelatech.rh.ports.CargoRepository;
import com.vilelatech.rh.ports.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CargoUseCase {

    private final CargoRepository cargoRepository;
    private final DepartamentoRepository departamentoRepository;
    private final CargoDtoMapper cargoDtoMapper;

    @Transactional(readOnly = true)
    public List<CargoResponse> listar() {
        List<CargoModel> cargos = cargoRepository.findByAtivoTrue();
        return cargoDtoMapper.modelsToResponses(cargos);
    }

    @Transactional(readOnly = true)
    public CargoResponse buscarPorId(Long id) {
        CargoModel cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cargo não encontrado com ID: " + id));
        return cargoDtoMapper.modelToResponse(cargo);
    }

    @Transactional
    public void criar(CargoRequest request) {
        departamentoRepository.findById(request.getDepartamentoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Departamento não encontrado com ID: " + request.getDepartamentoId()));
        
        if (cargoRepository.existsByNomeAndAtivoTrue(request.getNome())) {
            throw new IllegalArgumentException("Já existe um cargo ativo com o nome: " + request.getNome());
        }
        
        CargoModel cargoModel = cargoDtoMapper.requestToModel(request);
        cargoModel.setAtivo(true);
        cargoRepository.save(cargoModel);
    }

    @Transactional
    public void atualizar(Long id, CargoRequest request) {
        CargoModel cargoExistente = cargoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cargo não encontrado com ID: " + id));
        
        departamentoRepository.findById(request.getDepartamentoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Departamento não encontrado com ID: " + request.getDepartamentoId()));
        
        if (cargoRepository.existsByNomeAndAtivoTrueAndIdNot(request.getNome(), id)) {
            throw new IllegalArgumentException("Já existe outro cargo ativo com o nome: " + request.getNome());
        }
        
        cargoDtoMapper.updateModelFromRequest(request, cargoExistente);
        
        cargoRepository.save(cargoExistente);
    }

    @Transactional
    public void inativar(Long id) {
        CargoModel cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cargo não encontrado com ID: " + id));
        
        cargo.setAtivo(false);
        cargoRepository.save(cargo);
    }
} 