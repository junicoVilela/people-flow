package com.vilelatech.rh.application.usecase.colaborador;

import com.vilelatech.rh.application.dto.colaborador.ColaboradorFilter;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorRequest;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorResponse;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorUpdateRequest;
import com.vilelatech.rh.application.dto.colaborador.InativacaoRequest;
import com.vilelatech.rh.application.exception.EntidadeNaoEncontradaException;
import com.vilelatech.rh.application.exception.NegocioException;
import com.vilelatech.rh.application.mapper.ColaboradorDtoMapper;
import com.vilelatech.rh.domain.model.ColaboradorModel;
import com.vilelatech.rh.domain.model.UsuarioModel;
import com.vilelatech.rh.domain.model.enums.Role;
import com.vilelatech.rh.domain.model.enums.StatusColaborador;
import com.vilelatech.rh.ports.CargoRepository;
import com.vilelatech.rh.ports.ColaboradorRepository;
import com.vilelatech.rh.ports.DepartamentoRepository;
import com.vilelatech.rh.ports.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ColaboradorUseCase {
    private final ColaboradorRepository colaboradorRepository;
    private final UsuarioRepository usuarioRepository;
    private final DepartamentoRepository departamentoRepository;
    private final CargoRepository cargoRepository;
    private final PasswordEncoder passwordEncoder;
    private final ColaboradorDtoMapper colaboradorDtoMapper;

    @Transactional
    public void cadastrar(ColaboradorRequest request) {
        if (usuarioRepository.existePorEmail(request.getEmail())) {
            throw new NegocioException("Email já cadastrado: " + request.getEmail());
        }

        if (colaboradorRepository.existePorCpf(request.getCpf())) {
            throw new NegocioException("CPF já cadastrado: " + request.getCpf());
        }

        var departamento = departamentoRepository.buscarPorId(request.getDepartamentoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Departamento não encontrado com ID: " + request.getDepartamentoId()));

        var cargo = cargoRepository.buscarPorId(request.getCargoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cargo não encontrado com ID: " + request.getCargoId()));

        UsuarioModel usuario = colaboradorDtoMapper.toUsuarioModel(request);
        usuario.setSenhaHash(passwordEncoder.encode(request.getSenha()));
        usuario.setRole(Role.COLABORADOR);
        usuario.setAtivo(true);
        usuario = usuarioRepository.salvar(usuario);

        ColaboradorModel colaboradorModel = colaboradorDtoMapper.toDomain(request);
        colaboradorModel.setUsuarioId(usuario.getId());
        colaboradorModel.setDepartamentoId(departamento.getId());
        colaboradorModel.setCargoId(cargo.getId());
        colaboradorRepository.salvar(colaboradorModel);
    }

    public Page<ColaboradorResponse> listar(ColaboradorFilter colaboradorFilter, Pageable pageable) {
        return colaboradorRepository.listar(colaboradorFilter, pageable)
                .map(colaboradorDtoMapper::toResponse);
    }

    public ColaboradorResponse buscarPorId(Long id) {
        ColaboradorModel colaboradorModel = colaboradorRepository.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Colaborador", id));

        return colaboradorDtoMapper.toResponse(colaboradorModel);
    }

    @Transactional
    public void atualizar(Long id, ColaboradorUpdateRequest request) {
        ColaboradorModel colaboradorModel = colaboradorRepository.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Colaborador", id));

        UsuarioModel usuario = usuarioRepository.buscarPorId(colaboradorModel.getUsuarioId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuario", colaboradorModel.getUsuarioId()));

        colaboradorModel.setUsuario(usuario);
        colaboradorDtoMapper.updateColaborador(request, colaboradorModel);

        if (request.getSenha() != null && !request.getSenha().isEmpty()) {
            usuario.setSenhaHash(passwordEncoder.encode(request.getSenha()));
        }

        usuarioRepository.salvar(usuario);
        colaboradorRepository.salvar(colaboradorModel);
    }

    @Transactional
    public void inativar(Long id, InativacaoRequest request) {
        if (request.getDataDemissao() == null) {
            throw new NegocioException("Data de demissão é obrigatória");
        }

        ColaboradorModel colaboradorModel = colaboradorRepository.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Colaborador", id));

        if (colaboradorModel.getStatus() == StatusColaborador.DESLIGADO) {
            throw new NegocioException("Colaborador já está desligado");
        }

        UsuarioModel usuario = usuarioRepository.buscarPorId(colaboradorModel.getUsuarioId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuario", colaboradorModel.getUsuarioId()));

        usuario.setAtivo(false);
        usuario.setDataAtualizacao(LocalDateTime.now());
        usuarioRepository.salvar(usuario);

        colaboradorModel.setStatus(StatusColaborador.DESLIGADO);
        colaboradorModel.setDataDemissao(request.getDataDemissao());
        colaboradorModel.setDataAtualizacao(LocalDateTime.now());
        colaboradorModel.setUsuario(usuario);

        colaboradorRepository.salvar(colaboradorModel);
    }
    
    @Transactional
    public void excluir(Long id) {
        ColaboradorModel colaboradorModel = colaboradorRepository.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Colaborador", id));
        
        colaboradorRepository.excluir(colaboradorModel);
        
        if (colaboradorModel.getUsuarioId() != null) {
            usuarioRepository.excluirPorId(colaboradorModel.getUsuarioId());
        }
    }

    @Transactional
    public Long quantidadePorStatus(StatusColaborador statusColaborador) {
        return colaboradorRepository.quantidadePorStatus(statusColaborador);
    }
} 