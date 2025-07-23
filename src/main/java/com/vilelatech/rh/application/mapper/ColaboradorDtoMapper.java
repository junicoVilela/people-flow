package com.vilelatech.rh.application.mapper;

import com.vilelatech.rh.application.dto.colaborador.ColaboradorRequest;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorResponse;
import com.vilelatech.rh.application.dto.colaborador.ColaboradorUpdateRequest;
import com.vilelatech.rh.domain.model.ColaboradorModel;
import com.vilelatech.rh.domain.model.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ColaboradorDtoMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mapping(source = "usuario.nome", target = "nome")
    @Mapping(source = "usuario.email", target = "email")
    @Mapping(target = "cargo", expression = "java(colaboradorModel.getCargo() != null ? colaboradorModel.getCargo() : \"\")")
    @Mapping(target = "departamento", expression = "java(colaboradorModel.getDepartamento() != null ? colaboradorModel.getDepartamento() : \"\")")
    public abstract ColaboradorResponse toResponse(ColaboradorModel colaboradorModel);

    @Mapping(target = "dataCriacao", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "dataAtualizacao", expression = "java(java.time.LocalDateTime.now())")
    public abstract ColaboradorModel toDomain(ColaboradorRequest request);
    
    @Mapping(target = "dataAtualizacao", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "usuario.nome", source = "nome")
    @Mapping(target = "usuario.dataAtualizacao", expression = "java(java.time.LocalDateTime.now())")
    public abstract void updateColaborador(ColaboradorUpdateRequest request, @MappingTarget ColaboradorModel colaboradorModel);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "senhaHash", expression = "java(passwordEncoder.encode(request.getSenha()))")
    @Mapping(target = "role", constant = "COLABORADOR")
    @Mapping(target = "ativo", constant = "true")
    @Mapping(target = "dataCriacao", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "dataAtualizacao", expression = "java(java.time.LocalDateTime.now())")
    public abstract UsuarioModel toUsuarioModel(ColaboradorRequest request);
    

} 