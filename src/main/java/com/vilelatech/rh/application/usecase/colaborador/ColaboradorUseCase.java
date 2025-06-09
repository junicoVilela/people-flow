package com.vilelatech.rh.application.usecase.colaborador;

import com.vilelatech.rh.application.mapper.ColaboradorDtoMapper;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorRequest;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorResponse;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorUpdateRequest;
import com.vilelatech.rh.application.dto.colaborador.InativacaoRequest;
import com.vilelatech.rh.domain.model.Colaborador;
import com.vilelatech.rh.domain.model.Role;
import com.vilelatech.rh.domain.model.Status;
import com.vilelatech.rh.domain.model.Usuario;
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
        Usuario usuario = Usuario.builder()
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
        Colaborador colaborador = colaboradorDtoMapper.toDomain(request);
        colaborador.setUsuarioId(usuario.getId());
        colaborador.setStatus(Status.ATIVO);
        colaborador.setDataCriacao(LocalDateTime.now());
        colaborador.setDataAtualizacao(LocalDateTime.now());
        colaborador.setUsuario(usuario);

        colaboradorRepository.save(colaborador);
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
                    Usuario usuario = usuarioRepository.findById(colaborador.getUsuarioId())
                            .orElse(null);
                    colaborador.setUsuario(usuario);
                    return colaboradorDtoMapper.toResponse(colaborador);
                });
    }

    public ColaboradorResponse buscarPorId(Long id) {
        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Colaborador não encontrado"));

        Usuario usuario = usuarioRepository.findById(colaborador.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        colaborador.setUsuario(usuario);

        return colaboradorDtoMapper.toResponse(colaborador);
    }

    @Transactional
    public void atualizar(Long id, ColaboradorUpdateRequest request) {
        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Colaborador não encontrado"));

        Usuario usuario = usuarioRepository.findById(colaborador.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        // Atualizar dados do usuário
        usuario.setNome(request.getNome());
        usuario.setDataAtualizacao(LocalDateTime.now());
        usuarioRepository.save(usuario);

        // Atualizar dados do colaborador usando o mapper
        colaboradorDtoMapper.updateDomainFromDto(request, colaborador);
        colaborador.setDataAtualizacao(LocalDateTime.now());
        colaborador.setUsuario(usuario);

        colaboradorRepository.save(colaborador);
    }

    @Transactional
    public void inativar(Long id, InativacaoRequest request) {
        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Colaborador não encontrado"));

        Usuario usuario = usuarioRepository.findById(colaborador.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        // Inativar usuário
        usuario.setAtivo(false);
        usuario.setDataAtualizacao(LocalDateTime.now());
        usuarioRepository.save(usuario);

        // Inativar colaborador
        colaborador.setStatus(Status.DESLIGADO);
        colaborador.setDataDemissao(request.getDataDemissao());
        colaborador.setDataAtualizacao(LocalDateTime.now());
        colaborador.setUsuario(usuario);

        colaboradorRepository.save(colaborador);
    }
} 