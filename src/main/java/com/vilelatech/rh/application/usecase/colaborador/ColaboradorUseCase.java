package com.vilelatech.rh.application.usecase.colaborador;

import com.vilelatech.rh.application.mapper.ColaboradorDtoMapper;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorRequest;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorResponse;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorUpdateRequest;
import com.vilelatech.rh.application.dto.colaborador.InativacaoRequest;
import com.vilelatech.rh.domain.model.ColaboradorModel;
import com.vilelatech.rh.domain.model.UsuarioModel;
import com.vilelatech.rh.domain.model.enums.Role;
import com.vilelatech.rh.domain.model.enums.Status;
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
        // Validar se email já existe
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        // Validar se CPF já existe
        if (colaboradorRepository.existsByCpf(request.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        // Criar usuário
        UsuarioModel usuario = UsuarioModel.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senhaHash(passwordEncoder.encode(request.getSenha()))
                .role(Role.COLABORADOR)
                .ativo(true)
                .dataCriacao(LocalDateTime.now())
                .dataAtualizacao(LocalDateTime.now())
                .build();

        usuario = usuarioRepository.save(usuario);

        // Converter request para domínio e ajustar dados específicos
        ColaboradorModel colaboradorModel = colaboradorDtoMapper.toDomain(request);
        colaboradorModel.setUsuarioId(usuario.getId());
        colaboradorModel.setStatus(Status.ATIVO);
        colaboradorModel.setDataCriacao(LocalDateTime.now());
        colaboradorModel.setDataAtualizacao(LocalDateTime.now());
        colaboradorModel.setUsuario(usuario);

        colaboradorRepository.save(colaboradorModel);
    }

    public List<ColaboradorResponse> listarTodos() {
        return colaboradorRepository.findAll().stream()
                .map(colaboradorDtoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<ColaboradorResponse> listarAtivos() {
        return colaboradorRepository.findByStatus(Status.ATIVO).stream()
                .map(colaboradorDtoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Page<ColaboradorResponse> listar(Pageable pageable) {
        return colaboradorRepository.findAll(pageable)
                .map(colaborador -> {
                    // Buscar dados do usuário para cada colaborador
                    UsuarioModel usuario = usuarioRepository.findById(colaborador.getUsuarioId())
                            .orElse(null);
                    colaborador.setUsuario(usuario);
                    return colaboradorDtoMapper.toResponse(colaborador);
                });
    }

    public ColaboradorResponse buscarPorId(Long id) {
        ColaboradorModel colaboradorModel = colaboradorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Colaborador não encontrado"));

        UsuarioModel usuario = usuarioRepository.findById(colaboradorModel.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        colaboradorModel.setUsuario(usuario);

        return colaboradorDtoMapper.toResponse(colaboradorModel);
    }

    @Transactional
    public void atualizar(Long id, ColaboradorUpdateRequest request) {
        ColaboradorModel colaboradorModel = colaboradorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Colaborador não encontrado"));

        UsuarioModel usuario = usuarioRepository.findById(colaboradorModel.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        // Atualizar dados do usuário
        usuario.setNome(request.getNome());
        usuario.setDataAtualizacao(LocalDateTime.now());
        usuarioRepository.save(usuario);

        // Atualizar dados do colaborador usando o mapper
        colaboradorDtoMapper.updateDomainFromDto(request, colaboradorModel);
        colaboradorModel.setDataAtualizacao(LocalDateTime.now());
        colaboradorModel.setUsuario(usuario);

        colaboradorRepository.save(colaboradorModel);
    }

    @Transactional
    public void inativar(Long id, InativacaoRequest request) {
        ColaboradorModel colaboradorModel = colaboradorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Colaborador não encontrado"));

        UsuarioModel usuario = usuarioRepository.findById(colaboradorModel.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        // Inativar usuário
        usuario.setAtivo(false);
        usuario.setDataAtualizacao(LocalDateTime.now());
        usuarioRepository.save(usuario);

        // Inativar colaborador
        colaboradorModel.setStatus(Status.DESLIGADO);
        colaboradorModel.setDataDemissao(request.getDataDemissao());
        colaboradorModel.setDataAtualizacao(LocalDateTime.now());
        colaboradorModel.setUsuario(usuario);

        colaboradorRepository.save(colaboradorModel);
    }
} 