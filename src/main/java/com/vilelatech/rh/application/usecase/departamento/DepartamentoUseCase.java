package com.vilelatech.rh.application.usecase.departamento;

import com.vilelatech.rh.application.dto.departamento.DepartamentoRequest;
import com.vilelatech.rh.application.dto.departamento.DepartamentoResponse;
import com.vilelatech.rh.application.dto.departamento.DepartamentoUpdateRequest;
import com.vilelatech.rh.application.exception.EntidadeNaoEncontradaException;
import com.vilelatech.rh.application.exception.NegocioException;
import com.vilelatech.rh.application.mapper.DepartamentoDtoMapper;
import com.vilelatech.rh.domain.model.DepartamentoModel;
import com.vilelatech.rh.ports.CargoRepository;
import com.vilelatech.rh.ports.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoUseCase {
    
    private final DepartamentoRepository departamentoRepository;
    private final CargoRepository cargoRepository;
    private final DepartamentoDtoMapper departamentoDtoMapper;

    public List<DepartamentoResponse> listarTodos() {
        List<DepartamentoModel> departamentos = departamentoRepository.findByAtivoTrue();
        List<DepartamentoResponse> responses = departamentoDtoMapper.modelsToResponses(departamentos);
        
        // Adicionar quantidade de cargos para cada departamento
        responses.forEach(response -> {
            int quantidadeCargos = cargoRepository.countByDepartamentoIdAndAtivoTrue(response.getId());
            response.setQuantidadeCargos(quantidadeCargos);
        });
        
        return responses;
    }

    public DepartamentoResponse buscarPorId(Long id) {
        DepartamentoModel departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Departamento não encontrado com ID: " + id));
        
        DepartamentoResponse response = departamentoDtoMapper.modelToResponse(departamento);
        int quantidadeCargos = cargoRepository.countByDepartamentoIdAndAtivoTrue(id);
        response.setQuantidadeCargos(quantidadeCargos);
        
        return response;
    }

    @Transactional
    public void cadastrar(DepartamentoRequest request) {
        if (departamentoRepository.existsByNomeAndAtivoTrue(request.getNome())) {
            throw new NegocioException("Já existe um departamento ativo com este nome");
        }

        DepartamentoModel departamento = departamentoDtoMapper.requestToModel(request);
        departamentoRepository.save(departamento);
    }

    @Transactional
    public void atualizar(Long id, DepartamentoUpdateRequest request) {
        DepartamentoModel departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Departamento não encontrado com ID: " + id));

        if (departamentoRepository.existsByNomeAndAtivoTrueAndIdNot(request.getNome(), id)) {
            throw new NegocioException("Já existe outro departamento ativo com este nome");
        }

        departamento.setNome(request.getNome());
        departamento.setDescricao(request.getDescricao());
        if (request.getAtivo() != null) {
            departamento.setAtivo(request.getAtivo());
        }

        departamentoRepository.save(departamento);
    }

    @Transactional
    public void inativar(Long id) {
        DepartamentoModel departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Departamento não encontrado com ID: " + id));

        // Verificar se há cargos ativos vinculados
        int quantidadeCargosAtivos = cargoRepository.countByDepartamentoIdAndAtivoTrue(id);
        if (quantidadeCargosAtivos > 0) {
            throw new NegocioException("Não é possível inativar o departamento. Existem " + quantidadeCargosAtivos + " cargo(s) ativo(s) vinculado(s).");
        }

        departamento.setAtivo(false);
        departamentoRepository.save(departamento);
    }

    @Transactional
    public void excluir(Long id) {
        DepartamentoModel departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Departamento não encontrado com ID: " + id));

        // Verificar se há cargos vinculados
        int quantidadeCargos = cargoRepository.countByDepartamentoId(id);
        if (quantidadeCargos > 0) {
            throw new NegocioException("Não é possível excluir o departamento. Existem " + quantidadeCargos + " cargo(s) vinculado(s).");
        }

        departamentoRepository.deleteById(id);
    }
} 