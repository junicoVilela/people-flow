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
@Slf4j
public class CargoUseCase {

    private final CargoRepository cargoRepository;
    private final DepartamentoRepository departamentoRepository;
    private final CargoDtoMapper cargoDtoMapper;

    @Transactional(readOnly = true)
    public List<CargoResponse> listar() {
        log.debug("Listando todos os cargos");
        List<CargoModel> cargos = cargoRepository.findByAtivoTrue();
        return cargoDtoMapper.modelsToResponses(cargos);
    }

    @Transactional(readOnly = true)
    public CargoResponse buscarPorId(Long id) {
        log.debug("Buscando cargo por ID: {}", id);
        CargoModel cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cargo não encontrado com ID: " + id));
        return cargoDtoMapper.modelToResponse(cargo);
    }

    @Transactional
    public CargoResponse criar(CargoRequest request) {
        log.debug("Criando novo cargo: {}", request.getNome());
        
        // Verificar se o departamento existe
        departamentoRepository.findById(request.getDepartamentoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Departamento não encontrado com ID: " + request.getDepartamentoId()));
        
        // Verificar se já existe cargo com o mesmo nome
        if (cargoRepository.existsByNomeAndAtivoTrue(request.getNome())) {
            throw new IllegalArgumentException("Já existe um cargo ativo com o nome: " + request.getNome());
        }
        
        CargoModel cargoModel = cargoDtoMapper.requestToModel(request);
        cargoModel.setAtivo(true);
        CargoModel cargoSalvo = cargoRepository.save(cargoModel);
        
        log.info("Cargo criado com sucesso: ID={}, Nome={}", cargoSalvo.getId(), cargoSalvo.getNome());
        return cargoDtoMapper.modelToResponse(cargoSalvo);
    }

    @Transactional
    public CargoResponse atualizar(Long id, CargoRequest request) {
        log.debug("Atualizando cargo ID: {}", id);
        
        CargoModel cargoExistente = cargoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cargo não encontrado com ID: " + id));
        
        // Verificar se o departamento existe
        departamentoRepository.findById(request.getDepartamentoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Departamento não encontrado com ID: " + request.getDepartamentoId()));
        
        // Verificar se já existe outro cargo com o mesmo nome
        if (cargoRepository.existsByNomeAndAtivoTrueAndIdNot(request.getNome(), id)) {
            throw new IllegalArgumentException("Já existe outro cargo ativo com o nome: " + request.getNome());
        }
        
        cargoExistente.setNome(request.getNome());
        cargoExistente.setDescricao(request.getDescricao());
        cargoExistente.setNivel(request.getNivel());
        cargoExistente.setDepartamentoId(request.getDepartamentoId());
        cargoExistente.setSalarioBase(request.getSalarioBase());
        cargoExistente.setAtivo(request.getAtivo());
        
        CargoModel cargoAtualizado = cargoRepository.save(cargoExistente);
        
        log.info("Cargo atualizado com sucesso: ID={}, Nome={}", cargoAtualizado.getId(), cargoAtualizado.getNome());
        return cargoDtoMapper.modelToResponse(cargoAtualizado);
    }

    @Transactional
    public void inativar(Long id) {
        log.debug("Inativando cargo ID: {}", id);
        
        CargoModel cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cargo não encontrado com ID: " + id));
        
        // Soft delete - marcar como inativo
        cargo.setAtivo(false);
        cargoRepository.save(cargo);
        
        log.info("Cargo inativado com sucesso: ID={}, Nome={}", cargo.getId(), cargo.getNome());
    }
} 