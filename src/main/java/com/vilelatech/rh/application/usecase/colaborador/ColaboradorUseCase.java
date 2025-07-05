package com.vilelatech.rh.application.usecase.colaborador;

import com.vilelatech.rh.application.mapper.ColaboradorDtoMapper;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorRequest;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorResponse;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorUpdateRequest;
import com.vilelatech.rh.application.dto.colaborador.InativacaoRequest;
import com.vilelatech.rh.application.exception.EntidadeNaoEncontradaException;
import com.vilelatech.rh.application.exception.NegocioException;
import com.vilelatech.rh.domain.model.ColaboradorModel;
import com.vilelatech.rh.domain.model.UsuarioModel;
import com.vilelatech.rh.domain.model.enums.Role;
import com.vilelatech.rh.domain.model.enums.StatusColaborador;
import com.vilelatech.rh.ports.ColaboradorRepository;
import com.vilelatech.rh.ports.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColaboradorUseCase {
    private final ColaboradorRepository colaboradorRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final ColaboradorDtoMapper colaboradorDtoMapper;

    @Transactional
    public void cadastrar(ColaboradorRequest request) {
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new NegocioException("Email já cadastrado: " + request.getEmail());
        }

        if (colaboradorRepository.existsByCpf(request.getCpf())) {
            throw new NegocioException("CPF já cadastrado: " + request.getCpf());
        }

        UsuarioModel usuario = colaboradorDtoMapper.toUsuarioModel(request);
        usuario = usuarioRepository.save(usuario);

        ColaboradorModel colaboradorModel = colaboradorDtoMapper.toDomain(request);
        colaboradorModel.setUsuarioId(usuario.getId());
        colaboradorModel.setUsuario(usuario);
        
        colaboradorRepository.save(colaboradorModel);
    }

    public List<ColaboradorResponse> listarAtivos() {
        return colaboradorRepository.findByStatus(StatusColaborador.ATIVO).stream()
                .map(colaboradorDtoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Page<ColaboradorResponse> listar(Pageable pageable) {
        return colaboradorRepository.findAllWithUsuario(pageable)
                .map(colaboradorDtoMapper::toResponse);
    }

    public ColaboradorResponse buscarPorId(Long id) {
        ColaboradorModel colaboradorModel = colaboradorRepository.findByIdWithUsuario(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Colaborador", id));

        return colaboradorDtoMapper.toResponse(colaboradorModel);
    }

    @Transactional
    public void atualizar(Long id, ColaboradorUpdateRequest request) {
        ColaboradorModel colaboradorModel = colaboradorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Colaborador", id));

        UsuarioModel usuario = usuarioRepository.findById(colaboradorModel.getUsuarioId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuario", colaboradorModel.getUsuarioId()));

        colaboradorModel.setUsuario(usuario);
        colaboradorDtoMapper.updateColaborador(request, colaboradorModel);

        usuarioRepository.save(colaboradorModel.getUsuario());
        colaboradorRepository.save(colaboradorModel);
    }

    @Transactional
    public void inativar(Long id, InativacaoRequest request) {
        ColaboradorModel colaboradorModel = colaboradorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Colaborador", id));

        UsuarioModel usuario = usuarioRepository.findById(colaboradorModel.getUsuarioId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuario", colaboradorModel.getUsuarioId()));

        // Inativar usuário
        usuario.setAtivo(false);
        usuario.setDataAtualizacao(LocalDateTime.now());
        usuarioRepository.save(usuario);

        // Inativar colaborador
        colaboradorModel.setStatus(StatusColaborador.DESLIGADO);
        colaboradorModel.setDataDemissao(request.getDataDemissao());
        colaboradorModel.setDataAtualizacao(LocalDateTime.now());
        colaboradorModel.setUsuario(usuario);

        colaboradorRepository.save(colaboradorModel);
    }
    
    @Transactional
    public void excluir(Long id) {
        ColaboradorModel colaboradorModel = colaboradorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Colaborador", id));
        
        colaboradorRepository.delete(colaboradorModel);
        
        if (colaboradorModel.getUsuarioId() != null) {
            usuarioRepository.deleteById(colaboradorModel.getUsuarioId());
        }
    }
} 